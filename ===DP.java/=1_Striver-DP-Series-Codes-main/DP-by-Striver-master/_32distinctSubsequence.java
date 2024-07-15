
// Given two strings s and t, return the number of distinct subsequences of s which equals t.

public class _32distinctSubsequence {
    public static void main(String[] args) {
        String s = "babgbag";
        String t = "bag";
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n][m];
        System.out.println("rec : " + rec(s,t,n-1,m-1));
        System.out.println("memo :" + memo(s,t,n-1,m-1,dp));
        System.out.println("tabu : "+ tabu(s,t,n,m));
        System.out.println("space otpimization : "+ space(s,t,n,m));
    }

    public static int rec(String s, String t, int i, int j){
        if(j < 0) return 1;
        if(i < 0) return 0;

        if(s.charAt(i) == t.charAt(j)){
            return rec(s,t,i-1,j-1) + rec(s,t,i-1,j);
        }else {
            return rec(s,t,i-1,j);
        }
    }
    public static int memo(String s, String t, int i, int j, int[][] dp){
        if(j < 0) return 1;
        if(i < 0) return 0;
        if(dp[i][j] != 0) return dp[i][j];
        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] =  memo(s,t,i-1,j-1, dp) + memo(s,t,i-1,j,dp);
        }else {
            return dp[i][j] =  memo(s,t,i-1,j, dp);
        }
    }

    public static int tabu(String s, String t, int n, int m){
        int[][] dp = new int[n+1][m+1];
        for(int i=0; i<=n; i++){
            dp[i][0] = 1;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }

    public static int space(String s, String t, int n, int m){
        int[] prev = new int[m+1];

        prev[0] = 1;

        for(int i=1; i<=n; i++){
            int[] curr = new int[m+1];
            curr[0] = 1;
            for(int j=1; j<=m; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    curr[j] = prev[j-1] + prev[j];
                }else{
                    curr[j] = prev[j];
                }
            }
            prev = curr;
        }
        return prev[m];
    }
}
//  Similar space Optimised Approach 
public class Solution {
    static int mod = 1000000007;
    public static int distinctSubsequences(String str, String sub) {
        int n = str.length(), m = sub.length();
        int[] ans = new int[m + 1];
        ans[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 0; j--) {
                if (j > 0 && str.charAt(i - 1) == sub.charAt(j - 1))
                    ans[j] = (ans[j - 1] + ans[j]) % mod;
            }
        }
        return ans[m];
    }
}