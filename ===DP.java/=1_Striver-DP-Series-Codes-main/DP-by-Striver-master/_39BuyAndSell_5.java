import java.util.Arrays;

// unlimited transaction but with 1 day cool down period after selling stock.
public class _39BuyAndSell_5 {

    public static void main(String[] args) {
        int[] arr = { 7, 1, 5, 3, 6, 4 };
        int n = arr.length;
        System.out.println("rec = " + rec(arr, 0, 0));
        int[][] dp = new int[n][2];
        for (int[] ar : dp) {
            Arrays.fill(ar, -1);
        }
        System.out.println("memo : " + memo(arr, 0, 0, dp));
        System.out.println("tabu : " + tabu(arr, n, 0));
        System.out.println("space : " + space(arr, n, 0));
    }

    public static int space(int[] arr, int n, int stock) {
        int aheadBuy = 0, aheadSell = 0;
        int currBuy = 0, currSell = 0;
        int aa_buy = 0;

        for (int i = n - 1; i >= 0; i--) {
            currBuy = Math.max(aheadBuy, -arr[i] + aheadSell);
            currSell = Math.max(aheadSell, arr[i] + aa_buy);
            aa_buy = aheadBuy;
            aheadBuy = currBuy;
            aheadSell = currSell;
        }

        return aheadBuy;
    }

    public static int tabu(int[] arr, int n, int stock) {
        int[][] dp = new int[n + 2][2];
        dp[n][0] = dp[n][1] = dp[n + 1][0] = dp[n + 1][1] = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                if (j == 0) {
                    dp[i][j] = Math.max(dp[i + 1][j], -arr[i] + dp[i + 1][j + 1]);
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], arr[i] + dp[i + 2][j - 1]);
                }

            }
        }
        return dp[0][0];

    }

    public static int memo(int[] arr, int i, int stock, int[][] dp) {
        if (i >= arr.length)
            return 0;

        if (dp[i][stock] != -1)
            return dp[i][stock];
        if (stock == 0) {
            return dp[i][stock] = Math.max(memo(arr, i + 1, 0, dp),
                    -arr[i] + memo(arr, i + 1, 1, dp));
        } else {
            return dp[i][stock] = Math.max(memo(arr, i + 1, 1, dp),
                    arr[i] + memo(arr, i + 2, 0, dp));
        }
    }

    public static int rec(int[] arr, int i, int stock) {
        if (i >= arr.length)
            return 0;

        if (stock == 0) {
            return Math.max(rec(arr, i + 1, 0), -arr[i] + rec(arr, i + 1, 1));
        } else {
            return Math.max(rec(arr, i + 1, 1), arr[i] + rec(arr, i + 2, 0));
        }

    }

    // Better Memo version easy to use Not have to take max again and again
    public static int dfs(int currIdx, int canBuy, int[] prices, int[][] dp) {
        if (currIdx >= prices.length) {
            return 0;
        }
        if (dp[currIdx][canBuy] != -1) {
            return dp[currIdx][canBuy];
        }
        // do nothing
        int nothing = dfs(currIdx + 1, canBuy, prices, dp);
        // buy
        int action;
        if (canBuy == 1) {
            action = dfs(currIdx + 1, 0, prices, dp) - prices[currIdx];
        }
        // sell
        else {
            action = dfs(currIdx + 2, 1, prices, dp) + prices[currIdx];
        }
        int best = Math.max(nothing, action);
        dp[currIdx][canBuy] = best;
        return best;
    }
    // int[][] dp = new int[n + 1][2]; used things in above while Calling 
    // for (int i = 0; i <= n; i++) {
    //     dp[i][0] = -1;
    //     dp[i][1] = -1;
    // }
    // return dfs(0, 1, prices, dp);
}
