public class Oct6 {
    class Solution {
        int[][][] memo;
        int MOD = (int) 1e9 + 7;
        int n;
        int m;
        
        public int numOfArrays(int n, int m, int k) {
            memo = new int[n][m + 1][k + 1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= m; j++) {
                    Arrays.fill(memo[i][j], -1);
                }
            }
            
            this.n = n;
            this.m = m;
            return dp(0, 0, k);
        }
        
        public int dp(int i, int maxSoFar, int remain) {
            if (i == n) {
                if (remain == 0) {
                    return 1;
                }
                
                return 0;
            }
            
            if (remain < 0) {
                return 0;
            }
            
            if (memo[i][maxSoFar][remain] != -1) {
                return memo[i][maxSoFar][remain];
            }
            
            int ans = 0;
            for (int num = 1; num <= maxSoFar; num++) {
                ans = (ans + dp(i + 1, maxSoFar, remain)) % MOD;
            }
    
            for (int num = maxSoFar + 1; num <= m; num++) {
                ans = (ans + dp(i + 1, num, remain - 1)) % MOD;
            }
            
            memo[i][maxSoFar][remain] = ans;
            return ans;
        }
    }
}
