#include <iostream>
#include <string>
#include <cstring> // Include the <cstring> header for memset
using namespace std;

const int LEN = 1e5 + 5;

long long int n, k;
string s;
long long int dp[LEN][2];

long long int solve(int pos, int tight) {
    if (pos == int(s.size())) {
        return 1;
    }

    if (dp[pos][tight] != -1)
        return dp[pos][tight];

    int lim = (tight ? s[pos] - '0' : 1);
    long long int ans = 0;

    for (int i = 0; i <= lim; i++) {
        ans += (1 + (i == 1)) * solve(pos + 1, (i == lim) & tight);
        ans %= 1000000007;
    }

    return dp[pos][tight] = ans;
}

int main() {
    s = "10";
    memset(dp, -1, sizeof(dp)); // Using memset to initialize dp with -1
    long long int result = solve(0, 1);
    cout << "Result: " << result << endl;

    return 0;
}
