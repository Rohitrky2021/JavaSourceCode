package TWO_D_DP;

import java.util.Arrays;

public class Maximum_path_sum_2 {

    // Question - in matrix starting point is 1st row of any value and desti is any
    // value is n-1 row ****--Traverse - down ,down left diogonal ,down right
    // diogonal
    // SRC - any value of 1st row ....DESt - any value of last row
    // (starting point varibale , Ending point variable )

    // Recursion -- (TC-0(2^N) , SC-0(N))
    public static int rec(int r, int c, int grid[][]) {

        if (r == grid.length - 1) {

            return grid[r][c];
        }

        int down = Integer.MIN_VALUE;

        if (r + 1 < grid.length) {
            down = grid[r][c] + rec(r + 1, c, grid);
        }

        int right = Integer.MIN_VALUE;

        if (r + 1 < grid.length && c + 1 < grid[0].length) {
            right = grid[r][c] + rec(r + 1, c + 1, grid);
        }

        int left = Integer.MIN_VALUE;
        if (r + 1 < grid.length && c - 1 >= 0) {
            left = grid[r][c] + rec(r + 1, c - 1, grid);
        }

        int min = Math.max(down, Math.max(left, right));

        return min;
    }

    // Memorization + DP -( TC-O(N*N) ,SC-O(N*M)+0(N) )
    public static int DP(int r, int c, int grid[][], int dp[][]) {

        if (r == grid.length - 1) {

            return grid[r][c];
        }

        if (dp[r][c] != -1) {

            return dp[r][c];
        }

        int down = Integer.MIN_VALUE;

        if (r + 1 < grid.length) {
            down = grid[r][c] + DP(r + 1, c, grid, dp);
        }

        int right = Integer.MIN_VALUE;

        if (r + 1 < grid.length && c + 1 < grid[0].length) {
            right = grid[r][c] + DP(r + 1, c + 1, grid, dp);
        }

        int left = Integer.MIN_VALUE;
        if (r + 1 < grid.length && c - 1 >= 0) {
            left = grid[r][c] + DP(r + 1, c - 1, grid, dp);
        }

        int min = Math.max(down, Math.max(left, right));

        dp[r][c] = min;

        return min;
    }

    // Tabulation --( TC-O(N*N) ,SC-O(N*M) )
    public static int Tabulation(int grid[][], int n, int m) {

        int dp[][] = new int[n][grid[0].length];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (i == 0) {

                    dp[i][j] = grid[i][j];
                }

                else {

                    int up = Integer.MIN_VALUE;
                    int left = Integer.MIN_VALUE;
                    int right = Integer.MIN_VALUE;

                    up = 0;
                    up = grid[i][j] + dp[i - 1][j];

                    if (j != 0) {
                        left = 0;
                        left = dp[i - 1][j - 1] + grid[i][j];
                    }

                    if (j != m - 1) {
                        right = 0;
                        right = dp[i - 1][j + 1] + grid[i][j];
                    }

                    int max = Math.max(up, Math.max(left, right));
                    dp[i][j] = max;

                }
            }
        }

        for (int i = 0; i < grid.length; i++) {

            ans = Math.max(ans, dp[n - 1][i]);

        }

        return ans;

    }

    // Space Optimization - -( TC-O(N*N) ,SC-0(M) )
    public static int Space(int grid[][], int n, int m) {

        int dp[] = new int[m];

        Arrays.fill(dp, Integer.MIN_VALUE);

        for (int i = 0; i < n; i++) {

            int temp[] = new int[m];

            for (int j = 0; j < m; j++) {

                if (i == 0) {
                    temp[j] = grid[i][j];
                } else {
                    int up = Integer.MIN_VALUE;
                    int left = Integer.MIN_VALUE;
                    int right = Integer.MIN_VALUE;

                    if (dp[j] != Integer.MIN_VALUE) {
                        up = grid[i][j] + dp[j];
                    }

                    if (j != 0) {
                        left = dp[j - 1] + grid[i][j];
                    }

                    if (j != m - 1) {
                        right = dp[j + 1] + grid[i][j];
                    }

                    int max = Math.max(up, Math.max(left, right));
                    temp[j] = max;

                }
            }

            dp = temp;
        }

        int ans = 0;
        for (int v : dp) {
            ans = Math.max(ans, v);
        }

        return ans;

    }

    public static void main(String[] args) {
        int grid[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 66, 89, 34 } };
        int n = grid.length;

        // This is for Recursion and Memorization
        int dp[][] = new int[n][grid[0].length];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < grid[0].length; i++) {

            int t = DP(0, i, grid, dp); 

            ans = Math.max(ans, t);

        }

        
        
        System.out.println(ans);

    }
}
