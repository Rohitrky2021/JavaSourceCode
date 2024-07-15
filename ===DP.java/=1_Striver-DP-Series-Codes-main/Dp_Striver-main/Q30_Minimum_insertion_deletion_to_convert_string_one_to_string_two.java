public class Q30_Minimum_insertion_deletion_to_convert_string_one_to_string_two {
    
    public static int lowestCommonSubsequence(int n, int m, String s1, String s2){

        int[][] dp = new int[n+1][m+1];

        for(int idx1 = 1; idx1 <= n; idx1++){

            for(int idx2 = 1; idx2 <= m; idx2++){

                if(s1.charAt(idx1 - 1) == s2.charAt(idx2 - 1)) dp[idx1][idx2] = 1 + dp[idx1 - 1][idx2 - 1];

                else dp[idx1][idx2] = Math.max(dp[idx1 - 1][idx2], dp[idx1][idx2 - 1]);

            }

        }

        return dp[n][m];

    }

    public static void main(String[] args) {
        
        String s1 = "a";
        String s2 = "ab";

        int n = s1.length();
        int m = s2.length();

        int lcs = lowestCommonSubsequence(n, m, s1, s2);

        int ans = (n - lcs) + (m - lcs);

        System.out.println(ans);

    }

}
