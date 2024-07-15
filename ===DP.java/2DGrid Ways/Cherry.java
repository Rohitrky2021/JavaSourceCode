public class Cherry {
    
}
// class Solution {

//     public int cherryPickup(int[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;
//         int dp[][] = new int[m][n];
//         return helper(grid, 0, 0, m, n, dp);
//     }

//     public int helper(int[][] grid, int r, int c, int m, int n, int[][] dp) {
//         if (r == m || c == n || grid[r][c] == -1) return 0;
//         if (r == m - 1 && c == n - 1) {
//             if (grid[r][c] == 1) return 1;
//             return 1;
//         }
//         if (dp[r][c] > 0) return dp[r][c];
//         return dp[r][c] = helper(grid, r + 1, c, m, n, dp) + helper(grid, r, c + 1, m, n, dp);
//     }
// }

class Solution {

    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        int result = Math.max(0, helper(grid, 0, 0, m, n, dp));
        printDP(dp); // Print the dp array
        System.out.println();
        printDP(grid);
        return result;
    }

    public int helper(int[][] grid, int r, int c, int m, int n, int[][] dp) {
        if (r == m || c == n || grid[r][c] == -1) return 0;
        if (grid[r][c] == 1) {
            // Pick the cherry and set the cell to 0
            grid[r][c] = 0;
            return 1;
        }
        if (r == m - 1 && c == n - 1) {
            if (grid[r][c] == 1) {
                // Pick the cherry and set the cell to 0
                grid[r][c] = 0;
                return 1;
            }
            return 0;
        }

        // Count cherries while picking them
        int cherries = grid[r][c] == 1 ? 1 : 0;

        // Set the cell to 0
        grid[r][c] = 0;

        // Move down and right
        int down = helper(grid, r + 1, c, m, n, dp);
        int right = helper(grid, r, c + 1, m, n, dp);

        // Restore the cell value
        grid[r][c] = cherries;
      
        return   Math.max(down, right) + cherries;
    }

    public void printDP(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
