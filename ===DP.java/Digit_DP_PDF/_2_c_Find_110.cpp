#include <bits/stdc++.h>
using namespace std;

#define lli long long int

string s;
lli dp[65][4][2];

lli solve(int pos, int st, int t) {
    if (pos == int(s.size())) 
        return (st == 3);

    if (dp[pos][st][t] != -1) 
        return dp[pos][st][t];

    int lim = (t == 1) ? s[pos] - '0' : 1;
    int nt = t;
    lli ans = 0;

    for (int i = 0; i <= lim; i++) {
        if (i != lim)
            nt = 0;
        else
            nt = t;

        int nst;

        if (i == 0) {
            if (st == 0)
                nst = 0;
            else if (st == 1)
                nst = 0;
            else if (st == 2)
                nst = 3;
            else if (st == 3)
                nst = 3;
        } else {
            if (st == 0)
                nst = 1;
            else if (st == 1)
                nst = 2;
            else if (st == 2)
                nst = 2;
            else if (st == 3)
                nst = 3;
        }
        ans += solve(pos + 1, nst, nt);
    }

    return dp[pos][st][t] = ans;
}

int main() {
    lli L = 1; // Example lower bound
    lli R = 13; // Example upper bound
    
    // Convert L - 1 to binary
    string LBinary = bitset<64>(L - 1).to_string();
    // Convert R to binary
    string RBinary = bitset<64>(R).to_string();
    
    memset(dp, -1, sizeof(dp)); // Initialize dp array
    
    s = RBinary;
    lli ans1 = solve(0, 0, 1); // Find count for R
    s = LBinary;
    memset(dp, -1, sizeof(dp)); // Reset dp array
    lli ans2 = solve(0, 0, 1); // Find count for L - 1

    cout << "Number of numbers between " << L << " and " << R << " with '110' as substring: " << ans1 - ans2 << endl;
    
    return 0;
}
