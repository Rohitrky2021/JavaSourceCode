/*
Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
        Input: matrix =
        [
        [0,1,1,1],
        [1,1,1,1],
        [0,1,1,1]
        ]
        Output: 15
        Explanation:
        There are 10 squares of side 1.
        There are 4 squares of side 2.
        There is  1 square of side 3.
        Total number of squares = 10 + 4 + 1 = 15.
*/
public class _56CountSquare {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };

        System.out.println("total = "+ countSquares(matrix));
    }
    public static int countSquares(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int count = 0;

        for(int i = 0; i < n; i++) if(matrix[i][0] == 1) dp[i][0] = 1;
        for(int j = 0; j < m; j++) if(matrix[0][j] == 1) dp[0][j] = 1;

        // dp[i][j] will tell you the max side of the square with bottom right corner at (i, j).
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(matrix[i][j] == 1){
                    int min = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                    dp[i][j] = min;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) count += dp[i][j];
        }

        return count;

    }
}
