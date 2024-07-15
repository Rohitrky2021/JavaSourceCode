// in the problem we have given a string and we want to return min insertion which we can do
// to make the string pallindrome
// we can use longest pallindrome subsequence sol in this
// using prev prob we got the length of longest pallinrome
// if we subtract this length from length of string we got length of string which is not pallindrome
// so we have to insert that length to make the string pallindrome 
public class Q29_Min_insertion_to_make_string_pallindrome {

    public static int lowestCommonSubsequence(int n, String s, String t){

        int[][] dp = new int[n+1][n+1];

        for(int idx1 = 1; idx1 <= n; idx1++){

            for(int idx2 = 1; idx2 <= n; idx2++){

                if(s.charAt(idx1 - 1) == t.charAt(idx2 - 1)) dp[idx1][idx2] = 1 + dp[idx1 - 1][idx2 - 1];

                else dp[idx1][idx2] = Math.max(dp[idx1 - 1][idx2], dp[idx1][idx2 - 1]);

            }

        }

        return dp[n][n];

    }

    public static void main(String[] args) {

        String s= "abcaa";

        int n = s.length();

        String t = ""; // store s into reverse form

        for(int i = s.length() - 1; i >= 0; i--) t += s.charAt(i);

        int longestpallindromelen = lowestCommonSubsequence(n, s, t);

        int ans = n - longestpallindromelen;

        System.out.println(ans);
    }
}
