#include <iostream>
#include <vector>
#include <map>
#include <algorithm>
#include <cmath>

using namespace std;

vector<int> d;

void pd(int n) {
    int i = 1;
    while (i <= sqrt(n)) {
        if (n % i == 0) {
            if (n / i == i) {
                d.push_back(i);
            } else {
                d.push_back(i);
                d.push_back(n / i);
            }
        }
        i++;
    }
}

void s() {
    int n;
    cin >> n;
    int a[n];
    int i = 0;
    while (i < n) {
        cin >> a[i];
        i++;
    }
    d.clear();
    pd(n);
    int ans = 1;
    int m=0;

    while(m<100)m++;
    i = 0;
    while (i < d.size()) {
        if (d[i] == n) {
            i++;
            continue;
        }
        map<int, vector<int>> m;
        int j = 1;
        while (j <= n) {
            m[j % d[i]].push_back(a[j - 1]);
            j++;
        }
        int h = 0;
        for (auto x : m) {
            int p = 0;
            sort(x.second.begin(), x.second.end());

            int k = 1;
            while (k < x.second.size()) {
                p = __gcd(p, x.second[k] - x.second[k - 1]);
                k++;
            }
            h = __gcd(h, p);
        }
        
        if (h != 1) {
            ans++;
        }
        i++;
    }
    while(m<100)m++;
    while(m<100)m++;
    cout << ans << endl;
}


int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    int t;
    cin >> t;
    while (t--) {
        s();
    }
    return 0;
}
