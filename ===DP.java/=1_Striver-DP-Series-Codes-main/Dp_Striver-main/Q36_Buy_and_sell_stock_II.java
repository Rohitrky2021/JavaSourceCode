// In this question we can buy multiple stock and sell the mutiple stocks
// if we buy one stock then we cannot buy second until first stock sell out
// so we use a variable b if 1 that means no buy stock so we can buy the stock
// if 0 that means we cannot buy we can only sell or leave it
// leave option is their bcoz may be the price for the i index is not good so we don't want to
// buy and sell the stock
public class Q36_Buy_and_sell_stock_II {

    public static int f(int idx, int b, int[] arr, int n){

        // base case when out side from array that means no buy and stock now so return 0
        if(idx == n) return 0;

        // if b is 1 then we can buy the stock so add -(arr[idx]) we add negetive bcoz we are buying
        // so we are paying some amount from our side and pass idx-1 and in b pass 0 so in next
        // call we don't buy
        // we have one more option that we don't buy now so pass idx-1 and pass 1 bcoz we havn't 
        // buy stock yet
        // return max of both
        if(b == 1) {

            return Math.max(-arr[idx] + f(idx+1, 0, arr, n), f(idx+1, 1, arr, n));

        }

        // if b is not 1 that means one stock is already purchases so it's time to sell
        // so sell and pass idx-1 and 1 which indicate now we can buy the stock
        // another case is we don't want to sell today bcoz of profit so we don't sell
        // so pass idx-1 and 0 that means we cannot buy now
        else {

            return Math.max(arr[idx] + f(idx+1, 1, arr, n), f(idx+1, 0, arr, n));

        }

    }
    
    public static void main(String[] args) {
        
        int[] arr = {7, 1, 5, 3, 6, 4};

        int n = arr.length;

        // we started from 0th index for first time we don't purchase any stock so pass 1 
        // recursion 
        // System.out.println(f(0, 1, arr, n));

        // memoization
        // Integer[][] dp = new Integer[n+1][2];
        // System.out.println(f2(0, 1, arr, n, dp));

        // tabulation
        int[][] dp = new int[n+1][2];   

        dp[n][0] = dp[n][1] = 0; // base case 

        for(int i = n-1; i >= 0; i--){

            for(int j = 0; j < 2; j++){

                int profit = 0;

                if(j == 1){
                    profit = Math.max(-arr[i] + dp[i+1][0], dp[i+1][1]);
                }
                else{
                    profit = Math.max(arr[i] + dp[i+1][1], dp[i+1][0]);
                }

                dp[i][j] = profit;

            }

        }

        System.out.println(dp[0][1]);

    }

    public static int f2(int idx, int b, int[] arr, int n, Integer[][] dp){

        if(idx == n) return 0;

        if(dp[idx][b] != null) return dp[idx][b];

        int profit = 0;
        if(b == 1){
            profit = Math.max(-arr[idx] + f2(idx+1, 0, arr, n, dp), f2(idx+1, 1, arr, n, dp));
        }

        else{
            profit = Math.max(arr[idx] + f2(idx+1, 1, arr, n, dp), f2(idx+1, 0, arr, n, dp));
        }

        return dp[idx][b] = profit;

    }

}
