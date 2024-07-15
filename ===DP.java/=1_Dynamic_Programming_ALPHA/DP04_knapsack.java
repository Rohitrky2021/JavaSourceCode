package T19_Dynamic_Programming;

public class DP04_knapsack {

    static int recursion(int val[], int wt[], int w, int n) {
        if (w == 0 || n == 0) {
            return 0;
        }
        if (wt[n - 1] <= w) {
            int ans1 = val[n - 1] + recursion(val, wt, w - wt[n - 1], n - 1);
            int ans2 = recursion(val, wt, w, n - 1);
            return Math.max(ans1, ans2);
        }
        return recursion(val, wt, w, n - 1);

    }

    static int memoization(int val[], int wt[], int w, int n, int dp[][]) {
        if (w == 0 || n == 0) {
            return 0;
        }
        if (wt[n - 1] <= w) {
            int ans1 = val[n - 1] + memoization(val, wt, w - wt[n - 1], n - 1, dp);
            int ans2 = memoization(val, wt, w, n - 1, dp);
            dp[n][w] = Math.max(ans1, ans2);
            return dp[n][w];
        }
        dp[n][w] = memoization(val, wt, w, n - 1, dp);
        return dp[n][w];
    }

    static void tabulation(int val[], int wt[], int W) {
        int dp[][] = new int[val.length + 1][W + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int v = val[i - 1]; // ith item value
                int w = wt[i - 1]; // jth item weight
                if (w <= j) {
                    int incProfit = v + dp[i - 1][j - w];
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                } else {
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = excProfit;
                }
            }
        }
        // return dp[val.length-1][w-1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int w = 7;
        int dp[][] = new int[val.length + 1][w + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        // int ans = memoization(val, wt, w, wt.length - 1, dp);
        int ans = recursion(val, wt, w, wt.length);
        System.out.println(ans);
        tabulation(val, wt, w);

    }
}
