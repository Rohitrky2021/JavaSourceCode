// this is similar type of ques like unbounded knapsack 
// here we're having N as target we have given an array idx i represent the price of i+1 rod
// return the max value which we can make by partitioning rod into smaller rods
public class Q24_Rod_cutting_problem {

    public static int f(int idx, int N, int[] price) {

        if (idx == 0) {
            return N * price[0];
        }

        int nottake = 0 + f(idx - 1, N, price);
        int take = Integer.MIN_VALUE;
        int rodlength = idx + 1;
        if (rodlength <= N)
            take = price[idx] + f(idx, N - rodlength, price);

        return Math.max(take, nottake);

    }

    public static void main(String[] args) {

        int price[] = { 2, 5, 7, 8, 10 };

        int n = price.length;

        // recursion
        // System.out.println(f(n-1, n, price));

        // memoization
        // n is our target also
        // Integer[][] dp = new Integer[n][n+1];
        // System.out.println(f2(n-1, n, price, dp));

        // tabulation
        int[][] dp = new int[n][n + 1];
        for (int tar = 0; tar <= n; tar++)
            dp[0][tar] = tar * price[0];

        for (int idx = 1; idx < n; idx++) {

            for (int N = 0; N <= n; N++) {

                int nottake = 0 + dp[idx - 1][N];
                int take = Integer.MIN_VALUE;
                int rodlength = idx + 1;
                if (rodlength <= N)
                    take = price[idx] + dp[idx][N - rodlength];

                dp[idx][N] = Math.max(take, nottake);     
            }

        }

        System.out.println(dp[n - 1][n]);
    }

    public static int f2(int idx, int N, int[] price, Integer[][] dp) {

        if (idx == 0) {
            return N * price[0];
        }

        if (dp[idx][N] != null)
            return dp[idx][N];

        int nottake = 0 + f2(idx - 1, N, price, dp);
        int take = Integer.MIN_VALUE;
        int rodlength = idx + 1;
        if (rodlength <= N)
            take = price[idx] + f2(idx, N - rodlength, price, dp);

        return dp[idx][N] = Math.max(take, nottake);

    }
}
