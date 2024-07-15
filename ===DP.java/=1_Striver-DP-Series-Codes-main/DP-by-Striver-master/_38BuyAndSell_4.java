//We can buy and sell the stock any number of times.
//        In order to sell the stock, we need to first buy it on the same or any previous day.
//        We can’t buy a stock again after buying it once. In other words, we first buy a stock and then sell it. After selling, we can buy and sell again. But we can’t sell before buying and can’t buy before selling any previously bought stock.
//        We can do at-most K transactions.
public class _38BuyAndSell_4 {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int k = 2;
        int n = arr.length;
        System.out.println("rec : "+ rec(arr,0,n,0, k -1 ));

    }

    public static int rec(int[] arr, int i, int n, int stock, int limit){
        if(i == n) return 0;
        if(limit < 0) return 0;
        if(stock == 0) {
            return Math.max( rec(arr,i+1, n, 0, limit), -arr[i] + rec(arr,i+1, n, 1, limit));
        }
        else{
            return Math.max( rec(arr, i+1, n, 1, limit), arr[i] + rec(arr,i+1,n,0,limit-1));
        }
    }
// Similar last solution of Previous part 3 
    public static int tabu(int[] arr, int n, int limit){
        int[][] dp = new int[n+1][(limit*2)+1];

        for(int i = 0; i < n; i++){
            dp[i][0] = 0;
        }
        for(int i = n-1; i>=0; i--){
            for(int j = 1; j <= limit*2; j++){
                if(j % 2 == 0){
                    dp[i][j] = Math.max( dp[i+1][j], -arr[i] + dp[i+1][j-1]);
                }else{
                    dp[i][j] = Math.max(dp[i+1][j], arr[i] + dp[i+1][j-1]);
                }
            }
        }
        return dp[0][limit*2];
    }
    // Remember in this 4th Part 
    public static int memo(int[] arr, int i, int n, int stock, int limit, int[][][] dp){
        if(i == n) return 0;
        if(limit<0) return 0; // as we are passing K-1 so we will use 0 
        if(dp[i][stock][limit] != 0) return dp[i][stock][limit];
        if(stock == 0) {        //other whise in arr[]-> we have to use [ limit-1 ]
            return dp[i][stock][limit] = Math.max( memo(arr,i+1, n, 0, limit, dp), -arr[i] + memo(arr,i+1, n, 1, limit, dp));
        }
        else{
            return dp[i][stock][limit] = Math.max( memo(arr, i+1, n, 1, limit, dp), arr[i] + memo(arr,i+1,n,0,limit-1, dp));
        }
    }
}
