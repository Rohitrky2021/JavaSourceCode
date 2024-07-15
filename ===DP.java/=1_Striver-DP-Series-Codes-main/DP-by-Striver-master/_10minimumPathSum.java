import java.util.Arrays;

/*
 * We are given an “N*M” matrix of integers. We need to find a path from the 
 * top-left corner to the bottom-right corner of the matrix, such that there 
 * is a minimum cost path that we select.

At every cell, we can move in only two directions: right and bottom. 
The cost of a path is given as the sum of values of cells of the given matrix.
 */

public class _10minimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {
                { 1, 2, 3 },
                { 4, 5, 4 },
                { 7, 5, 9 },
                // {5,9,6},
                // {11,5,2}
        };
        int m = grid.length;
        int n = grid[0].length;

        System.out.println("space opti : " + spaceOpti(grid, m, n));
        System.out.println("tabu sol : " + tabu(grid, m, n, new int[m][n]));
        System.out.println("memo sol : " + memo(grid, m - 1, n - 1, new int[m][n]));
        System.out.println("rec sol : " + rec(grid, m - 1, n - 1));
    }

    // Making short above recurr code
    public static int rec(int[][] grid, int m, int n) {
        if (m == 0 && n == 0) {
            return grid[m][n];
        }
        /*
         * if( m < 0 ){
         * m = 0;
         * return rec(grid, m, n-1);
         * }
         * if(n < 0){
         * n = 0;
         * return rec(grid, m-1, n);
         * }
         */
        if (m < 0 || n < 0)
            return (int) Math.pow(10, 9);

        int top = grid[m][n] + rec(grid, m - 1, n);
        int left = grid[m][n] + rec(grid, m, n - 1);

        return Math.min(top, left);
    }

    public static int memo(int[][] grid, int m, int n, int[][] dp) {
        if (m == 0 && n == 0) {
            return grid[m][n];
        }
        if (m < 0 || n < 0)
             return (int) Math.pow(10, 9);//Not IntMAX bcoz of Overflow 
        if (dp[m][n] != 0)
            return dp[m][n];

        int top = grid[m][n] + memo(grid, m - 1, n, dp);
        int left = grid[m][n] + memo(grid, m, n - 1, dp);

        return dp[m][n] = Math.min(top, left);
    }

    // Tabulation -- (TC-0(N*M) ,, SC-0(N*M))
    public static int tabu(int[][] grid, int n, int m, int[][] dp) {
        dp[0][0] = grid[0][0];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0) dp[i][j] = grid[i][j];
                else{
                    int up = grid[i][j];
                    if(i > 0) up += dp[i-1][j];
                    else up += (int)Math.pow(10, 9);

                    int left = grid[i][j];
                    if(j > 0) left += dp[i][j-1];
                    else left += (int)Math.pow(10, 9);

                    dp[i][j] = Math.min(up, left);
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    // Space Optimization ---(TC-0(N*M) ,, SC-0(M))
    public static int spaceOpti(int[][] grid, int m, int n) {
        int[] prev = new int[n];
        for(int i = 0; i < m; i++){
            int[] curr = new int[n];
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0) curr[j] = grid[i][j];
                else{
                    int up = grid[i][j];
                    if(i > 0) up += prev[j];
                    else up += (int)Math.pow(10, 9);

                    int left = grid[i][j];
                    if(j > 0) left += curr[j-1];
                    else left += (int)Math.pow(10, 9);

                    curr[j] = Math.min(up, left);
                }
            }
            prev = curr;
        }

        return prev[n-1];
    }
}
