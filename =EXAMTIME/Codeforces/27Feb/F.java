import java.io.*;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.BiFunction;

public class F {
    static final int INF = (int) 1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int ans = solve(grid, n, m);
            out.println(ans);
        }

        out.close();

    }

    static int solve(int[][] grid, int n, int m) {
        BiPredicate<Integer, Integer> check = (i, j) -> i >= 0 && i < n && j >= 0 && j < m && grid[i][j] == 0;

        TriFunction<Integer, Integer, Integer, Boolean> checkMovable = (i, j, k) -> {
            if (!check.test(i, j))
                return false;

            int[][] checkX = { { 1, 1 }, { 1, 1 } };
            int[][] checkY = { { 0, 1 }, { -1, 0 } };

            for (int l = 0; l < checkX[k].length; l++) {
                int x = (i + checkX[k][l] + n) % n;
                int y = (j + checkY[k][l] + m) % m;

                if (!check.test(x, y))
                    return false;
            }

            return true;
        };

        BiFunction<Integer, Integer, int[][]> bfs = (rootI, rootJ) -> {
            int[][] dist = new int[n][m];
            for (int[] asd : dist)
                Arrays.fill(asd, INF);
            dist[rootI][rootJ] = 0;
            boolean[][] vis = new boolean[n][m];

            Queue<int[]> q = new ArrayDeque<>();
            q.add(new int[] { rootI, rootJ });
            while (!q.isEmpty()) {
                int[] temp = q.poll();
                int i = temp[0], j = temp[1];

                if (vis[i][j])
                    continue;
                vis[i][j] = true;

                for (int k = 0; k < 2; k++) {
                    if (!checkMovable.apply(i, j, k))
                        continue;

                    int[][] dx = { { -1, -1 }, { -1, -1 } };
                    int[][] dy = { { 0, 1 }, { -1, 0 } };

                    int x = (i + dx[k][0] + n) % n;
                    int y = (j + dy[k][0] + m) % m;

                    if (!vis[x][y]) {
                        dist[x][y] = Math.min(dist[x][y], dist[i][j] + 1);
                        q.add(new int[] { x, y });
                    }
                }
            }

            return dist;
        };

        var dist = bfs.apply(0, 0);

        int ans = INF;
        for (int i = 0; i < n; i++) {
            if (dist[i][m - 1] == INF)
                continue;

            int d = dist[i][m - 1] - (i + 1);
            d = (d + n - 1) / n * n;
            ans = Math.min(ans, d + i + 1);
        }

        if (ans == INF)
            ans = -1;
        return ans;
    }

    interface TriFunction<A, B, C, R> {
        R apply(A a, B b, C c);
    }
}
