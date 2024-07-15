#include <bits/stdc++.h>
using namespace std;

#define ll long long

void solve() {
    ll n;
    cin >> n;
    vector<ll> a(n), b(n);
    for(auto& it : a) cin >> it;
    for(auto& it : b) cin >> it;

    ll P = 0, N = 0;
    ll A = 0, B = 0;

    // Count positive, negative and balance initial ratings
    for (int i = 0; i < n; i++) {
        if (a[i] == b[i]) {
            if (a[i] == -1) {
                N--;
            } else if (a[i] == 1) {
                P++;
            }
        } else {
            if (a[i] > b[i]) {
                A += a[i];
            } else {
                B += b[i];
            }
        }
    }

    // Adjust ratings to maximize the minimum
    if (A > B) swap(A, B);

    ll count = P;
    ll x = min(B - A, count);
    A += x;
    count -= x;
    x = count / 2;
    count -= x;
    A += max(x, count);
    B += min(x, count);

    if (A > B) swap(A, B);

    count = N;
    x = max(A - B, count);
    B += x;
    count -= x;
    x = count / 2;
    count -= x;
    A += max(x, count);
    B += min(x, count);

    cout << min(A, B) << endl;
}

int main() {
    ll t;
    cin >> t;
    while (t--) {
        solve();
    }
    return 0;
}
