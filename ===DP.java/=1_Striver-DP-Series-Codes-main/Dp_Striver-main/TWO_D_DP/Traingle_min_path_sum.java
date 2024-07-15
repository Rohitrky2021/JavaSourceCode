package TWO_D_DP;

public class Traingle_min_path_sum {

    // Question - minimum path sum in a traingle -- ***--Traverse only -
    // DOWN,Right-Diogonal
    //SRC - (0,0) ,DESt - any value of last row (starting point Fixed , Ending point variable )

    // Recursion --- TC( 0(2^N) ,SC_0(N))

    public static int Rec(int r, int c, int grid[][], int n, int m) {
        if (r == n - 1) {
            return grid[r][c];
        }

        int down = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if (r + 1 < n) {
            down = grid[r][c] + Rec(r + 1, c, grid, n, m);
        }

        if (r + 1 < n) {
            right = grid[r][c] + Rec(r + 1, c + 1, grid, n, m);
        }

        int ans = Math.min(right, down);
        return ans;
    }

    // Memorization +DP (TC -0(N*N) ,SC-0(N*N)+0(N))
    public static int DP(int r, int c, int grid[][], int n, int m, int dp[][]) {
        if (r == n - 1) {
            return grid[r][c];
        }

        if (dp[r][c] != -1) {
            return dp[r][c];
        }
        int down = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if (r + 1 < n) {
            down = grid[r][c] + DP(r + 1, c, grid, n, m, dp);
        }

        if (r + 1 < n) {
            right = grid[r][c] + DP(r + 1, c + 1, grid, n, m, dp);
        }

        int ans = Math.min(right, down);
        dp[r][c] = ans;
        return ans;

    }

    // Tabulation --(TC-0(N*N) ,SC-0(N*N) )
    public static int Tabulation(int grid[][], int n) {

        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        // --------------Tabulation------------
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else {
                    int up = Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;

                    if (j != i) {
                        up = dp[i - 1][j] + grid[i][j];
                    }

                    if (j != 0) {
                        left = dp[i - 1][j - 1] + grid[i][j];
                    }

                    dp[i][j] = Math.min(left, up);
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(dp[n - 1][i], ans);
        }

        return ans;
    }

    // Space Optimization -- ( TC-0(N*N) ,SC-0(N) )
    public static int Space_Op(int grid[][], int n) {
        
        int ans = Integer.MAX_VALUE;
        int dp[] = new int[n];
        

        for (int i = 0; i < n; i++) {
            int temp[] = new int[n];
            for (int j = 0; j <= i; j++) {
                if (i == 0 && j == 0) {
                    temp[j] = grid[i][j];
                } else {
                    int up = Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;

                    if (j != i) {
                        up = dp[j] + grid[i][j];
                    }

                    if (j != 0) {
                        left = dp[j - 1] + grid[i][j];
                    }

                    temp[j] = Math.min(left, up);
                }
            }

            dp = temp;

        }

        for (int i = 0; i < n; i++) {
            ans = Math.min(dp[i], ans);

        }

        return ans;
    }

    public static void main(String[] args) {
        int grid[][] = {{1},{2,3},{3,6,7},{8,9,6,10}};
        System.out.println(Space_Op(grid, 4));
    }
}
