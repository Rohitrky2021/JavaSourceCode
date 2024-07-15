package T19_Dynamic_Programming;

public class DP03_climbingStairs3jump {
    static int memoization(int n, int dp[]) { // top down
        if (n == 0) {
            dp[n] = 1;
            return dp[n];
        }
        if (n < 0) {
            return 0;
        }

        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = memoization(n - 1, dp) + memoization(n - 2, dp) + memoization(n - 3, dp);
        return dp[n];
    }

    static int tabulation(int n) { // Bottom up
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
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
