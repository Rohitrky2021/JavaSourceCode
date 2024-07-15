import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class so_rt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the size of the matrix (N x 2) from the user
        System.out.print("Enter the number of rows (N): ");
        int N = scanner.nextInt();

        // Create a 2D matrix
        int[] m1 = new int[N];
        int[] m2 = new int[N];

        for (int i = 0; i < m2.length; i++) {
            m1[i]=scanner.nextInt();
            m2[i]=scanner.nextInt();
        }

        Arrays.sort(m1);
        Arrays.sort(m2);

        // Get input for the matrix elements from the user
        System.out.println("Enter the matrix elements:");
        getInput(matrix, scanner);

        // Display the original matrix
        System.out.println("\nOriginal Matrix:");
        printMatrix(matrix);

        // Sort the first row of the matrix
        Arrays.sort(matrix, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(matrix[0]);
        Arrays.sort(matrix[1]);
        // Display the matrix after sorting the first row
        System.out.println("\nMatrix after sorting the first row:");
        printMatrix(matrix);

        scanner.close();
    }

    // Method to get input for the matrix elements from the user
    private static void getInput(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("Enter element at position (" + (i + 1) + ", " + (j + 1) + "): ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    // Method to print the matrix
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
