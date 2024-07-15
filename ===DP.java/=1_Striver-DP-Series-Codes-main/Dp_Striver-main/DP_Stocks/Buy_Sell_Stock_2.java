package DP_Stocks;

import java.util.Arrays;

public class Buy_Sell_Stock_2 {

    // Recursion time - o(N^2) , space - 0(N)
    // if buy ==1 then buy , else not buy
    public static int recur(int i, int buy, int price[]) {
        if (i == price.length) {
            return 0;
        }

        int profit = 0;
        if (buy == 1) {
            int take = recur(i + 1, 0, price) - price[i];
            int non = recur(i + 1, 1, price) + 0;
            profit = Math.max(take, non);
        } else {
            int take = recur(i + 1, 1, price) + price[i];
            int non = recur(i + 1, 0, price) + 0;
            profit = Math.max(take, non);
        }

        return profit;
    }



    // Memorization -- time space - 0(N*2) , space - 0(N*2)
    public static int DP(int i, int buy, int price[], int dp[][]) {
        if (i == price.length) {
            return 0;
        }

        if (dp[i][buy] != -1) {
            return dp[i][buy];
        }

        int profit = 0;
        if (buy == 1) {
            int take = DP(i + 1, 0, price, dp) - price[i];
            int non = DP(i + 1, 1, price, dp) + 0;
            profit = Math.max(take, non);
        } else {
            int take = DP(i + 1, 1, price, dp) + price[i];
            int non = DP(i + 1, 0, price, dp) + 0;
            profit = Math.max(take, non);
        }
        dp[i][buy] = profit;
        return profit;
    }


    //Tabulation time space - 0(N*2) , space - 0(N*2)
    public static int tabu(int price[],int n ){
        int dp[][] = new int [n+1][2];
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                int profit =0;
                if (buy == 1) {
                    int take =  dp[i+1][0]-price[i];     //recur(i + 1, 0, price) - price[i];
                    int non =   dp[i+1][1]-0;                            //recur(i + 1, 1, price) + 0;
                    profit = Math.max(take, non);

                } else {
                   int take =  dp[i+1][1]+price[i];     //recur(i + 1, 1, price) + price[i];
                    int non =   dp[i+1][0]+0;                            //recur(i + 1, 0, price) + 0;
                    profit = Math.max(take, non);
                }

                dp[i][buy] = profit;
        
            }
        }

        return dp[0][1];
    }


    //1D space Optimization -time space - 0(N*2) , space - 0(2)
    public static int space(int price[],int n ){
        int dp[]= new int [2];
        for(int i=n-1;i>=0;i--){
            int curr[] = new int [2];
            for(int buy=0;buy<=1;buy++){
                int profit =0;
                if (buy == 1) {
                    int take =  dp[0]-price[i];     //recur(i + 1, 0, price) - price[i];
                    int non =   dp[1]-0;                            //recur(i + 1, 1, price) + 0;
                    profit = Math.max(take, non);

                } else {
                   int take =  dp[1]+price[i];     //recur(i + 1, 1, price) + price[i];
                    int non =   dp[0]+0;                            //recur(i + 1, 0, price) + 0;
                    profit = Math.max(take, non);
                }

                curr[buy] = profit;
        
            }

            dp  = curr;
        }

        return dp[1];
    }


    // Two Variable - time space - 0(N*2) , space - 0(1)
    public static int Variable(int price[],int n ){
        int prevBuy =0;
        int prevNotBuy =0;

        for(int i=n-1;i>=0;i--){
            int currBuy =0;
            int currNotBuy =0;
            for(int buy=0;buy<=1;buy++){
                int profit =0;
                if (buy == 1) {
                    int take =  prevNotBuy-price[i];     //recur(i + 1, 0, price) - price[i];
                    int non =   prevBuy-0;                            //recur(i + 1, 1, price) + 0;
                    profit = Math.max(take, non);

                } else {
                   int take =  prevBuy+price[i];     //recur(i + 1, 1, price) + price[i];
                    int non =   prevNotBuy+0;                            //recur(i + 1, 0, price) + 0;
                    profit = Math.max(take, non);
                }

              
                if(buy==0){
                    currNotBuy = profit;
                }
                else{
                    currBuy = profit;
                }
        
            }

            prevBuy = currBuy;
            prevNotBuy = currNotBuy;
        }

        return prevBuy;
    }


    public static void main(String[] args) {
        int prices[] = new int[6];
        prices[0] = 7;
        prices[1] = 1;
        prices[2] = 5;
        prices[3] = 3;
        prices[4] = 6;
        prices[5] = 4;
        int dp[][] = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println("Maximum profit " + DP(0, 1, prices, dp));
    }
}
