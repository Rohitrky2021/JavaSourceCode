/*
 * We are given a Triangular matrix. We need to find the minimum 
 * path sum from the first row to the last row.
 * At every cell we can move in only two directions: either 
 * to the bottom cell (↓) or to the bottom-right cell(↘)
 */

public class _11minPathInTriangle {
    public static void main(String[] args) {
        int[][] arr = {
            {1,-1,-1,-1},
            {2,3,-1,-1},
            {3,6,7,-1},
            {8,9,6,10}
        };
        int m = arr.length;
        int n = arr[0].length;

        System.out.println(spaceOpti(arr, m, n));
        System.out.println(tabu(arr,m,n));
        System.out.println(memo(arr, 0, 0, new int[m][n]));
        System.out.println(rec(arr,0, 0));
    }

    // Recursion --- TC( 0(2^N) ,SC_0(N))
    public static int rec(int[][]arr, int i, int j){
        if(i == arr.length-1) return arr[i][j];

        // if(j > i) { // Not needed line if no there then also work
        //     return rec(arr, i+1, j);
        // }//kyuki not valid j pe jaane k  liye m uske prev i p jaa he nhi rha hu
        int right = arr[i][j] + rec(arr, i+1, j);
        int down = arr[i][j] + rec(arr, i+1, j+1);

        return Math.min(right, down);
    }

    // Memorization +DP (TC -0(N*N) ,SC-0(N*N)+0(N))
    // SOme tiem after submitting this memo also give tle so Tabular required
    public static int memo(int[][]arr, int i, int j, int[][]dp){
        if(i == arr.length-1) return arr[i][j];

        // if(j > i) {
        //     return rec(arr, i+1, j);
        // }
        if(dp[i][j] != 0) return dp[i][j];
        int right = arr[i][j] + memo(arr, i+1, j,dp);
        int down = arr[i][j] + memo(arr, i+1, j+1,dp);

        return dp[i][j] = Math.min(right, down);
    }

    // Tabulation --(TC-0(N*N) ,SC-0(N*N) )
    public static int tabu(int[][] arr, int m, int n){
        int[][] dp = new int[n][n];
        // n-1 work done here
        for(int j = 0; j < n; j++) dp[n-1][j] = arr[n-1][j];
        // so here starting with n-2
        for(int i = n-2; i >= 0; i--){
            for(int j = i; j >= 0; j--){
                int down = arr[i][j] + dp[i+1][j];
                int diag = arr[i][j] + dp[i+1][j+1];
                dp[i][j] = Math.min(down, diag);
            }
        }
        return dp[0][0];
    }


   // Space Optimization -- ( TC-0(N*N) ,SC-0(N) )
    public static int spaceOpti(int[][] triangle, int m, int n){
        int[] prev = new int[n]; // down Row
        for(int j = 0; j < n; j++) prev[j] = triangle[n-1][j];

        for(int i = n-2; i >= 0; i--){
            int[] curr = new int[n]; // upper Row
            for(int j = i; j >= 0; j--){
                int down = triangle[i][j] + prev[j];
                int diag = triangle[i][j] + prev[j+1];
                curr[j] = Math.min(down, diag);
            }
            prev = curr;
        }

        return prev[0];
    }
}
