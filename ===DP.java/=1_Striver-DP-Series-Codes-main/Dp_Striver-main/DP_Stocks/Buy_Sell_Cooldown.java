 package DP_Stocks;

public class Buy_Sell_Cooldown {
    //This is problem same as Buy_sell_Stock_2
    public static int recur(int i, int buy ,int price [],int dp[][]){
        if(i>=price.length){
            return 0;
        }

        if(dp[i][buy]!=-1){
            return dp[i][buy];
        }

        int profit =0;
        if(buy==1){
            int take = recur(i+1,0,price,dp)-price[i];
            int non = recur(i+1,1,price,dp)+0;
            profit = Math.max(take, non);
        }
        else {
            int take = recur(i+2,1,price,dp)+price[i];  //here small change (i+2) , if this day sell can not buy next day so (i+2)
            int non = recur(i+1,0,price,dp)+0;
            profit = Math.max(take, non);
        }
        dp[i][buy] = profit;
        return profit;
    }
    public static void main(String[] args) {
        int prices[] = new int [6];
        prices[0] = 7;
        prices[1] = 1;
        prices[2] = 5;
        prices[3] = 3;
        prices[4] = 6;
        prices[5] = 4;

        int n = prices.length;
        int dp[][] = new int [n][2];
        System.out.println("Max "+recur(0, 1, prices, dp));
    }
    
}