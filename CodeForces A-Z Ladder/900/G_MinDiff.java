import java.util.Arrays;
import java.util.Scanner;

public class G_MinDiff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // Number of students
        int m = scanner.nextInt(); // Number of puzzles

        int[] pieces = new int[m]; // Array to store the pieces in each puzzle

        // Read the quantities of pieces in the puzzles
        for (int i = 0; i < m; i++) {
            pieces[i] = scanner.nextInt();
        }

        // Sort the array of puzzle pieces in non-decreasing order
        Arrays.sort(pieces);

        // Initialize the minimum difference to a large value
        int minDifference = Integer.MAX_VALUE;

        // Iterate through the array of puzzle pieces
        for (int i = 0; i <= m - n; i++) {
            // Calculate the difference between the largest and smallest puzzles in the current selection
            int difference = pieces[i + n - 1] - pieces[i];
            // Update the minimum difference if the current difference is smaller
            minDifference = Math.min(minDifference, difference);
        }

        // Output the minimum difference
        System.out.println(minDifference);

        scanner.close();
    }
}
