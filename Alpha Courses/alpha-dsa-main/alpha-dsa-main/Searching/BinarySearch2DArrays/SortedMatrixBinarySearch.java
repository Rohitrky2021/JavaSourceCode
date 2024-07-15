package BinarySearch2DArrays;

import java.util.Arrays;

public class SortedMatrixBinarySearch {
    public static void main(String args[]) {
        int[][] matrix = {
                { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 60 }
        };
        int target = 15;
        int[] result = sortedMatrixBinarySearch(matrix, target);
        if (result[0] == -1 && result[1] == -1) {
            System.out.println("Target " + target + " not found in matrix.");
        } else {
            System.out.println("Target " + target + " found at row " + result[0] + " and column " + result[1] + ".");
        }
        System.out.println(Arrays.toString(result));
    }

    /**
     * Searches for a target value in a sorted 2D matrix using binary search.
     * The matrix is sorted in non-decreasing order from left to right and top to
     * bottom.
     * 
     * @param matrix the input 2D matrix of integers
     * @param target the target value to search for in the matrix
     * @return an array containing the row and column indices of the target value in
     *         the matrix, or [-1, -1] if not found
     */
    static int[] sortedMatrixBinarySearch(int[][] matrix, int target) {
        // if the matrix is empty, return [-1, -1]
        if (matrix.length == 0) {
            return new int[] { -1, -1 };
        }

        // get the number of rows and columns in the matrix
        int rows = matrix.length;
        int cols = matrix[0].length;

        // set the start and end indices for binary search
        int start = 0;
        int end = (rows * cols) - 1;

        // perform binary search on the matrix
        while (start <= end) {
            // calculate the middle index
            int mid = start + (end - start) / 2;

            // calculate the row and column indices of the middle element
            int row = mid / cols;
            int col = mid % cols;

            // if the middle element is the target, return its indices
            if (target == matrix[row][col]) {
                return new int[] { row, col };
            }
            // if the target is less than the middle element, search the left half of the
            // matrix
            else if (target < matrix[row][col]) {
                end = mid - 1;
            }
            // if the target is greater than the middle element, search the right half of
            // the matrix
            else {
                start = mid + 1;
            }
        }

        // if the target is not found, return [-1, -1]
        return new int[] { -1, -1 };
    }
}