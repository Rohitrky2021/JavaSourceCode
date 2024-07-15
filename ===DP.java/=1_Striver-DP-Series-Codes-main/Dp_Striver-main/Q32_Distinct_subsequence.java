// in this problem we have given two strings s1 and s2 we have to return count of distinct subsequence
// of s2 which can be formed in s1
// s1 : "babgbag", s2 : "bag"
// bag can be made using 5 ways like if we conside last g, if if not consider last
public class Q32_Distinct_subsequence {

    public static void main(String[] args) {
        String s1 = "babgbag";
        String s2 = "bag";

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i = 0; i <= n; i++) dp[i][0] = 1;

        for(int i = 1; i <= n; i++){

            for(int j = 1; j <= m; j++){

                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
                else dp[i][j] = dp[i-1][j];  

            }

        }

        System.out.println(dp[n][m]);
    }

}
