#include <iostream>

// Function to calculate the greatest common divisor (GCD)
int gcd(int a, int b) {
    if (b == 0)
        return a;
    return gcd(b, a % b);
}

// Function to calculate the count of required pairs using the Euler Totient Function
int KGCD(int N, int K) {
    if (K == 1)
        return N * N;

    int count = 0;

    for (int i = 1; i <= N / K; i++) {
        if (gcd(i, K) == 1)
            count++;
    }

    return count ;
}

int main() {
    int N, K;
    std::cout << "Enter the value of N: ";
    std::cin >> N;
    std::cout << "Enter the value of K: ";
    std::cin >> K;

    int pairCount = KGCD(N, K);
    std::cout << "Number of pairs (x, y) satisfying GCD(x, y) = K: " << pairCount << std::endl;

    return 0;
}
