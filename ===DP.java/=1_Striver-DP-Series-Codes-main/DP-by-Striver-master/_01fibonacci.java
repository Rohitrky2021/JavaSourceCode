import java.util.*;
class _01fibonacci{
    static int[] dp;
    public static void main(String[] args){
        int n = 10;
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        int ans = fibo(n);
        System.out.println(n + "th fibo number is " + ans);
    }

//     memoization  Tc - 0(n) , Sc -0(n) [DP]
     public static int memo(int n){
         if( n <= 1){
             return n;
         }
         if(dp[n] != -1){
             return dp[n];
         }
         dp[n] = memo(n-1) + memo(n-2);
         return dp[n];
     }


    // tabulation (TC- 0(n) , SC - 0(n))
     public static int tabu(int n){
         dp[0] = 0;
         dp[1] = 1;
         for(int i=2; i<=n; i++){
             dp[i] = dp[i-1] + dp[i-2];
         }
         return dp[n];
     }

    // space optimization (TC- 0(n) , SC - 0(1))
    public static int fibo(int n){
        int prev1 = 1;
        int prev2 = 0;
        for(int i=2; i<=n; i++){
            int cur = prev1 + prev2;
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
}