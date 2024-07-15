#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <cstring>
#include <numeric> // Include this header for iota

using namespace std;

class Solution {
public:
    string processString(int n, const string &s) {
        vector<int> cnts(26, 0);
        for (char c : s) cnts[c - 'a']++;
        
        vector<char> vals(n + 1);
        vals[0] = 'a' - 1;
        int ind = 1;
        for (int i = 0; i < 26; ++i) {
            while (cnts[i]-- > 0) vals[ind++] = 'a' + i;
        }
        
        if (vals[n] != vals[n - 1]) {
            return string(1, vals[n]);
        }
        
        vector<int> nexts(n + 1, -1);
        vector<int> lasts(n + 1);
        iota(lasts.begin(), lasts.end(), 0);
        vector<bool> changes(n + 1, false);
        
        int start = 0;
        for (int i = 1; i <= n; ++i) {
            changes[i] = vals[i] != vals[i - 1];
            if (changes[i]) start = i;
        }
        
        int next_start = start;
        int i = 0, j = start;
        while (i < n) {
            if (j > n) {
                start = next_start;
                j = start;
            } else if (i >= start) {
                start = j;
                next_start = start;
            } else {
                nexts[lasts[j]] = i;
                lasts[j] = lasts[i];
                changes[j] = j == start || changes[i];
                if (changes[j]) next_start = j;
                i++;
                j++;
            }
        }
        
        string result;
        int v = n;
        while (v > 0) {
            result.push_back(vals[v]);
            v = nexts[v];
        }
        return result;
    }
};

int main() {
    int t;
    cin >> t;
    Solution solution;
    while (t-- > 0) {
        int n;
        string s;
        cin >> n >> s;
        string result = solution.processString(n, s);
        cout << result << endl;
    }
    return 0;
}
