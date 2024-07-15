#include <bits/stdc++.h>
using namespace std;

#define vi vector<int>
#define read(v) for (auto &x : v) cin >> x

int main() {
    ios::sync_with_stdio(0); cin.tie(0);
    int t = 1;
    cin >> t;

    while (t--) {
        int n, m;
        cin >> n >> m;
        string s;
        cin >> s;
        vi a(m, 0);
        read(a);
        string s2;
        cin >> s2;

        // Sort the string s2 to get lexicographically smallest order
        sort(s2.begin(), s2.end());

        // Map to count frequency of each index in the array a
        map<int, int> mp;
        for (auto it : a) {
            mp[it]++;
        }

        // Calculate the extra positions to be excluded from s2
        int extra = 0;
        for (auto it : mp) {
            extra = extra + it.second - 1;
        }

        // Remove extra characters from the end of s2
        s2 = s2.substr(0, m - extra);

        // Replace characters in s at specified positions with characters from s2
        int i = 0;
        for (auto it : mp) {
            int pos = it.first;
            s[pos - 1] = s2[i];
            i++;
        }

        // Output the resulting string s
        cout << s << endl;
    }

    return 0;
}
