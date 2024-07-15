#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct P {
    int k;
    long long v;

    P(int k, long long v) : k(k), v(v) {}
};

vector<int> a;
vector<vector<int>> t;
long long ans;

vector<P> dfs(int i, int d) {
    if (t[i].empty()) {
        return {P(d, 1e16)};
    }

    vector<P> v;
    long long sm = 0;

    for (int j : t[i]) {
        vector<P> c = dfs(j, d + 1);
        v.insert(v.end(), c.begin(), c.end());
        sm += a[j];
    }

    if (a[i] <= sm) {
        v.push_back(P(d, sm - a[i]));
    } else {
        sort(v.begin(), v.end(), [](const P& p1, const P& p2) {
            return p1.k < p2.k;
        });

        long long diff = a[i] - sm;
        for (P& p : v) {
            long long z = min(diff, p.v);
            diff -= z;
            p.v -= z;
            ans += z * (p.k - d);
        }
    }

    return v;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int T;
    cin >> T;

    while (T-- > 0) {
        int n;
        cin >> n;

        a.assign(n + 1, 0);
        t.assign(n + 1, {});

        for (int i = 1; i <= n; ++i) cin >> a[i];
        for (int i = 2; i <= n; ++i) {
            int p;
            cin >> p;
            t[p].push_back(i);
        }

        ans = 0;
        dfs(1, 0);

        cout << ans << "\n";
    }

    return 0;
}