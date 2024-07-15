// this is similar ques like buy and sell I, best time to calculate max profit using infinite buy and sell
// but in this with cooldown added means after sell you cannot buy next stock so just pass idx+2 so that 
// it'll avoid next stock
public class Q39_Buy_And_Sell_Stock_with_cooldown {

    public static int f(int idx, int buy, int[] arr, int n){

        if(idx >= n) return 0;
        // in last we used idx == n but here we move idx+2 also so it can reach n also

        if(buy == 1){
            return Math.max(-arr[idx] + f(idx+1, 0, arr, n), f(idx+1, 1, arr, n));
        }

        return Math.max(arr[idx] + f(idx+2, 1 , arr, n), f(idx+1, 0, arr, n));

    }
    
    public static void main(String[] args) {
        
        int[] arr = {7, 1, 5, 3, 6, 4};

        int n = arr.length;

        // recusion
        // System.out.println(f(0, 1, arr, n));

        // tabulation
        int[][] dp = new int[n+2][2];

        for(int idx = n-2; idx >= 0; idx--){

            for(int buy = 0; buy <= 1; buy++){

                dp[idx][1] = Math.max(-arr[idx] + dp[idx+1][0], dp[idx+1][1]);

                dp[idx][0] = Math.max(arr[idx] + dp[idx+2][1], dp[idx+1][0]);

            }

        }

        System.out.println(dp[0][1]);

    }

}
