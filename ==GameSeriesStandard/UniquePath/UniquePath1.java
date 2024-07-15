public class UniquePath1 {
    // Just give the number of Path to reach the other corner 
    // https://leetcode.com/problems/unique-paths/submissions/
    class Solution {
        public int uniquePaths(int m, int n) {
            //  int m = obstacleGrid.length;
                // int n = obstacleGrid[0].length;
                int dp[][] = new int[m][n];
                return helper(0,0,m,n,dp);
            }
            public int helper(int r,int c,int m,int n,int[][] dp){
                if(r == m || c == n)return 0;
                if(r == m-1 && c == n-1){
                    // if(grid[r][c] == 1)return 0;
                    return 1;
                }
                if(dp[r][c] > 0)return dp[r][c];
                return dp[r][c] = helper(r+1,c,m,n,dp)+helper(r,c+1,m,n,dp);
            }
    }
}
