import java.util.Scanner;
// in this problem we have given a grid of m*n each box contains an amount
// we are at top left and want to reach bottom right
// we have to find a path in which we can get min coin collected
// so this is similar question like previous but here each path has cost
// so when reach destination (0,0) return the cost of that index
// when index reach out of bound retunn a maximum value so when we compare so we don't get this value
public class Q10_Min_path_sum_in_grid {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();
        int[][] grid = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                grid[i][j] = scn.nextInt();
            }
        }
        scn.close();

        // System.out.println(helper(m-1, n-1, grid));

        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i], -1);
        }

        System.out.println(helper2(m-1, n-1, grid, dp));

        // tabulation
        // int[][] dp = new int[m][n];
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
        System.out.println(dp[m-1][n-1]);

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
        System.out.println(prev[n-1]);
    }

    public static int helper(int i, int j, int[][] grid){

        if(i == 0 && j == 0) return grid[i][j];

        if(i < 0 || j < 0) return (int)Math.pow(10, 9);

        int up = grid[i][j] + helper(i-1, j, grid);

        int left = grid[i][j] + helper(i, j-1, grid);

        return Math.min(up, left);

    }

    public static int helper2(int i, int j, int[][] grid, int[][] dp){

        if(i == 0 && j == 0) return grid[i][j];

        if(i < 0 || j < 0) return (int)Math.pow(10, 9);

        if(dp[i][j] != -1) return dp[i][j];

        int up = grid[i][j] + helper2(i-1, j, grid, dp);

        int left = grid[i][j] + helper2(i, j-1, grid, dp);

        return dp[i][j] = Math.min(up, left);

    }

}
