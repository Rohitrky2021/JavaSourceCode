import java.util.*;

public class J {
    static int[][] dp;
    static int[][] G;
    static int[] bit = new int[300];
    static int A;
    static int B;

    static int dfs(int v, int p, int mask) {
        if (dp[v][mask] != -1) return dp[v][mask];
        int ret = 0;
        for (int d = 1; d <= B; ++d) {
            long prod = 1;
            int leaf = 1;
            for (int child : G[v]) {
                if (child == p) continue;
                prod = prod * dfs(child, v, mask & bit[d]) % MOD;
                leaf = 0;
            }
            if (leaf == 1) {
                if ((mask & (bit[d])) == 0) ret += 1;
            } else {
                ret = (ret + (int) prod) % MOD;
            }
        }
        return dp[v][mask] = ret;
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
        A = scanner.nextInt();
        B = scanner.nextInt();
        dp = new int[A + 1][1 << B];
        for (int i = 0; i <= A; i++) {
            Arrays.fill(dp[i], -1);
        }
        G = new int[A + 1][];
        for (int i = 1; i <= A; i++) {
            G[i] = new int[0];
        }
        for (int i = 2; i <= A; i++) {
            int parent = scanner.nextInt();
            int[] temp = Arrays.copyOf(G[parent], G[parent].length + 1);
            temp[temp.length - 1] = i;
            G[parent] = temp;
        }

        int[] arr = {2, 3, 5, 7, 11, 13, 17, 19};
        for (int i = 1; i <= B; i++) {
            for (int j = 0; j < 8; j++) {
                if (i % arr[j] == 0) {
                    bit[i] |= (1 << j);
                }
            }
        }

        System.out.println(dfs(1, -1, (1 << B) - 1));
    }

    static final int MOD = 1000000007;
}
