//We are given two strings ‘S1’ and ‘S2’. We need to convert S1 to S2. The following three operations are allowed:
//
//        Deletion of a character.
//        Replacement of a character with another one.
//        Insertion of a character.
//        We have to return the minimum number of operations required to convert S1 to S2 as our answer.

import java.util.*;

public class _33editDistance {
    public static void main(String[] args) {
        String s = "horse";
        String t = "ros";
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n][m];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        System.out.println("memo " + memo(s,t,n-1,m-1, dp));
        System.out.println("tabu :" + tabu(s,t,n,m));
    }
    // My Leetcode Soln
    public int check(String w1, String w2, int m, int n, int[][] memo) {
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }
        if (memo[m][n] != -1) {
            return memo[m][n];
        }
        if (w1.charAt(m - 1) == w2.charAt(n - 1)) {
            memo[m][n] = check(w1, w2, m - 1, n - 1, memo); // Got matched 
        } else {
            int ans1 = check(w1, w2, m, n - 1, memo); // Inser t into m
            int ans2 = check(w1, w2, m - 1, n, memo); // Delete form m
            int ans3 = check(w1, w2, m - 1, n - 1, memo);// Replace from any 
            memo[m][n] = Math.min(ans1, Math.min(ans2, ans3)) + 1;
        }

        return memo[m][n];
    }
// COde ninja One 
    public static int memo(String s, String t, int i, int j, int[][]dp){
        if(i<0)
            return j+1;
        if(j<0)
            return i+1;

        if(dp[i][j] != -1)return dp[i][j];

        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = memo(s,t,i-1, j-1, dp);
        }else{
            return dp[i][j] = Math.min(1+memo(s,t,i-1, j,dp), Math.min(1+memo(s,t, i-1, j-1,dp), 1+memo(s,t,i,j-1,dp)));
        }
    }
    public static int tabu(String s, String t, int n, int m){
        int[][] dp = new int[n+1][m+1];
        for(int i=1; i<=n; i++){
            dp[i][0] = i;
        }
        for(int j=1; j<=m; j++){
            dp[0][j] = j;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                     dp[i][j] = dp[i-1][ j-1];
                }else{
                     dp[i][j] = 1+  Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));
                }
            }
        }
        return dp[n][m];
    }

 // Space Optimization ----Tc-0(i*j) ,Sc-0(J)
     public static boolean space(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int dp[] = new int[m + 1];
        for (int j = 1; j <= m; j++) {
            dp[j] = 0;
        }
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int curr[] = new int[m + 1];
            Arrays.fill(curr, -1);
            for (int k = 1; k <= i; k++) {
                if (s1.charAt(k - 1) != '*') {
                    curr[0] = 0;
                }
            }
            if (curr[0] == -1) {
                curr[0] = 1;
            }
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1) || s1.charAt(i - 1) == '?') {
                    int t = dp[j - 1];
                    if (t == 1) {
                        curr[j] = 1;
                    } else {
                        curr[j] = 0;
                    }
                } else if (s1.charAt(i - 1) == '*') {
                    int non = dp[j];
                    int rem = curr[j - 1];
                    if (non == 1 || rem == 1) {
                        curr[j] = 1;
                    } else {
                        curr[j] = 0;
                    }
                } else {
                    curr[j] = 0;
                }
            }
            dp = curr;
        }
        if (dp[m] == 1) {
            return true;
        }
        return false;
    }
}
