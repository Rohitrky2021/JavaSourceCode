public class KcostChangeONly {
    import java.util.Arrays;

class Solution {

    public int minimumDeleteSum(String w1, String w2) {
        int m = w1.length();
        int n = w2.length();
        int[][] dp = new int[m + 1][n + 1]; // Fix 1: Use m+1 and n+1 as the size of dp array

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return check(w1, w2, m, n, dp,k);
    }

    public int check(String w1, String w2, int m, int n, int[][] dp ,int k ) {
        if(dp[m][n]>k){
            return dp[m][n];
        }
        if (m == 0) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += w2.charAt(i);
            }
            return sum;
        }


        if (n == 0) {
            int sum = 0;
            for (int i = 0; i < m; i++) {
                sum += w1.charAt(i);
            }
            return sum;
        }

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        if (w1.charAt(m - 1) == w2.charAt(n - 1)) {
            return dp[m][n] = check(w1, w2, m - 1, n - 1, dp);
        } else {
            int ans1 = check(w1, w2, m, n - 1, dp) + Math.abs(w2.charAt(n - 1)-w1.charAt(m - 1))  ; // Add w2.charAt(n - 1) for deletion from w2
            // int ans2 = check(w1, w2, m - 1, n, dp) + ; // Add w1.charAt(m - 1) for deletion from w1
            // int ans3 = check(w1, w2, m - 1, n - 1, dp);

            dp[m][n] = ans1 ; // Fix 2: Only add w1.charAt(m-1)
        }

        return dp[m][n];
    }
}

}


 