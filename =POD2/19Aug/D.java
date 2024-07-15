import java.util.*;

public class D {
    static int n, m;
    static long[][] dp;
    static int[] bit = new int[300];
    static ArrayList<Integer>[] v;

    static long dfs(int x, int par, int mask) {
        if (dp[mask][x] != -1) return dp[mask][x];
        long ret = 0;
        for (int i = 1; i <= m; i++) {
            int flag = 1;

            
            long p = 1;
            for (int j = 0; j < v[x].size(); j++) {
                if (v[x].get(j) == par) continue;
                p = (p * dfs(v[x].get(j), x, mask & bit[i])) % MOD;
                flag = 0;
            }
            if (flag == 1) {
                if ((mask & bit[i]) == 0) ret++;
            } else {
                ret = (ret + p) % MOD;
            }
        }
        return dp[mask][x] = ret;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        dp = new long[300][100100];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        v = new ArrayList[100100];
        for (int i = 0; i < v.length; i++) {
            v[i] = new ArrayList<>();
        }
        for (int i = 1; i < n-1; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            v[x].add(y);
            v[y].add(x);
        }

        int[] arr = {2, 3, 5, 7, 11, 13, 17, 19, 23};
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < 8; j++) {
                if (i % arr[j] == 0) {
                    bit[i] |= (1 << j);
                }
            }
        }

        System.out.println(dfs(1, -1, 255));
    }

    static final int MOD = 1000000007;
}
