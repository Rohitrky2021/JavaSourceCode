#include <iostream>
#include <cmath>

using namespace std;

long findSumOfConcatenatedValues(long A[], int N) {
    long MOD = 998244353;
    long sum = 0;
    for (int i = 0; i < N; i++) {
        for (int j = i + 1; j < N; j++) {
            long concatenatedValue = A[i] * pow(10, int(log10(A[j])) + 1) + A[j];
            sum = (sum + concatenatedValue) % MOD;
        }
    }
    return sum;
}

int main() {
    long testCase1[] = {3, 14, 15};
    long testCase2[] = {11, 5, 1, 100, 10};

    cout << findSumOfConcatenatedValues(testCase1, 3) << endl; // Expected output: 2044
    cout << findSumOfConcatenatedValues(testCase2, 5) << endl; // Expected output: 29317

    return 0;
}
