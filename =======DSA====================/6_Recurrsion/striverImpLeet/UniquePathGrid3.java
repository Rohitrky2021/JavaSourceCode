public class UniquePathGrid3 {
// https://leetcode.com/problems/unique-paths-ii/description/
// Above modified Q u can the break the obstacle ones in our way only;

    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            int dp[][] = new int[m][n];
            int k=2;
            return helper(obstacleGrid,0,0,m,n,dp,k);
        }
        public int helper(int[][] grid,int r,int c,int m,int n,int[][] dp,int k){
            if(r == m || c == n ||  k<=0)return 0;
            if(grid[r][c] == 1)k--;
            if(r == m-1 && c == n-1){
                if(grid[r][c] == 1)return 0;
                return 1;
            }
            if(dp[r][c] > 0)return dp[r][c];//same like !=-1 
            return dp[r][c] = helper(grid,r+1,c,m,n,dp,k)+helper(grid,r,c+1,m,n,dp,k);
        }
    }
}
