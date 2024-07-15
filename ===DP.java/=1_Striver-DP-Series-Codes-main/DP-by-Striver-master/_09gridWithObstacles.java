/*
 * We are given an “N*M” Maze. The maze contains some obstacles. 
 * A cell is ‘blockage’ in the maze if its value is -1. 0 represents non-blockage. 
 * There is no path possible through a blocked cell.

We need to count the total number of unique paths from the top-left 
corner of the maze to the bottom-right corner. At every cell, we can move either down or towards the right.
 */



public class _09gridWithObstacles {
    public static void main(String[] args) {
        int[][] grid = {
            {0,0,0},
            {0,1,0},
            {0,0,0}
        };
        int m = grid.length;
        int n = grid[0].length;

        System.out.println("space opti : "+ solveSpaceOpti(grid, m, n));
        System.out.println("tabu ans : "+ tabu(grid, m, n));
        System.out.println("memo ans : "+ solveMemo(grid,m-1,n-1, new int[m][n]));
        System.out.println("recursion ans : " + solveRec(grid,m-1,n-1));
    }
    
//  Recursion -- Tc-0(2^N*M) ,SC-0(N+M)(path length)
    public static int solveRec(int[][] grid, int m, int n){
        if(m == 0 && n == 0) return 1;
        if(m < 0 || n < 0 || grid[m][n] == 1) return 0; // Just add one more COndition of backtrack
        int up = solveRec(grid, m-1, n);
        int left = solveRec(grid, m, n-1);
        return up + left;
    }

// Memorization + DP--(TC - 0(N*M) ,SC-0(N*M)+0(N+M))
    public static int solveMemo(int[][] grid, int m, int n, int[][] dp){
        if(m == 0 && n == 0) return 1;
        if(m < 0 || n < 0 || grid[m][n] == 1) return 0;
        if(dp[m][n] != 0) return dp[m][n];
        int up = solveMemo(grid, m-1, n, dp);
        int left = solveMemo(grid, m, n-1, dp);
        return dp[m][n] = up + left;
    }
 
// Tabulation ---(TC-0(N*M) . sc - 0(N*M))
    public static int tabu(int[][] grid, int m, int n){
        int[][] dp = new int [m][n];
        for(int i=0; i<m;i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1) dp[i][j] = 0;
                else if(i==0 && j == 0) dp[i][j] = 1;
                else{
                    int down =0, right = 0;
                    if(i>0) down = dp[i-1][j];
                    if(j>0) right = dp[i][j-1];
                    dp[i][j] = down + right;
                }
            }
        }
        return dp[m-1][n-1];
    }

//   Space Optimization --(TC-0(N*M) , SC-0(M))
    public static int solveSpaceOpti(int[][] grid, int m, int n){
        int prev[]=new int[n];
        for(int i=0; i<n; i++){
            int temp[]=new int[m];
            for(int j=0; j<m; j++){
                if(i>0 && j>0 && grid[i][j]==1){
                    temp[j]=0;
                    continue;
                }
                if(i==0 && j==0){
                    temp[j]=1;
                    continue;
                }    
                int up=0; int left =0;  

                if(i>0)
                    up = prev[j];
                if(j>0)
                    left = temp[j-1];
                    
                temp[j] = up + left;
            }
            prev = temp;
        }
        return prev[n-1];
    }
}
