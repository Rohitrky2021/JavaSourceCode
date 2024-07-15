package BinarySearch2DArrays;

import java.util.Arrays;

public class BinarySearch2D {
    public static void main(String args[]) {
        int[][] matrix = {
                { 1, 4, 7, 11, 15 },
                { 2, 5, 8, 12, 19 },
                { 3, 6, 9, 16, 22 },
                { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 }
        };
        int target = 399;
        int[] result = binarySearch2D(matrix, target);
        if (result[0] == -1 && result[1] == -1) {
            System.out.println("Target " + target + " not found in matrix.");
        } else {
            System.out.println("Target " + target + " found at row " + result[0] + " and column " + result[1] + ".");
        }
        System.out.println(Arrays.toString(binarySearch2D(matrix, target)));
    }

    /**
     * Searches for a target value in a 2D matrix using binary search.
     * The matrix is sorted in non-decreasing order from left to right and top to
     * bottom.
     * 
     * @param matrix the input 2D matrix of integers
     * @param target the target value to search for in the matrix
     * @return an array containing the row and column indices of the target value in
     *         the matrix, or [-1, -1] if not found
     */
    static int[] binarySearch2D(int[][] matrix, int target) {
        int r = 0;
        int c = matrix.length - 1;

        while (r < matrix.length && c >= 0) {
            if (matrix[r][c] == target) {
                return new int[] { r, c };
            }
            if (matrix[r][c] < target) {
                r++;
            } else {
                c--;
            }
        }
        return new int[] { -1, -1 };
    }
}