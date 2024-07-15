public class Q2_Climbing_stairs {
    // we have given n stairs we are at 0th stair we have to reach nth stairs
    // we can climb either 1 step or 2 steps
    public static void main(String[] args) {
        int n = 6;
        // similar like fibonacci just we have given long statement and fibonacci start from 1 
        // tabulation
        // int[] dp = new int[n+1];
        // dp[0] = 1;
        // dp[1] = 1;
        // for(int i = 2; i <= n; i++){
        //     dp[i] = dp[i-1] + dp[i-2];
        // }
        // System.out.println(dp[n]);

        // optimize step
        int step0 = 1;
        int step1 = 1;
        for(int i = 2; i <= n; i++){
            int curr = step1 + step0;
            step0 = step1;
            step1 = curr;
        }
        System.out.println(step1);
    }
}
