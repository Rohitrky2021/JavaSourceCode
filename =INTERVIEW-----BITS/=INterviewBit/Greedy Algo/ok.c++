#include <bits/stdc++.h>
#include <vector>
using namespace std;

typedef long long ll;

ll solve(vector<int> &arr) {
    int n = arr.size();
    vector<ll> pf(n), sf(n);
    pf[0] = arr[0];
    sf[n - 1] = arr[n - 1];
    for (int i = 1; i < n; i++) pf[i] = arr[i] + pf[i - 1];
    for (int i = n - 2; i >= 0; i--) sf[i] = arr[i] + sf[i + 1];
    ll sm = 0, mn = 0;
    ll mx = -1e18;
    for (int i = 0; i < n; i++) {
        sm += arr[i];
        if (sm > 0) sm = 0;
        mn = min(mn, sm);
        mx = max(mx, pf[i] - 2 * mn - (i < n - 1 ? sf[i + 1] : 0));
    }
    return mx;
}


int main() {
    int n;
    cin >> n;
    vector<int> arr(n);

    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    ll result = solve(arr);
    cout << result << endl;

    return 0;
}
