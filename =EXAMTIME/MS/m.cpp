#include <iostream>
using namespace std;

const int MOD = 1000000007;

long long countValidPasswords(int n, int k) {
    // Initialize result as 26^n
    long long result = 1;
    for (int i = 0; i < n; i++) {
        result = (result * 26) % MOD;
    }

    // Calculate the number of passwords with k consecutive equal characters
    for (int i = 1; i < k; i++) {
        result -= (26 - i) * 1LL * ((long long)pow(25, n - i, MOD)) % MOD;
        result = (result + MOD) % MOD;
    }

    return result;
}

int main() {
    int n, k;
    cin >> n >> k;

    long long result = countValidPasswords(n, k);
    cout << result << endl;

    return 0;
}
