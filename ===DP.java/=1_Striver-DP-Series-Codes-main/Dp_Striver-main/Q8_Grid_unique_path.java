import java.util.Scanner;
// in this question we have given a m*n grid we are at top left and we've to reach bottom right
// we can mode in two directions either right or down
// we have to find total no of unique paths to reach the destination
// so we start from bottom so we can move either left or up
public class Q8_Grid_unique_path {
    public static int helper(int i, int j){
        if(i == 0 && j == 0) return 1;
        if(i < 0 || j < 0) return 0;
        int up = helper(i-1, j);
        int left = helper(i, j - 1);
        return up + left;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();
        scn.close();
        // recursion
        // pass m-1 and n-1 in ith and jth index and start travelling for destination which is (0,0)
        // if i and j is at 0 then return 1 that means we got one path
        // if any one going outside the boundary then return 0 that means no paths
        // now call for up, in up row will decrease by 1
        // call for left, in left col will decrease by 1
        // at end return addition of both bcoz we can get path in up also and in left also
        // System.out.println(helper(m-1, n-1));

        // memoization
        // int[][] dp = new int[m][n];
        // for(int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        // System.out.println(helper2(m-1, n-1, dp));

        // tabulation
        // int[][] dp = new int[m][n];
        // for(int i = 0; i < dp.length; i++){
        //     for(int j = 0; j < dp[i].length; j++){
        //         if(i == 0 && j == 0) dp[i][j] = 1;
        //         else{
        //             int up = 0, left = 0;
        //             if(i > 0) up = dp[i-1][j];
        //             if(j > 0) left = dp[i][j-1];
        //             dp[i][j] = up + left;
        //         }
        //     }
        // }
        // System.out.println(dp[m-1][n-1]);

        // now we can space optimized it by using 1d array
        // to calculate curr value we need just one row prev arr value
        // and same row prev col value
        // so create a dp[n] n is column size
        // craete a temp array and to calculate ith index of temp[i] = dp[i] + temp[i-1]
        // dp[i] is prev row ith col value which denotes up
        // temp[i-1] is left value which denotes same row prev col value which is basically left
        int[] dp = new int[n];
        for(int i = 0; i < m; i++){
            int[] temp = new int[n];
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0) temp[j] = 1;
                else{
                    int up = 0, left = 0;
                    if(i > 0) up = dp[j];
                    if(j > 0) left = temp[j-1];
                    temp[j] = up + left;
                }
            }
            dp = temp;
        } 
        System.out.println(dp[n-1]);

    }

    public static int helper2(int i, int j, int[][] dp){
        if(i == 0 && j == 0) return 1;
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int up = helper2(i-1, j, dp);
        int left = helper2(i, j - 1, dp);
        return dp[i][j] = up + left;
    }
}
