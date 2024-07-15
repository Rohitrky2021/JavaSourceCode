/*
Problem Statement: Given a number of stairs. 
Starting from the 0th stair we need to climb to the “Nth” stair. 
At a time we can climb either one or two steps. We need to return 
the total number of distinct ways to reach from 0th to Nth stair.
 */

public class _02climbingStairs {
    public static void main(String[] args) {
        int n = 25;
        long [] dp = new long[n+1];
        System.out.println((int) (solveMemo(n, dp)% 1000000007));
        System.out.println((int) (solveTabu(n, dp)% 1000000007));
        System.out.println((int) (solveSpaceOpti(n)% 1000000007));
    }
// Using Memorization DP - (TC  -0(N) ,Sc- 0(N)) 
    public static long solveMemo(int n, long[] dp){
        if(n == 0) return 1;
        if(n == 1) return 1;
        if(dp[n] != 0) return dp[n];
        long onestep = solveMemo(n-1, dp);
        long twostep = solveMemo(n-2, dp);
        dp[n] = onestep + twostep;
        return dp[n];
    }

    public static long solveTabu(int n, long[] dp){
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
 //Using Tabulation +Space Optimization --(Tc -0(N) , SC  -0(1))
    public static long solveSpaceOpti(int n){
        long prev1 = 1;
        long prev2 = 1;
        for(int i=2; i<=n; i++){
            long cur = prev1 + prev2;
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
}
