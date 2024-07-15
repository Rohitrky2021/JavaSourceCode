#include <bits/stdc++.h>
using namespace std;


int main() {
    int n;
    cin >> n;


    if (n == 1) {
        string singleString;
        cin >> singleString;
        cout << 1 << endl;
        return 0;
    }


    vector<string> arr(n);
    for (auto &v : arr)
        cin >> v;


    map<int, multiset<int>> mxHash;
    vector<int> hash(n);
    int ans = 0;
   
    for (int i = 0; i < n; i++) {
        for (auto v : arr[i]) {
            hash[i] ^= (1ll << (v - 'a'));
        }
        mxHash[hash[i]].insert((int)arr[i].size());
    }


    for (int i = 0; i < n; i++) {
        int hs = hash[i];
        mxHash[hs].erase(mxHash[hs].find((int)arr[i].size()));
        if (!mxHash[hs].empty()) {
            ans = max(ans, (int)arr[i].size() + (*--mxHash[hs].end()));
        }
        for (int mid = 0; mid < 26; mid++) {
            if (mxHash.count(hs ^ (1ll << mid)) and !mxHash[hs^(1ll<<mid)].empty()) {
                ans = max(ans, (int)arr[i].size() + (*--mxHash[hs ^ (1ll << mid)].end()));
            }
        }
        mxHash[hs].insert(arr[i].size());
    }


    cout << ans << endl;


    return 0;
}
