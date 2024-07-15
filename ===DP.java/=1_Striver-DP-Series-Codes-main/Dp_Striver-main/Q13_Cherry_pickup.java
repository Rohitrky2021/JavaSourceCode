// import java.util.*;

// in this question we have given a grid of size n*m, one person is at (0,0) and second is at (0,m-1)
// each cell of grid contains some choclate, both of them have to collect max choclate and reach 
// at any col of last row
// if both are at same col, then only one person can pick the choclate and other pic 0
// so we have two fixed point and destination is variable
// so we have to start from fixed
// we cannot do like find max for first then for second and add, if we do like that then the case
// where both reach same col will avoid
// they can travel in 3 direction, if they are at (i,j) then can move (i+1,j-1), (i+1,j) and (i+1,j+1)
// so we move both together so take i1, j1 and i2, j2
// here i1 and i2 will be same bcoz both can move one row down so indexes are i, j1, j2
public class Q13_Cherry_pickup {

    public static int helper(int i, int j1, int j2, int n, int m, int[][] matrix) {
        // control the out of bound indexes
        if (j1 < 0 || j2 < 0 || j1 >= m || j2 >= m)
            return -(int) Math.pow(10, 9);

        // base case
        // when i is last then it is destination so check both col
        // if both are same then only one can collect choclate
        // if both are diff then both can collection so add both cell value and return
        if (i == n - 1) {
            if (j1 == j2)
                return matrix[i][j1]; // or matrix[i][j2] bcoz both j1 and j2 are same
            else
                return matrix[i][j1] + matrix[i][j2];
        }

        // now if first person move (i+1, j-1) second can move (i+1, j-1), (i+1, j) and
        // (i+1, j+1)
        // so we have total 3*3 paths
        // i is same it is increasing for all paths but j1 and j2 varies from -1, +0, +1
        // so use a nested for loop to follow the path and use a variable maxi which
        // will return
        // the max path for both of them to reach destination, check j1 == j2 also

        int maxi = -(int) Math.pow(10, 9);
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                if (j1 == j2)
                    maxi = Math.max(maxi, matrix[i][j1] + helper(i + 1, j1 + dj1, j2 + dj2, n, m, matrix));
                else
                    maxi = Math.max(maxi,
                            matrix[i][j1] + matrix[i][j2] + helper(i + 1, j1 + dj1, j2 + dj2, n, m, matrix));
            }
        }

        return maxi;
    }

    public static void main(String[] args) {
        int matrix[][] = { 
                { 2, 3, 1, 2 },
                { 3, 4, 2, 2 },
                { 5, 6, 3, 5 } 
            };
        int n = matrix.length;
        int m = matrix[0].length;

        // recusion
        // helper(i, j1, j2, n, m, grid)
        // i is 0 in starting, j1 is 0 and j2 is m-1 this is the position of both person
        // System.out.println(helper(0, 0, m-1, n, m, matrix));

        // memoization
        // create a 3D dp and fill all the cell with -1
        // int[][][] dp = new int[n][m][m];
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < m; j++) {
        // Arrays.fill(dp[i][j], -1);
        // }
        // }

        // System.out.println(helper2(0, 0, m-1, n, m, matrix, dp));

        // tabulation
        // in the recusrio we have base case for last row so here in dp we fill for last
        // row
        // int[][][] dp = new int[n][m][m];

        // for (int j1 = 0; j1 < m; j1++) {
        //     for (int j2 = 0; j2 < m; j2++) {
        //         if (j1 == j2)
        //             dp[n - 1][j1][j2] = matrix[n - 1][j1];
        //         else
        //             dp[n - 1][j1][j2] = matrix[n - 1][j1] + matrix[n - 1][j2];
        //     }
        // }

        // for (int i = n - 2; i >= 0; i--) {
        //     for (int j1 = 0; j1 < m; j1++) {
        //         for (int j2 = 0; j2 < m; j2++) {
        //             int maxi = -(int) Math.pow(10, 9);
        //             for (int dj1 = -1; dj1 <= 1; dj1++) {
        //                 for (int dj2 = -1; dj2 <= 1; dj2++) {

        //                     int ans;
        //                     if(j1 == j2) ans = matrix[i][j1];
        //                     else ans = matrix[i][j1] + matrix[i][j2];

        //                     if(j1 + dj1 >= 0 && j1 + dj1 < m && j2 + dj2 >= 0 && j2 + dj2 < m){
        //                         ans += dp[i+1][j1+dj1][j2+dj2];
        //                     }
        //                     else ans += -(int)Math.pow(10, 9);

        //                     maxi = Math.max(maxi, ans);
        //                 }
        //             }

        //             dp[i][j1][j2] = maxi;
        //         }
        //     }
        // }

        // // at end print dp[0][0][m-1] 0 is first row, 0 is first col of first person, m-1 is last col of
        // // second person
        // System.out.println(dp[0][0][m-1]);

        // space optimization
        // for 1D array - two variable
        // for 2D array - 1D array
        // for 3D array - 2D array
        // so we 2D array instead of 3D
        // as we can see for i row it is always i+1 so we use prev and curr concept
        int[][] dp = new int[m][m];

        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2)
                    dp[j1][j2] = matrix[n - 1][j1];
                else
                    dp[j1][j2] = matrix[n - 1][j1] + matrix[n - 1][j2];
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            int[][] curr = new int[m][m];
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int maxi = -(int) Math.pow(10, 9);
                    for (int dj1 = -1; dj1 <= 1; dj1++) {
                        for (int dj2 = -1; dj2 <= 1; dj2++) {

                            int ans;
                            if(j1 == j2) ans = matrix[i][j1];
                            else ans = matrix[i][j1] + matrix[i][j2];

                            if(j1 + dj1 >= 0 && j1 + dj1 < m && j2 + dj2 >= 0 && j2 + dj2 < m){
                                ans += dp[j1+dj1][j2+dj2];
                            }
                            else ans += -(int)Math.pow(10, 9);

                            maxi = Math.max(maxi, ans);
                        }
                    }

                    curr[j1][j2] = maxi;
                }
            }
            dp = curr;
        }
        System.out.println(dp[0][m-1]);

    }

    public static int helper2(int i, int j1, int j2, int n, int m, int[][] matrix, int[][][] dp) {

        if (j1 < 0 || j2 < 0 || j1 >= m || j2 >= m)
            return -(int) Math.pow(10, 9);

        if (i == n - 1) {
            if (j1 == j2)
                return matrix[i][j1];
            else
                return matrix[i][j1] + matrix[i][j2];
        }

        if (dp[i][j1][j2] != -1)
            return dp[i][j1][j2];

        int maxi = -(int) Math.pow(10, 9);
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                if (j1 == j2)
                    maxi = Math.max(maxi, matrix[i][j1] + helper2(i + 1, j1 + dj1, j2 + dj2, n, m, matrix, dp));
                else
                    maxi = Math.max(maxi,
                            matrix[i][j1] + matrix[i][j2] + helper2(i + 1, j1 + dj1, j2 + dj2, n, m, matrix, dp));
            }
        }

        return dp[i][j1][j2] = maxi;
    }

}
