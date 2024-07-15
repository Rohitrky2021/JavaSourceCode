public class PathSum{
    public static void main(String[] args) {
        int[][] grid = {{5, 1, 4},
                        {3, 0, 5},
                         {0, 7, 2}};
        int k = 3;

        Solution solution = new Solution();
        int result = solution.numberOfPaths(grid, k);

        System.out.println("Number of paths with sum divisible by " + k + " is: " + result);
    }
}
class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int sum=0;
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        return helper(grid,0,0,m,n,dp,k,sum);
    }

    public int helper(int[][] grid,int r,int c,int m,int n,int[][] dp,int k,int sum){
        //  sum=0;
        if(r == m || c == n )return 0;
        if(r == m-1 && c == n-1  ){
            sum+=grid[r][c];
            System.out.println(grid[r][c] +" "+sum+" "+dp[r][c]);
            if(sum%k==0)return 1;
            return 0;
        }
        System.out.println(grid[r][c] +" "+sum);
        if(dp[r][c] > 0)return dp[r][c];
        sum+=grid[r][c];
           
        return dp[r][c] = helper(grid,r+1,c,m,n,dp,k,sum)+helper(grid,r,c+1,m,n,dp,k,sum);
    }
}