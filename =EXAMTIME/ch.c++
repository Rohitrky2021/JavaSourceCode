#include <bits/stdc++.h>
using namespace std;

const int NC = 1e6 + 5;
const int INF = 1e9 + 5;
vector<int> lpf(NC, 0), f(NC);

int solve(int N, vector<vector<int>> G)
{
    vector<vector<int>> sq(N, vector<int>(N));
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            sq[i][j] = sqrt(G[i][j]);

    vector<vector<int>> d(N, vector<int>(N, INF));
    d[0][0] = 0;

    set<pair<int, pair<int, int>>> s;
    s.insert({0, {0, 0}});
    while (!s.empty())
    {
        auto [dist, pos] = *s.begin();
        s.erase(s.begin());

        auto [x, y] = pos;
        if (dist > d[x][y])
            continue;

        if (x == N - 1 && y == N - 1)
            return d[x][y];

        for (int p = 1; p <= f[G[x][y]]; p++)
            for (int i = 0; i <= min(p, N - 1); i++)
            {
                int nx = x + i;
                if (nx >= N)
                    break;

                for (int j = 0; j <= min(p - i, N - 1); j++)
                {
                    int ny = y + j;
                    if (ny >= N)
                        break;

                    if (d[nx][ny] > d[x][y] + sq[x][y])
                    {
                        s.erase({d[nx][ny], {nx, ny}});
                        d[nx][ny] = d[x][y] + sq[x][y];
                        s.insert({d[nx][ny], {nx, ny}});
                    }
                }
            }
    }

    return -1;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    for (int i = 2; i < NC; i++)
        if (lpf[i] == 0)
            for (int j = i; j < NC; j += i)
                lpf[j] = i;

    for (int i = 2; i < NC; i++)
    {
        int X = i;
        unordered_map<int, int> mp;
        while (X > 1)
        {
            mp[lpf[X]]++;
            X /= lpf[X];
        }
        f[i] = mp.size();
    }

    int t;
    cin >> t;
    while (t--)
    {
        int N;
        cin >> N;
        vector<vector<int>> G(N, vector<int>(N));
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                cin >> G[i][j];
        cout << solve(N, G) << "\n";
    }
}