import java.util.*;
// in this question we given a triangle, in the ith row i+1 elements are their
// like for 0th we have 1 element, for 1th we have 2 elements
// we can traverse to down or diagonal means at (i+1, j) or (i+1,j+1)
// we have to reach last row, we can reach any col of last row
// so using these two stuffs we have to return minimum path to reach destination
// in prev questions we started from last row and col but here at end we have total n column
// so we have to use these n col to reach destination which is (0,0) so instead of
// calling for n coloumns we can start traversing from (0,0)
public class Q11_Triangle {

    public static int minimumPathSum(int i, int j, int[][] triangle, int n){

        if(i == n-1){
            return triangle[n-1][j];
        }

        int down = triangle[i][j] + minimumPathSum(i+1, j, triangle, n);

        int diagonal = triangle[i][j] + minimumPathSum(i+1, j+1, triangle, n);

        return Math.min(down, diagonal);

    }

    public static int minimumPathSum2(int i, int j, int[][] triangle, int[][] dp, int n){

        if(i == n-1){
            return dp[i][j] = triangle[n-1][j];
        }

        if(dp[i][j] != -1) return dp[i][j];

        int down = triangle[i][j] + minimumPathSum2(i+1, j, triangle, dp, n);

        int diagonal = triangle[i][j] + minimumPathSum2(i+1, j+1, triangle, dp, n);

        return dp[i][j] = Math.min(down, diagonal);

    }

    public static void main(String[] args) {

        int triangle[][] = { 
                { 1 },
                { 2, 3 },
                { 3, 6, 7 },
                { 8, 9, 6, 10 } };

        int n = triangle.length;

        // recusion
        // pass (0,0) and start seaching min path
        System.out.println(minimumPathSum(0, 0, triangle, n));

        // memoization
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1); // fill all with -1
        System.out.println(minimumPathSum2(0, 0, triangle, dp, n));

        // tabulation
        // since in memoization and recusion we started from 0,0 but it is bottom up only
        // in base case will filles last row with the value of last row of triangle
        // so we've to fill our dp last row with the same

        int[][] dp = new int[n][n];
        for(int j = 0; j < n; j++) dp[n-1][j] = triangle[n-1][j];

        for(int i = n-2; i >= 0; i--){
            for(int j = i; j >= 0; j--){
                int down = triangle[i][j] + dp[i+1][j];
                int diag = triangle[i][j] + dp[i+1][j+1];
                dp[i][j] = Math.min(down, diag);
            }
        }

        System.out.println(dp[0][0]);

        // space optimization
        int[] prev = new int[n];
        for(int j = 0; j < n; j++) prev[j] = triangle[n-1][j];

        for(int i = n-2; i >= 0; i--){
            int[] curr = new int[n];
            for(int j = i; j >= 0; j--){
                int down = triangle[i][j] + prev[j];
                int diag = triangle[i][j] + prev[j+1];
                curr[j] = Math.min(down, diag);
            }
            prev = curr;
        }

        System.out.println(prev[0]);
    }

    public int minimumTotal(List<List<Integer>> tri) {
        int n = tri.size();
        List<Integer> prev = new ArrayList<>();

        for(int j = 0; j < n; j++) prev.add(tri.get(n-1).get(j));

        for(int i = n-1; i >= 0; i--){

            List<Integer> curr = new ArrayList<>();

            for(int j = 0; j <= i; j++){

                int down = tri.get(i).get(j) + prev.get(j);
                int diag = tri.get(i).get(j) + prev.get(j+1);
                curr.set(j, Math.min(down, diag));

            }

            prev = curr;

        }

        return prev.get(0);
        
    }
}
