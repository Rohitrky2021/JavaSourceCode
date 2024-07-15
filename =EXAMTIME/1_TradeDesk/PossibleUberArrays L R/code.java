import java.util.Scanner;

public class code {
    static long[][] dp;
    static int N, L, R;
    static final int MOD = 1000000007;

    static long solve(int pos, int sum) {
        if (pos == N) return (sum == 0) ? 1 : 0;
        if (dp[pos][sum] != -1) return dp[pos][sum];
        
        long ans = 0;
        for (int i = L; i <= R; i++) {
            ans = (ans + solve(pos + 1, (sum + i) % 3)) % MOD;
        }
        return dp[pos][sum] = ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        L = scanner.nextInt();
        R = scanner.nextInt();
        
        dp = new long[1005][3];
        for (int i = 0; i < 1005; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(solve(0, 0));
    }
}
