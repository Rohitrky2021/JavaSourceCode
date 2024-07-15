/*
We are given an array Arr with N distinct coins and a target.
We have an infinite supply of each coin denomination. We need to find the number of ways
we sum up the coin values to give us the target.

Each coin can be used any number of times.
 */


public class _22coinChange2 {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int tar = 4;
        int n = arr.length;
        int[][] dp = new int[n][tar+1];
        System.out.println("Rec : "+ rec(arr, tar, n-1));
        System.out.println("Memo : " + memo(arr, tar, n-1, dp));
        System.out.println("Tabu : "+ tabu(arr,tar, n));
        System.out.println("space opti : "+ spaceOpti(arr,tar,n));
    }

    public static int rec(int[] arr, int tar, int i){
        if( i < 0){
            return tar == 0 ? 1 : 0;
        }

        int not = rec(arr, tar, i-1);
        int take = 0;
        if(arr[i] <= tar) take =  rec(arr, tar- arr[i], i);
        return take + not;
    }
// Same  as Count Subset with sum k 
    public static int memo(int[] arr, int tar, int i, int[][] dp){
        if( i < 0){
            return tar == 0 ? 1 : 0;
        }
        if(dp[i][tar] != 0) return dp[i][tar];
        int not = memo(arr, tar, i-1, dp);
        int take = 0;
        if(arr[i] <= tar) take =  memo(arr, tar- arr[i], i, dp);
        return dp[i][tar] =  take + not;
    }
 // Same Accepted on Leetcode but not on Cstudio
    public static int subsetCount(int[] arr, int sum, int n) {
        if (sum == 0)
           return 1;
       if (n == 0)
           return 0;
       if (tmp[n][sum] != -1)
           return tmp[n][sum];
       else {
           if (arr[n - 1] > sum)
               return tmp[n][sum] = subsetCount(arr, sum, n - 1);
           else {
               return tmp[n][sum] = subsetCount(arr, sum, n - 1) + subsetCount(arr, sum - arr[n - 1], n);
           }
    }
   }
    public static int tabu(int[] arr, int tar, int n){
        int[][] dp = new int[n][tar+1];
        for(int t = arr[0]; t <= tar; t++)
            if( t % arr[0] == 0) dp[0][t] = 1;
        dp[0][0] = 1;

        for(int i = 1; i<n; i++){
            for(int t = 0; t<= tar; t++){
                int not = dp[i-1][t];
                int take = 0;
                if(arr[i] <= t) take = dp[i][t- arr[i]];
                dp[i][t] = take + not;
            }
        }
        return dp[n-1][tar];
    }

    public static int spaceOpti(int[] arr, int tar, int n){
        int prev[] = new int[tar+1];
        int curr[] = new int[tar+1];
        for(int t = arr[0]; t <= tar; t++)
            if( t % arr[0] == 0) prev[t] = 1;
        prev[0] = 1;

        for(int i = 1; i<n; i++){
            for(int t = 0; t<= tar; t++){
                int not = prev[t];
                int take = 0;
                if(arr[i] <= t) take = curr[t- arr[i]];
                curr[t] = take + not;
            }
            prev = curr;
        }
        return curr[tar];
    }
}
/*
1 2 3
target = 4

            0  1  2  3  4
0 val = 1 | 1  1  1  1  1
1 val = 2 | 1  1  2  2  3
2 val = 3 | 1  1  2  3  4
 */