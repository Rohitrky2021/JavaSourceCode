// in this problem we have given a string s1 we have to return the length of longest subsequence
// which is pallindrome
// to solve this we were using same approach of longest common subsequence in which we have two strings
// so we create another string and set it as reverse of string s1 which is given and pass both in
// longest common subsequence problem it'll return length of longest substring
public class Q28_Longest_pallindrome_subsequence {

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
// Below ones are the Most optimised Codes 
class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        return dp(s, dp, 0, len - 1);
    }
    public int dp(String s, int[][] dp, int i, int j){
        if (dp[i][j] != 0) return dp[i][j];
        if (i > j) return 0;
        if (i == j) return 1;
        if (j == i + 1 && s.charAt(i) == s.charAt(j)) return 2;
        if (s.charAt(i) == s.charAt(j)){
            return dp[i][j] = 2 + dp(s, dp, i + 1, j - 1);
        }
        else{
            return dp[i][j] = Math.max(dp(s, dp, i + 1, j), dp(s, dp, i, j - 1));
        }
    }
}
// Time complexity is O(n^2) ||  space complexity is O(n).
class Solution {
        public int longestPalindromeSubseq(String s) {
        char[] c = s.toCharArray();
        int n = c.length, max = 0;
        int[] dp = new int[n];
        for(int j = 0; j < n; j++) {
            dp[j] = 1;
            max = 0;
            for(int i = j-1; i >= 0; i--) {
                int len = dp[i];
                if(c[i] == c[j]) 
                    dp[i] = 2 + max;
                
                max = Math.max(max, len);
            }
        }
        for(int len: dp) 
            max = Math.max(max, len);
        return max;
    }
}
    public static void main(String[] args) {
        
        String s= "bbabcbcab";

        String t = ""; // store s into reverse form

        for(int i = s.length() - 1; i >= 0; i--) t += s.charAt(i);

        int n = s.length(); // both string length is same

        System.out.println(lowestCommonSubsequence(n, s, t));

    }

}
