package T19_Dynamic_Programming;

public class DP01_fibonacci {

    static int memoization(int n, int dp[]) { // top down
        if (n < 2) {
            dp[n] = n;
            return dp[n];
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = memoization(n - 1, dp) + memoization(n - 2, dp);
        return dp[n];
    }

    static int tabulation(int n) { // Bottom up
        int dp[] = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 10;
        int dp[] = new int[n+1];
        memoization(n, dp);
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
    }
}
