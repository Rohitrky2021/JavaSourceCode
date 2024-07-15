// given a 2d matrix we have to count total no of square submatrix of all ones
// if element is 1 that means it is a 1*1 square submatrix so we have to count all 
// for first row and column it'll be equal to their matrix element
// from (1,1) compare three values (i-1, j), (i, j-1) and (i-1, j-1) and take min of all and add 1
// and store
// if matrix[i][j] == 0 that means no square possible using (i, j) so store 0
public class Q54_Count_square_submatrix_of_all_ones {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 0, 1 },
                { 1, 1, 0 },
                { 1, 1, 0 }
        };
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];

        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 0; i < n; i++) {
            dp[i][0] = matrix[i][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0)
                    dp[i][j] = matrix[i][j];
                else
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count += dp[i][j];
            }
        }

        System.out.println(count);
    }
}
