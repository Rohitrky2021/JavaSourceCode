package DP_Stocks;

import java.util.Arrays;

public class Buy_sell_Fees {

    // Same problem as Buy_sell_stock-2
     public static int recur(int i, int buy ,int price [],int fee,int dp[][]){
       

        if(i>=price.length){
            return 0;
        }

        if(dp[i][buy]!=-1){
            return dp[i][buy];
        }

        int profit =0;
        if(buy==1){
            int take = recur(i+1,0,price,fee,dp)-price[i];
            int non = recur(i+1,1,price,fee,dp)+0;
            profit = Math.max(take, non);
        }
        else {
            int take = recur(i+1,1,price,fee,dp)+price[i]-fee; //here add extra work -fee for every sell
            int non = recur(i+1,0,price,fee,dp)+0;
            profit = Math.max(take, non);
        }
        dp[i][buy] = profit;
        return profit;
    }
    public static  int maxProfit(int[] prices, int fee) {
        int dp[][] = new int [prices.length][2];
        for(int i=0;i<prices.length;i++){
            Arrays.fill(dp[i],-1);
        }

        return recur(0,1,prices,fee,dp);
    }
    public static void main(String[] args) {
        
    }
}
