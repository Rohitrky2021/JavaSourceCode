package DP_Stocks;

public class Buy_Sell_Stock_3 {

    // Here extra variale is transaction
    // Recursiuon - Time -  O(N*2*3) . Space -  O(N)
    public static int rec(int i, int price[], int buy, int tran) {

        if (i == price.length || tran == 3) {
            return 0;
        }

        int profit = 0;
        if (buy == 1 && tran <= 2) {
            int take = rec(i + 1, price, 0, tran) - price[i];
            int not = rec(i + 1, price, 1, tran) - 0;
            profit = Math.max(take, not);
        } else if (buy == 0 && tran <= 2) {
            int take = rec(i + 1, price, 1, tran + 1) + price[i];
            int not = rec(i + 1, price, 0, tran) + 0;
            profit = Math.max(take, not);
        }

        return profit;
    }

    // Memorization - Time -  O(N*2*3) . Space -   O(N*2*3)+O(N)
    public static int DP(int i, int price[], int buy, int tran, int dp[][][]) {

        if (i == price.length || tran == 3) {
            return 0;
        }

        if (dp[i][buy][tran] != -1) {
            return dp[i][buy][tran];
        }

        int profit = 0;
        if (buy == 1 && tran <= 2) {
            int take = DP(i + 1, price, 0, tran, dp) - price[i];
            int not = DP(i + 1, price, 1, tran, dp) - 0;
            profit = Math.max(take, not);
        } else if (buy == 0 && tran <= 2) {
            int take = DP(i + 1, price, 1, tran + 1, dp) + price[i];
            int not = DP(i + 1, price, 0, tran, dp) + 0;
            profit = Math.max(take, not);
        }

        dp[i][buy][tran] = profit;
        return profit;
    }


    // Tabulation - Time -  O(N*2*3) . Space -  O(N*2*3)
    public static int Tabulation(int price[]) {
        int n = price.length;

        int dp[][][] = new int[price.length + 1][2][3];

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int tran = 0; tran <= 1; tran++) {
                    int profit = 0;
                    if (buy == 1 && tran <= 1) {
                        int take = dp[i+1][0][tran]-price[i];  // DP(i + 1, price, 0, tran, dp) - price[i];
                        int not = dp[i+1][1][tran]-0;          //DP(i + 1, price, 1, tran, dp) - 0;
                        profit = Math.max(take, not);
                    } else if (buy == 0 && tran <= 1) {
                        int take =  dp[i+1][1][tran+1]+ price[i];   //DP(i + 1, price, 1, tran + 1, dp) + price[i];
                        int not =    dp[i+1][0][tran];                               //DP(i + 1, price, 0, tran, dp) + 0;
                        profit = Math.max(take, not);
                    }

                    dp[i][buy][tran] = profit;

                }
            }
        }

        return dp[0][1][0];

    }


    // Space Optimization - Time -  O(N*2*3) . Space -  O(2*3)
    public  static int SpaceOptimization(int[] price) {
        int n = price.length;

        int dp[][] = new int[2][3];

        for (int i = n - 1; i >= 0; i--) {
            int curr[][] = new int[2][3];

            for (int buy = 0; buy <= 1; buy++) {
                for (int tran = 0; tran <= 1; tran++) {

                    int profit = 0;
                    if (buy == 1 && tran <= 1) {
                        int take = dp[0][tran] - price[i]; // DP(i + 1, price, 0, tran, dp) - price[i];
                        int not = dp[1][tran] - 0; // DP(i + 1, price, 1, tran, dp) - 0;
                        profit = Math.max(take, not);
                    } else if (buy == 0 && tran <= 1) {
                        int take = dp[1][tran + 1] + price[i]; // DP(i + 1, price, 1, tran + 1, dp) + price[i];
                        int not = dp[0][tran]; // DP(i + 1, price, 0, tran, dp) + 0;
                        profit = Math.max(take, not);
                    }

                    curr[buy][tran] = profit;

                }
            }

            dp = curr;
        }

        return dp[1][0];

    }

    public static void main(String[] args) {

    }
}
