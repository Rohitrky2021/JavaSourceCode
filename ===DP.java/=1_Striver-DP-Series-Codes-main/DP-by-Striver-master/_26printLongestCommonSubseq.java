public class _26printLongestCommonSubseq {
    public static void main(String[] args) {
        String s = "bbabacaa";
        String t = "cccababab";
        int n= s.length();
        int m = t.length();
        int[][] dp = new int[m+1][m+1];// Taking m bcoz given m is always larger string
        for (int i=1; i<=n; i++){// Normal Tabu to fill DP 
            for (int j=1; j<=m; j++){
                if(s.charAt(i-1) == t.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
/*
 *   After DP Just Traversing Back and Getting the Longest path  
 *   Time Complexity: O(n*m) || Space Complexity: O(n*m)
 *   Where 'n' is length of string 's1' and 'm' is length of string 's2'.
*/ 
        String ans = "";
        while( n >= 1 && m >= 1){
            if(s.charAt(n-1) == t.charAt(m-1)){
                ans = s.charAt(n-1) + ans;
                n--;
                m--;
                continue;
            }
            if(dp[n-1][m] > dp[n][m-1]){ // math path jhaa se aaye h wha jaana hai   
                ans = s.charAt(n-1) + ans;
                n--;
            }else{
                 ans = t.charAt(m-1) + ans;
                m--;
            }
        }
        System.out.println("common sub string is : "+ ans);
    }
}
