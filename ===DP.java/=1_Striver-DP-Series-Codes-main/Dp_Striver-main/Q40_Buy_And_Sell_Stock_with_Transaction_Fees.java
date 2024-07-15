// in this ques we can buy and sell infinite stocks but their is a transaction fee which we have to pay
// either at buy time or selling time
public class Q40_Buy_And_Sell_Stock_with_Transaction_Fees {

    public static int f(int idx, int buy, int prices[], int n, int fee){

        if(idx == n) return 0;

        if(buy == 1){

            return Math.max(-prices[idx] + f(idx+1, 0, prices, n, fee), f(idx+1, 1, prices, n, fee));

        }

        return Math.max(prices[idx] + f(idx+1, 1, prices, n, fee) - fee, f(idx+1, 0, prices, n, fee));

    }
    
    public static void main(String[] args) {
        
        int prices[] = {1,3,2,8,4,9};
        int fee = 2;
        int n = prices.length;

        // recursion
        // System.out.println(f(0, 1, prices, n, fee));

        // tabulation
        int[][] dp = new int[n+1][2];

        for(int idx = n-1; idx >= 0; idx--){

            dp[idx][0] = Math.max(prices[idx] + dp[idx+1][1] - fee, dp[idx+1][0]);

            dp[idx][1] = Math.max(-prices[idx] + dp[idx+1][0], dp[idx+1][1]);

        }

        System.out.println(dp[0][1]);

    }

}
