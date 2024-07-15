#include <bits/stdc++.h>
using namespace std;

int Find(string &s1, string &s2) {

  if (s1.size() != s2.size())
    return -1;

  int n = s1.size();
  int cnt1R = 0, cnt1W = 0;
  int cnt2R = 0, cnt2W = 0;
  int count = 0;
  for (int i = 0; i < n; i++) {

    if (s1[i] == '?') {
      if (s2[i] == 'R') {
        count++;
        s1[i] = 'W';
      } else if (s2[i] == 'W') {
        count++;
        s1[i] = 'R';
      }
    }
    if (s2[i] == '?') {

      if (s1[i] == 'R') {
        count++;
        s2[i] = 'W';
      } else if (s1[i] == 'W') {
        count++;
        s2[i] = 'R';
      }
    }
    if (s1[i] == 'R') {
      cnt1R++;
    } else if (s1[i] == 'W') {
      cnt1W++;
    }

    if (s2[i] == 'R') {
      cnt2R++;
    } else if (s2[i] == 'W') {
      cnt2W++;
    }
  }

  if (cnt1W == cnt1R and cnt2W == cnt2R)
    return 0;

  int exceedR = cnt1R - cnt1W;
  int exceedW = cnt2W - cnt2R;

  for (int i = 0; i < n; i++) {

    if (s1[i] == '?') {
      count += 2;
      if (exceedR < 0) {
        exceedR++;
      } else {
        exceedR--;
      }

      if (exceedW < 0) {
        exceedW++;
      } else {
        exceedW--;
      }
    }

    if (exceedR == 0 and exceedW == 0)
      return count;
  }
  return -1;
}
void solve() {

  string s1, s2;
  cin >> s1 >> s2;
  cout << Find(s1, s2);
}

int main() {

  int t = 1;
  cin >> t;
  while (t--) {
    solve();
    cout << "\n";
  }
}