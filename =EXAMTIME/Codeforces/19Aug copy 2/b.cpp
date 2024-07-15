#include <iostream>
#include<bits/stdc++.h> // This includes all standard C++ libraries
#define int long long
using namespace std;
#define pb push_back

void sol() {
    int n, a, b;
    cin >> n >> a >> b;
    if (b < a) {
        cout << n * a << endl;
    } else {
        int x = min(n, b - a);
        int y = n - x;
        int c = b - x;

        int ans = y * a + (b * (b + 1) / 2) - (c * (c + 1) / 2);
        cout << ans << endl;
    }
    return;
}

signed main() {
    int test;
    cin >> test;
    while (test--) {
        sol();
    }
    return 0;
}
