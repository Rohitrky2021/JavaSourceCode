//We are given an array Arr[] of length n. It represents the price of a stock on ‘n’ days.
// The following guidelines need to be followed:
//
//        We can buy and sell the stock any number of times.
//        In order to sell the stock, we need to first buy it on the same or any previous day.
//        We can’t buy a stock again after buying it once. In other words, we first buy a stock
//        and then sell it. After selling we can buy and sell again. But we can’t sell before buying
//        and can’t buy before selling any previously bought stock.
//        We can do at most 2 transactions.

public class _37BuyAndSell_3 {
    public static void main(String[] args) {
        int[] arr = { 7, 1, 5, 3, 6, 4 };
        int n = arr.length;
        System.out.println("rec = " + solve(arr, 0, 2, 0));
        int[][][] dp = new int[n][2][3];
        System.out.println("memo : " + memo(arr, 0, 2, 0, dp));
        System.out.println("tabu : " + tabu(arr, n, 2, 0));
        System.out.println("space : " + space(arr, n, 2, 0));
        System.out.println("leetcode : " + leetcodeSolution(arr, 4));
    }

    public static int solve(int[] arr, int i, int limit, int stock) {
        if (i == arr.length)
            return 0;
        if (limit == 0)
            return 0;
        if (stock == 0) {
            return Math.max(solve(arr, i + 1, limit, 0), -arr[i] + solve(arr, i + 1, limit, 1));
        } else {
            return Math.max(solve(arr, i + 1, limit, 1), arr[i] + solve(arr, i + 1, limit - 1, 0));
        }
    }

    // Dont know but In Ninja The Hashmap Memo Dont work Giving TLE
    public static int memo(int[] arr, int i, int limit, int stock, int[][][] dp) {
        if (i == arr.length)
            return 0;
        if (limit == 0)
            return 0; // This about line ones while comparing with rest Parts
        if (dp[i][stock][limit] != 0)
            return dp[i][stock][limit];
        if (stock == 0) {
            return dp[i][stock][limit] = Math.max(memo(arr, i + 1, limit, 0, dp),
                    -arr[i] + memo(arr, i + 1, limit, 1, dp));
        } else {
            return dp[i][stock][limit] = Math.max(memo(arr, i + 1, limit, 1, dp),
                    arr[i] + memo(arr, i + 1, limit - 1, 0, dp));
        }
    }

    public static int tabu(int[] arr, int n, int limit, int stock) {
        int[][][] dp = new int[n + 1][2][3];

        for (int i = 0; i < n; i++) {
            for (int st = 0; st <= 1; st++) {
                dp[i][st][0] = 0;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j >= 0; j--) {
                for (int k = 1; k <= 2; k++) {
                    if (j == 0) {
                        dp[i][j][k] = Math.max(dp[i + 1][0][k], -arr[i] + dp[i + 1][1][k]);
                    } else {
                        dp[i][j][k] = Math.max(dp[i + 1][1][k], arr[i] + dp[i + 1][0][k - 1]);
                    }
                }
            }
        }
        return dp[0][0][2];
    }

    public static int space(int[] arr, int n, int limit, int stock) {
        int[][] prev = new int[2][limit + 1];
        int[][] curr = new int[2][limit + 1];

        // prev[0][0] = prev[1][0] = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j >= 0; j--) {
                for (int k = 1; k <= 2; k++) {
                    if (j == 0) {
                        curr[j][k] = Math.max(prev[j][k], -arr[i] + prev[1][k]);
                    } else {
                        curr[j][k] = Math.max(prev[j][k], arr[i] + prev[0][k - 1]);
                    }
                }
            }
            prev = curr;
        }
        return prev[0][2];
    }

    // Tricky SOLUTION only ONes Who Notice will KNow
    // we are going to do transaction in the format of B S B S
    // here we are using a trick that if trans no. is even then we have to buy else
    // we can sell.
    public static int leetcodeSolution(int[] arr, int trans) {
        int n = arr.length;
        int[] prev = new int[5];
        int[] curr = new int[5];

        // int t = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int t = 1; t <= 4; t++) {
                if (t % 2 == 1) {
                    curr[t] = Math.max(prev[t], -arr[i] + prev[t]);
                } else {
                    curr[t] = Math.max(prev[t], arr[i] + prev[t - 1]);
                }
            }
            prev = curr;
        }
        return prev[4];
    }
}
