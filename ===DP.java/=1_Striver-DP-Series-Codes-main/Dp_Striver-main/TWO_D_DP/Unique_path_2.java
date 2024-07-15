package TWO_D_DP;


import java.util.Arrays;

public class Unique_path_2 {

   //Question -- unique path in grid only traverse 0 cell and -1 cell is blocked 

    // Simple Recursion -- Tc-0(2^N*M) ,SC-0(N+M)(path length)
    public static int Rec(int r, int c, int col, int row, int grid[][]) {
        if (r == col - 1 && c == row - 1) {
            return 1;
        }
        int right = 0;
        if (c + 1 < row) {
            if (grid[r][c + 1] == 0) {
                right = Rec(r, c + 1, col, row, grid);
            }

        }

        int down = 0;
        if (r + 1 < col) {
            if (grid[r + 1][c] == 0) {
                down = Rec(r + 1, c, col, row, grid);
            }

        }

        return right + down;
    }

    // Memorization + DP--(TC - 0(N*M) ,SC-0(N*M)+0(N+M))
    public static int CountDp(int r, int c, int col, int row, int dp[][], int grid[][]) {
        if (r == col - 1 && c == row - 1) {
            return 1;
        }

        if (dp[r][c] != -1) {
            return dp[r][c];
        }

        int right = 0;
        if (c + 1 < row) {
            if (grid[r][c + 1] == 0) {
                right = CountDp(r, c + 1, col, row, dp, grid);
            }

        }

        int down = 0;
        if (r + 1 < col) {
            if (grid[r + 1][c] == 0) {
                down = CountDp(r + 1, c, col, row, dp, grid);
            }

        }

        dp[r][c] = right + down;
        return right + down;
    }

    // Tabulation ---(TC-0(N*M) . sc - 0(N*M))
    public static int CountTab(int grid[][], int row, int col) {
        int n = grid.length;
        int m = grid[0].length;
       
        int dp[][] = new int[n][m];

        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == -1) { //This condition only add 
                    continue;
                }

                if (i == 0 && j == 0) {
                    dp[0][0] = 1;
                } 
                else {
                    int up = 0;
                    int down = 0;
                    if (i - 1 >= 0) {
                        up = dp[i - 1][j];
                    }
                    if (j - 1 >= 0) {
                        down = dp[i][j - 1];
                    }
                    dp[i][j] = (up + down) % 1000000007;
                }
            }
        }

        return dp[n - 1][m - 1];
    }

    //   Space Optimization --(TC-0(N*M) , SC-0(M))
    public static int Space(int grid[][], int row, int col) {

        int dp[] = new int[col];

        Arrays.fill(dp, 0);
        for (int i = 0; i < row; i++) {

            int temp[] = new int[col];

            for (int j = 0; j < col; j++) {
                
                if (grid[i][j] == -1) {
                    continue;
                }

                if (i == 0 && j == 0) {
                    temp[j] = 1;
                } else {
                    int up = 0;
                    int down = 0;

                    up = dp[j];
                    // here up calculate becuas need prev for tabulation (oposite direc)
                    if (j - 1 >= 0) {
                        down = temp[j - 1];
                    }

                    temp[j] = up + down;
                    // here down calculate becuas need prev for tabulation (oposite direc)
                }
            }
            dp = temp;
        }

        return dp[col - 1];
    }

    public static void main(String[] args) {

    }
}
