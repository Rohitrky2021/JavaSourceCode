#include <iostream>
#include <cstring>
#include <string>

using namespace std;

const int N = 1e4 + 5;
const int MOD = 1000000007;

string s;
int dp[N][105];
int d;

int solve(int pos, int cnt, int t) {
    if (pos == int(s.size()))
        return cnt;

    if (dp[pos][cnt][t] != -1)
        return dp[pos][cnt][t];

    int lim = t ? s[pos] - '0' : 9;
    int ans = 0;

    for (int i = 0; i <= lim; ++i) {
        ans += solve(pos + 1, (cnt + i) % d, t && (i == lim));
        ans %= MOD;
    }

    return dp[pos][cnt][t] = ans;
}

int main() {
    cin >> s >> d;

    memset(dp, -1, sizeof(dp));
    int result = (solve(0, 0, 1) - 1 + MOD) % MOD;

    cout << result << endl;

    return 0;
}
