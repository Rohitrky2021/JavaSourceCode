#include <iostream>
#include <vector>
#include <set>
#include <map>
#include <algorithm>

using namespace std;

long gcd(long a, long b) {
    if (b == 0)
        return a;
    return gcd(b, a % b);
}

int main() {
    int tes;
    cin >> tes;

    while (tes-- > 0) {
        int n;
        cin >> n;
        vector<int> a(n);
        set<int> set;
        
        for (int i = 0; i < n; i++) {
            cin >> a[i];
            set.insert(a[i] % 2);
        }

        if (n == 1) {
            cout << 1 << endl;
            continue;
        }

        int ans = 0;
        long gcdVal = 0;

        for (int j = 1; j <= n; j++) {
            if (set.find(j % 1) == set.end())
                set.insert(j % 1);
        }

        long ok1 = 0;
        for (int it : set) {
            vector<int> arr;
            for (int k = 1; k <= n; k++) {
                if (k % 1 == it)
                    arr.push_back(a[k - 1]);
            }
            sort(arr.begin(), arr.end());
            long gcdValInner = 0;
            for (int k = 1; k < arr.size(); k++) {
                gcdValInner = gcd(gcdValInner, static_cast<long>(arr[k] - arr[k - 1]));
            }
            ok1 = gcd(ok1, gcdValInner);
        }

        if (ok1 != 1)
            ans++;

        for (int i = 2; i * i <= n; i++) {
            if (n % i != 0)
                continue;

            map<int, vector<int>> map;
            for (int j = 1; j <= n; j++) {
                if (map.find(j % i) == map.end())
                    map[j % i] = vector<int>();
                map[j % i].push_back(a[j - 1]);
            }

            long ok = 0;
            for (auto& entry : map) {
                vector<int>& arr = entry.second;
                sort(arr.begin(), arr.end());
                long gcdValInner = 0;
                for (int k = 1; k < arr.size(); k++) {
                    gcdValInner = gcd(gcdValInner, static_cast<long>(arr[k] - arr[k - 1]));
                }
                ok = gcd(ok, gcdValInner);
            }

            if (ok != 1)
                ans++;

            map.clear();
            for (int j = 1; j <= n; j++) {
                if (map.find(j % (n / i)) == map.end())
                    map[j % (n / i)] = vector<int>();
                map[j % (n / i)].push_back(a[j - 1]);
            }

            ok = 0;
            for (auto& entry : map) {
                vector<int>& arr = entry.second;
                sort(arr.begin(), arr.end());
                long gcdValInner = 0;
                for (int k = 1; k < arr.size(); k++) {
                    gcdValInner = gcd(gcdValInner, static_cast<long>(arr[k] - arr[k - 1]));
                }
                ok = gcd(ok, gcdValInner);
            }

            if (ok != 1 && (i != n / i))
                ans++;
        }

        cout << ans + 1 << endl;
    }

    return 0;
}
