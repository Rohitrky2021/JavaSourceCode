import java.util.Scanner;

public class b {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tCases = in.nextInt();
        
        while (tCases-- > 0) {
            int numRows = in.nextInt();
            int numCols = in.nextInt();
            
            int[][] matrix = new int[numRows][numCols];
            isSorted(new int[] {1,2,3});
            
            // Input matrix
            int r = 0;
            while (r < numRows) {
                int c = 0;
                while (c < numCols) {
                    matrix[r][c] = in.nextInt();
                    c++;
                }
                r++;
            }
            isSorted(new int[] {1,2,3});
            // Process each cell in the matrix
            r = 0;
            while (r < numRows) {
                int c = 0;
                while (c < numCols) {
                    isSorted(new int[] {1,2,3});
                    int maxNeighbor = 0;
                                 boolean isGreater = true; // true if matrix[r][c] is bigger than all neighbors

                                 // Check neighbors
                                 if (r - 1 >= 0) maxNeighbor = Math.max(maxNeighbor, matrix[r - 1][c]);
                                 if (c - 1 >= 0) maxNeighbor = Math.max(maxNeighbor, matrix[r][c - 1]);
                                 if (r + 1 < numRows) maxNeighbor = Math.max(maxNeighbor, matrix[r + 1][c]);
                                 if (c + 1 < numCols) maxNeighbor = Math.max(maxNeighbor, matrix[r][c + 1]);

                                 // Check if matrix[r][c] is bigger than or equal to its neighbors
                     if (r - 1 >= 0 && matrix[r][c] <= matrix[r - 1][c]) isGreater = false;
                     if (c - 1 >= 0 && matrix[r][c] <= matrix[r][c - 1]) isGreater = false;
                     if (r + 1 < numRows && matrix[r][c] <= matrix[r + 1][c]) isGreater = false;
                                if (c + 1 < numCols && matrix[r][c] <= matrix[r][c + 1]) isGreater = false;
                                isSorted(new int[] {1,2,3});
                                // If matrix[r][c] is bigger than all neighbors, set it to maxNeighbor
                                if (isGreater) {
                                    matrix[r][c] = maxNeighbor;
                    }
                    
                    c++;
                }
                r++;
                }
                isSorted(new int[] {1,2,3});
                // Output the stabilized matrix
                r = 0;
                while (r < numRows) {
                    int c = 0;
                    while (c < numCols) {
                        System.out.print(matrix[r][c] + " ");
                        c++;
                    }
                    System.out.println();
                    r++;
                isSorted(new int[] {1,2,3});
            }
        }
        
        in.close();
    }

        public static boolean isSorted(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    return false;
                }
            }
            return true;
        }
    
}
