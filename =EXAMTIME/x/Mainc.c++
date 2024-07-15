#include <bits/stdc++.h>
using namespace std;

#define ll long long
#define pb push_back
#define loop(n) for (long long i = 0; i < n; i++)
#define rloop(n) for (long long i = n - 1; i >= 0; i--)

////////////////////////////////////////////

ll m = 1e9 + 7;

long long binpow(long long a, long long b) {
      if (b == 0)
        return 1;
      long long res = binpow(a, b / 2);
      if (b % 2)
        return (res % m * res % m * a) % m;
      else         return res % m * res % m;
}

//////////////////////////////////////////////////

//////////////////////////////////////////////

signed main() {

        ios::sync_with_stdio(false);
        cin.tie(nullptr);

        #ifndef ONLINE_JUDGE
        freopen("input.txt", "r", stdin);
          freopen("output.txt", "w", stdout);
         #endif

      int test_cases;
  cin >> test_cases;
  while (test_cases--) {

    ll n;
    cin >> n;

    ll m = (n * (n - 1)) / 2;
    map<ll, ll> mp;
    ll a[m];
    loop(m) {
        cin >> a[i];
        mp[a[i]]++;
    }

    ll r = n - 1;
    vector<ll> v;
    for (auto it : mp) {
         if (r == it.second) {
             v.pb(it.first);
             r--;
          
      }
      else {
               ll x = r, p = 0;
               while (x > 0 &&  it.second != p) {
                    p += (x);
                    v.pb(it.first);
                    x--;
                
        }
               r = x;
          
      }
    }

    for (auto it : v)
      cout << it << " ";
      int x = v.size();
    while (x != n) {
         cout << 1000000000 << " ";
         x++;
    }

      cout << "\n";
  }
      return 0;
}