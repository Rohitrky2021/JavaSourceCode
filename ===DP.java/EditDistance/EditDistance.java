// class Solution {
    // https://leetcode.com/problems/edit-distance/
        public class EditDistance {

        public int minDistance(String word1, String word2) {
            return check(word1, word2, word1.length(), word2.length());
            // int ans=minDistance(word1)
    
        }
    
        public int check(String w1, String w2, int m, int n) {
            int[][] dp = new int[w1.length() + 1][w2.length() + 1];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
    
            if (m == 0) {
                return n;
            }
            int a = 0;
    
            if (n == 0) {
                return m;
            }
    
            if (dp[m][n] != -1) {
                return dp[m][n];
            }
    
            if (w1.charAt(m - 1) == w2.charAt(n - 1)) {
                return dp[m][n] = check(w1, w2, m - 1, n - 1);
            }
            // if (w1.charAt(m) == w2.charAt(n)) {
            //      a+= check(w1, w2, m - 1, n - 1);
            // }
            else {
                int ans1 = check(w1, w2, m, n - 1);
                int ans2 = check(w1, w2, m - 1, n);
                int ans3 = check(w1, w2, m - 1, n - 1);
    
                dp[m][n] = Math.min(ans1, Math.min(ans2, ans3)) + 1;
            }
            // System.gc();
            return dp[m][n];
            // return ans+ok;
        }
    }
    
}
