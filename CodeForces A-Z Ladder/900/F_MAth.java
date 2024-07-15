import java.util.Arrays;
import java.util.Scanner;

public class F_MAth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // Number of columns
        int[] columns = new int[n]; // Array to store the number of cubes in each column

        // Read the number of cubes in each column
        for (int i = 0; i < n; i++) {
            columns[i] = scanner.nextInt();
        }

        // Sort the array of cubes in non-decreasing order
        Arrays.sort(columns);

        // Print the sorted array
        for (int i = 0; i < n; i++) {
            System.out.print(columns[i] + " ");
        }

        scanner.close();
    }
}
