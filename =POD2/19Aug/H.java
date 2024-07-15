import java.util.*;

public class D {
    static int n, m;
    static int[][] dp;
    static boolean[][] fdp;
    static int[] bit = new int[300];
    static ArrayList<Integer>[] G;

    static int rec(int v, int p, int mask) {
        if (fdp[v][mask]) return dp[v][mask];
        fdp[v][mask] = true;
        int r = 0;
        for (int d = 1; d <= m; ++d) {
            long prod = 1;
            int leaf = 1;
            for (int child : G[v]) {
                if (child == p) continue;
                prod = prod * rec(child, v, mask & bit[d]) % MOD;
                leaf = 0;
            }
            if (leaf == 1) {
                if ((mask & (bit[d])) == 0) r += 1;
            } else {
                r = (r + (int) prod) % MOD;
            }
        }
        return dp[v][mask] = r;
    }

    static int getInd(int p) {
        switch (p) {
            case 2:
                return 0;
            case 3:
                return 1;
            case 5:
                return 2;
            case 7:
                return 3;
            case 11:
                return 4;
            case 13:
                return 5;
            case 17:
                return 6;
            case 19:
                return 7;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        dp = new int[300][100100];
        fdp = new boolean[300][100100];
        G = new ArrayList[n ];
        for (int i = 0; i <= n-1; i++) {
            G[i] = new ArrayList<>();
        }
        for (int i = 1; i < n-1; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            G[x].add(y);
            G[y].add(x);
        }

        int[] arr = {2, 3, 5, 7, 11, 13, 17, 19};
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < 8; j++) {
                if (i % arr[j] == 0) {
                    bit[i] |= (1 << j);
                }
            }
        }

        System.out.println(rec(1, -1, 255));
    }

    static final int MOD = 1000000007;
}
