/*
We are given an ‘N*M’ matrix. Every cell of the matrix has some chocolates on it,
mat[i][j] gives us the number of chocolates. We have two friends ‘Alice’ and ‘Bob’.
initially, Alice is standing on the cell(0,0) and Bob is standing on the cell(0, M-1).
Both of them can move only to the cells below them in these three directions: to the bottom cell (↓),
to the bottom-right cell(↘), or to the bottom-left cell(↙).

When Alica and Bob visit a cell, they take all the chocolates from that cell with them.
It can happen that they visit the same cell, in that case, the chocolates need to be considered only once.
 */

public class _13NinjaAndHisFriend3D {
    public static void main(String[] args) {
        int[][] arr = {
                { 2, 3, 1, 2 },
                { 3, 4, 2, 2 },
                { 5, 6, 3, 5 }
        };

        int n = arr.length;
        int m = arr[0].length;
        System.out.println("rec : " + rec(arr, n, m, 0, 0, m - 1));
        System.out.println("memo :" + memo(arr, n, m, 0, 0, m - 1, new int[n][m][m]));
        System.out.println("tabu : " + tabu(arr, n, m));
    }

    // Same as Pickup Cherry 2
    // Time complexity: O(3^(R*C)) Space complexity: O(R*C)
    public static int rec(int[][] arr, int n, int m, int i, int j1, int j2) {
        if (j1 < 0 || j2 < 0 || j1 >= m || j2 >= m) {
            return (int) (Math.pow(-10, 9));
        }
        if (i == n - 1) {
            if (j1 == j2)
                return arr[i][j1];
            return arr[i][j1] + arr[i][j2];
        }
        int maxi = Integer.MIN_VALUE;
        for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {
                int ans;
                if (j1 == j2)
                    ans = arr[i][j1] + rec(arr, n, m, i + 1, j1 + di, j2 + dj);
                else
                    ans = arr[i][j1] + arr[i][j2] + rec(arr, n, m, i + 1, j1 + di, j2 + dj);
                maxi = Math.max(maxi, ans);
            }
        }
        return maxi;
    }
// Time Complexity: O(N*M*M) * 9  Space Complexity: O(N) + O(N*M*M)
    public static int memo(int[][] arr, int n, int m, int i, int j1, int j2, int[][][] dp) {
        if (j1 < 0 || j2 < 0 || j1 >= m || j2 >= m) {
            return (int) (Math.pow(-10, 9));
        }
        if (i == n - 1) {
            if (j1 == j2)
                return arr[i][j1];
            return arr[i][j1] + arr[i][j2];
        }
        if (dp[i][j1][j2] != 0)
            return dp[i][j1][j2];
        int maxi = Integer.MIN_VALUE;
        for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {
                int ans;
                if (j1 == j2)
                    ans = arr[i][j1] + memo(arr, n, m, i + 1, j1 + di, j2 + dj, dp);
                else
                    ans = arr[i][j1] + arr[i][j2] + memo(arr, n, m, i + 1, j1 + di, j2 + dj, dp);
                maxi = Math.max(maxi, ans);
            }
        }
        return dp[i][j1][j2] = maxi;
    }
/*
  *  TC =: O(R * (C^2))  SC=: O(R * (C^2))
 */
    public static int maximumChocolatesHelper(int currRow, int c1, int c2, 
        int[][] grid, int[][][] dp) { 
        if (currRow == grid.length || c1 < 0 || c1 >= grid[0].length || 
            c2 < 0 || c2 >= grid[0].length || c1 > c2) { 
            return 0;
        } 
        if (dp[currRow][c1][c2] != -1) {
            return dp[currRow][c1][c2];
        } 
        int maximumChocolates = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) { 
                maximumChocolates = Math.max(maximumChocolates, 
                maximumChocolatesHelper(currRow + 1, c1 + i, c2 + j, grid, dp));
            }
        } 
        if (c1 != c2) {
            maximumChocolates += grid[currRow][c2];
        } 
        dp[currRow][c1][c2] = (maximumChocolates + grid[currRow][c1]); 
        return dp[currRow][c1][c2];
        }
    }

  /*
   * Time complexity: O(R * (C^2))   Space complexity: O(R * (C^2)) 
 */
    public static int tabu(int[][] grid, int n, int m) {
        int dp[][][] = new int[n][m][m];

        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2)
                    dp[n - 1][j1][j2] = grid[n - 1][j1];
                else
                    dp[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
            }
        }
        // Outer Nested Loops for travering DP Array
        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int maxi = Integer.MIN_VALUE;
                    // Inner nested loops to try out 9 options
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            int ans;
                            if (j1 == j2)
                                ans = grid[i][j1];
                            else
                                ans = grid[i][j1] + grid[i][j2];

                            if ((j1 + di < 0 || j1 + di >= m) ||
                                    (j2 + dj < 0 || j2 + dj >= m))

                                ans += (int) Math.pow(-10, 9);
                            else
                                ans += dp[i + 1][j1 + di][j2 + dj];

                            maxi = Math.max(ans, maxi);
                        }
                    }
                    dp[i][j1][j2] = maxi;
                }
            }
        }
        return dp[0][0][m - 1];
    }
 /*
  *   space optimization
  *  Time complexity: O(R * (C^2))
  *  Space complexity: O(C^2) 
  *  Where 'R' is the number of rows and 'C' is the number of columns in the grid.
*/     
    // for 1D array - two variable
    // for 2D array - 1D array
    // for 3D array - 2D array
    // so we 2D array instead of 3D
    // as we can see for i row it is always i+1 so we use prev and curr concept
    {
    int[][] dp = new int[m][m];
    for( int j1 = 0;j1<m;j1++) 
    {
        for (int j2 = 0; j2 < m; j2++) {
            if (j1 == j2)
                dp[j1][j2] = matrix[n - 1][j1];
            else
                dp[j1][j2] = matrix[n - 1][j1] + matrix[n - 1][j2];
        }
    }for(
    int i = n - 2;i>=0;i--)
    {
        int[][] curr = new int[m][m];
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                int maxi = -(int) Math.pow(10, 9);
                for (int dj1 = -1; dj1 <= 1; dj1++) {
                    for (int dj2 = -1; dj2 <= 1; dj2++) {
                        int ans;
                        if (j1 == j2)
                            ans = matrix[i][j1];
                        else
                            ans = matrix[i][j1] + matrix[i][j2];

                        if (j1 + dj1 >= 0 && j1 + dj1 < m && j2 + dj2 >= 0 && j2 + dj2 < m) {
                            ans += dp[j1 + dj1][j2 + dj2];
                        } else
                            ans += -(int) Math.pow(10, 9);
                        maxi = Math.max(maxi, ans);
                    }
                }
                curr[j1][j2] = maxi;
            }
        }
        dp = curr;
    }
    return dp[0][m-1];
}
}
