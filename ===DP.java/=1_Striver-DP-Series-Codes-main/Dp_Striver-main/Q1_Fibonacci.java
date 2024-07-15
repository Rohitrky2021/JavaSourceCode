import java.util.Arrays;

public class Q1_Fibonacci{

    // memoization
    // we have an array dp[n] in which by default fill with -1
    // if n is less than equal to 1 then return n
    // if dp[n] is not equal to -1 that means we already have that fibonacci
    // at end return for n-1 and n-2 
    public static int fun(int n, int[] dp){
        if(n <= 1) return n;
        if(dp[n] != -1) return dp[n];
        return dp[n] = fun(n-1, dp) + fun(n-2, dp);
    }

    public static void main(String[] args) {
        int n = 6;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        // System.out.println(fun(n, dp));

        // // tabulation
        // // similar with base case
        // // now start loop from i = 2 till n at end at dp[n] we have the ans so print it
        // // it'll take tc & sc as o(n)
        // dp[0] = 0;
        // dp[1] = 1;

        // for(int i = 2; i <= n; i++){
        //     dp[i] = dp[i-1] + dp[i-2];
        // }
        // System.out.println(dp[n]);

        // now we can make sc as o(1) by reducing the use of dp array
        // use two variales prev1 for i-1 and prev2 for i-2
        // start loop from i = 2 till n
        // inside loop create a var curri = prev1 + prev2
        // now make prev1 as prev2, prev1 as curri
        // prev2 = prev1, prev1 = curri
        // so at end curri will got at n+1 and in prev1 we have stored our ans for nth factoria;

        int prev2 = 0;
        int prev1 = 1;

        for(int i = 2; i <= n; i++){
            int curri = prev1 + prev2;
            prev2 = prev1;
            prev1 = curri;
        }
        System.out.println(prev1);
    }
}