import java.util.Arrays;

 /**
     * Approach 1: Greedy Way (Modifying Input)
     * ? Complexity
     ** Time complexity: O(n * m)
     ** Space complexity: O(1)
 */
class Solution {
    public int matrixScore(int[][] grid) {
        // Flip rows if necessary
        for (int[] row : grid) {
            if (row[0] == 0) {
                flipRow(row);
            }
        }
        // Flip columns if necessary
        flipColumns(grid);
        // Print the matrix (for debugging)
        printMatrix(grid);
        // Convert to decimal and return sum
        return convertToDecimal(grid);
    }
    private void flipRow(int[] row) {
        for (int i = 0; i < row.length; i++) {
            row[i] = 1 - row[i];
        }
    }
    private void flipColumns(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for (int j = 1; j < cols; j++) {
            int ones = 0;
            int zeros = 0;

            // Count the number of ones and zeros in the current column
            for (int[] row : grid) {
                if (row[j] == 0) {
                    zeros++;
                } else if (row[j] == 1) {
                    ones++;
                }
            }

            // If there are more zeros than ones, flip the bits of the column
            if (zeros > ones) {
                for (int i = 0; i < rows; i++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }
    }
    private int convertToDecimal(int[][] grid) {
        int sum = 0;

        for (int[] row : grid) {
            sum += binaryToDecimal(row);
        }

        return sum;
    }
    private int binaryToDecimal(int[] binaryRow) {
        return Integer.parseInt(Arrays.toString(binaryRow)
                                      .replaceAll("[^0-1]", ""), 2);
    }
    private void printMatrix(int[][] grid) {
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }
}

 /**
     * Approach 2: Greedy Way (Without Modifying Input)
     * ? Complexity
     ** Time complexity: O(n * m)
     ** Space complexity: O(1)
 */
class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length;  
        int n = grid[0].length;  

        // Initialize the score to be the sum of the first column
        int score = (1 << (n - 1)) * m;

         for (int j = 1; j < n; j++) {
            int countSameBits = 0;  

            // Count elements matching the first element in each row
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == grid[i][0]) {
                    countSameBits++; //  matches the first element
                }
            }

            // Ensure that countSameBits considers both 0s and 1s in the column
            countSameBits = Math.max(countSameBits, m - countSameBits);

            // Calculate the score  
            int columnScore = (1 << (n - j - 1)) * countSameBits;

          
            score += columnScore;
        }

        return score;
    }
}
