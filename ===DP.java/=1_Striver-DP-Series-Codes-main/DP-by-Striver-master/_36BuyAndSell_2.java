//You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
//
//        On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of
//        the stock at any time. However, you can buy it then immediately sell it on the same day.
//
//        Find and return the maximum profit you can achieve.

public class _36BuyAndSell_2 {
    public static void main(String[] args) {
        int[] price = {7,1,5,3,6,4};
        int[][] dp = new int[price.length][2];
        System.out.println("rec : "  + rec(price, 0, false));
        System.out.println("memo : "+ memo(price, 0, 0, dp));
        System.out.println("tabu : "+ tabu(price, price.length));
        System.out.println("space : " + space(price, price.length));
    }

    // here buy variable indicate that i have hold some stock or not
    // is stock = true then i only can sell not buy.
    // here if we buy a stock we add it as negative
    // if we sell a stock we add it as a positive value

       // Recursion time - o(N^2) , space - 0(N)
 public static int rec(int[] arr, int i, boolean buy){
        if(i == arr.length) return 0;

        if(buy == false){
            return Math.max(0+rec(arr,i+1, false), -arr[i] +rec(arr,i+1, true));
        }else{
            return Math.max(arr[i] + rec(arr,i+1, false), 0+rec(arr,i+1, true));
        }
    }
    
    public static long getMaximumProfit(int n, long[] values) {
        if (values.length == 0) return 0;
        
        long sum = 0, bp = values[0];
        for (int i = 1; i < values.length; i++) {
            if (bp < values[i]) sum += values[i] - bp;
            bp = values[i];
        }
        return sum;
    }
   
    

    // here buy var is not boolean. it is a 0 or 1 value based where 0 means we don't have any stock. so we can buy
    // using buy var as int will help us to store re-occurrence easily in dp
    public static int memo(int arr[], int i, int buy, int[][] dp){
        if(i == arr.length) return 0;
        if(dp[i][buy] != 0) return dp[i][buy];
        if(buy == 0){
            return dp[i][buy] = Math.max(memo(arr,i+1, 0, dp), -arr[i] +memo(arr,i+1, 1, dp));
        }else{
            return dp[i][buy] = Math.max(arr[i] + memo(arr,i+1, 0, dp), memo(arr,i+1, 1, dp));
        }
    }

    public static int tabu(int[] arr, int n){
        int[][] dp = new int[n+1][2];
        dp[n][0] = dp[n][1] = 0;

        for(int i = n-1; i>=0; i--){
            for(int j=0; j<=1; j++){
                if(j == 0){
                    dp[i][j] = Math.max(dp[i+1][0], -arr[i] +dp[i+1][1]);
                }else{
                    dp[i][j] = Math.max(arr[i] + dp[i+1][0], dp[i+1][1]);
                }
            }
        }
        return dp[0][0];
    }

    public static int space(int[]arr, int n){
        int[] ahead = new int[2];
        int[] curr = new int[2];

        for(int i = n-1; i>=0; i--){
            for (int j = 0; j<= 1; j++){
                if(j == 0){
                    curr[j] = Math.max(ahead[0], -arr[i] +ahead[1]);
                }else{
                    curr[j] = Math.max(arr[i] + ahead[0], ahead[1]);
                }
            }
            ahead = curr;
        }
        return ahead[0];
    }
// Optimised One
   public static int leetcodeSolution(int []prices){
        int i = 0, buy, sell, profit = 0, N = prices.length - 1;
        while (i < N) {
            while (i < N && prices[i + 1] <= prices[i]) i++;
            buy = prices[i];

            while (i < N && prices[i + 1] > prices[i]) i++;
            sell = prices[i];

            profit += sell - buy;
        }
        return profit;
    }
}
