package TWO_D_DP;

import java.util.Arrays;

public class Minimum_Path_sum {

    // Question - Minimum Ptah Sum - -- -- only right / down traverse
    // Start - 0,0 and end - n-1,m-1 ---Start and end fixed

    // Simple Recursion (TC-0(2^N*M) ,, SC-0(N+M))
    public static int Rec(int r, int c, int grid[][]) {
        if (r == grid.length - 1 && c == grid[0].length - 1) {

            return grid[r][c];
        }

        int down = Integer.MAX_VALUE;
        if (r + 1 < grid.length) {
            down = grid[r][c] + Rec(r + 1, c, grid);
        }

        int right = Integer.MAX_VALUE;
        if (c + 1 < grid[0].length) {
            right = grid[r][c] + Rec(r, c + 1, grid);
        }

        int min = Math.min(down, right);

        return min;
    }

    // Memorization + DP - (TC-0(N*M) ,, SC-0(N*M)+0(N+M))
    public static int MiniDp(int r, int c, int grid[][], int dp[][]) {
        if (r == grid.length - 1 && c == grid[0].length - 1) {

            return grid[r][c];
        }

        if (dp[r][c] != -1) {

            return dp[r][c];
        }

        int down = Integer.MAX_VALUE;
        if (r + 1 < grid.length) {
            down = grid[r][c] + MiniDp(r + 1, c, grid, dp);
        }

        int right = Integer.MAX_VALUE;
        if (c + 1 < grid[0].length) {
            right = grid[r][c] + MiniDp(r, c + 1, grid, dp);
        }

        int min = Math.min(down, right);

        dp[r][c] = min;

        return min;
    }

    // Tabulation -- (TC-0(N*M) ,, SC-0(N*M))
    public static int MinTab(int grid[][]) {
        int n = grid.length;
        int m = grid[0].length;

        int dp[][] = new int[grid.length][grid[0].length];

        for (int ik = 0; ik < grid.length; ik++) {
            for (int j = 0; j < grid[0].length; j++) {
                dp[ik][j] = 0;
            }
        }

        // -----------------Tabulation -------------------

        dp[0][0] = grid[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {

                } else {

                    int up = Integer.MAX_VALUE;
                    // here up calculate becuas need prev for tabulation (oposite direc)
                    int left = Integer.MAX_VALUE;
                    if (i - 1 >= 0) {
                        up = grid[i][j] + dp[i - 1][j];
                    }

                    if (j - 1 >= 0) {
                        left = grid[i][j] + dp[i][j - 1];
                    }
                    // here left calculate becuas need prev for tabulation (oposite direc)
                    int min = Math.min(up, left);
                    dp[i][j] = min;
                }
            }
        }

        return dp[n - 1][m - 1];

    }

    // Space Optimization ---(TC-0(N*M) ,, SC-0(M))
    public static int Minspace(int grid[][]) {

        int n = grid.length;
        int m = grid[0].length;

        int dp[] = new int[m];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = grid[0][0];

        for (int i = 0; i < n; i++) {

            int temp[] = new int[m];

            for (int j = 0; j < m; j++) {

                if (i == 0 && j == 0) {
                    temp[j] = dp[j];
                } else {
                    int up = Integer.MAX_VALUE;

                    // here up calculate becuas need prev for tabulation (oposite direc)
                    int left = Integer.MAX_VALUE;
                    // here left calculate becuas need prev for tabulation (oposite direc)
                    if (dp[j] != Integer.MAX_VALUE) {
                        up = grid[i][j] + dp[j];
                    }

                    if (j - 1 >= 0) {
                        left = grid[i][j] + temp[j - 1];
                    }

                    int min = Math.min(up, left);
                    temp[j] = min;

                }
            }

            dp = temp;
        }

        return dp[m - 1];

    }

    public static void main(String[] args) {
        int grid[][] = { { 1, 2, 3 }, { 4, 5, 6 } };
        System.out.println(Minspace(grid));
    }
}
