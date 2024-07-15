import java.util.Scanner;

//WAP to find the transpose of a matrix
public class exercise3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns of the matrix:");
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];
        int[][] transpose = new int[cols][rows];

        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) 
        {
            for (int j = 0; j < cols; j++) {
            matrix[i][j] = sc.nextInt();
             }
        }

        // Transpose of the matrix
        for (int i = 0; i < rows; i++) 
        {
            for (int j = 0; j < cols; j++)
            {
                transpose[j][i] = matrix[i][j];
            }
        }

        System.out.println("Transpose of the matrix:");
        for (int i = 0; i < cols; i++) 
        {
            for (int j = 0; j < rows; j++) 
            {
                System.out.print(transpose[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
