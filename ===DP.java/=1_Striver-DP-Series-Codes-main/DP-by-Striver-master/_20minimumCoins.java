/*
We are given a target sum of ‘X’ and ‘N’ distinct numbers denoting the coin denominations.
We need to tell the minimum number of coins required to reach the target sum. We can pick a
coin denomination for any number of times we want.
 */

import java.util.Arrays;

public class _20minimumCoins {
    public static void main(String[] args) {
        int[] coin = {1,5,6,9};
        int tar = 11;
        int n = coin.length;
        int[][] dp = new int[n][tar+1];
        System.out.println("rec : "+ rec(coin, tar, n-1));
        System.out.println("memo : " + memo(coin,tar,n-1,dp));
        System.out.println("tabu : "+ tabu(coin, tar, n));
        System.out.println("space opti : "+space(coin, tar, n));
    }

    public static int rec(int[] c, int t, int i){
        if(i == 0){
            if(t%c[0] == 0) return t / c[0];
            else return (int) 1e9;
        }

        int not = 0 + rec(c, t, i-1);
        int take = Integer.MAX_VALUE;
        if(c[i] <= t) take = 1 + rec(c,t-c[i],i);

        return Math.min(take , not);
    }
// Time Complexity: O(N*T)   Space Complexity: O(N*T) + O(N)
     public static int memo(int[] c, int t, int i, int[][] dp){
        if(i == 0){
            if(t%c[0] == 0)
                 return t / c[0];
            else 
                return (int) 1e9;
        }

        if(dp[i][t] != 0) return dp[i][t];
        int not = 0 + memo(c, t, i-1, dp);
        int take = Integer.MAX_VALUE;
        if(c[i] <= t) take = 1 + memo(c,t-c[i],i, dp);

        return dp[i][t] =  Math.min(take , not);
    }
// Time Complexity: O(N*T)   Space Complexity: O(N*T)
     public static int tabu(int[] c, int t, int n){
        int[][] dp =new int[n][t+1];
        for(int i = 0; i <= t; i++){
            if( i % c[0] == 0) dp[0][i] = i /c[0];
            else dp[0][i] = (int) 1e9;
        }

        for(int i=1; i<n; i++){
            for(int j = 0; j<= t; j++){
                int take = (int) 1e9;
                if(c[i] <= j) take = 1 + dp[i-1][j-c[i]];
                int not = dp[i-1][j];
                dp[i][j] = Math.min(take, not);
            }
        }
        return dp[n-1][t];
    }
 // Space Complexity: O(T) 
    public static int space(int[] c, int t, int n){
        int prev[]=new int[t+1];
        int cur[] =new int[t+1];
        for(int i = 0; i <= t; i++){
            if(i % c[0] == 0) prev[i] = i /c[0];
            else prev[i] = 0;
        }

        for(int i=1; i<n; i++){
            for(int j = 0; j <= t; j++){
                int take = (int)1e9;
                if(c[i] <= j) take = 1 + cur[j-c[i]];
                int not = 0 + prev[j];
                cur[j] = Math.min(take, not);
            }
            prev = cur;
        }
        return prev[t];
    }
}
