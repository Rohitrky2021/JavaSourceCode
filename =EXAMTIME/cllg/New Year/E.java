import java.util.Arrays;
import java.util.Scanner;

public class E {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of sides of the polygon
        int N = scanner.nextInt();

        // Read the array of reserved points for each side
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        // Sort the array to simplify the calculation
        Arrays.sort(A);

        // Calculate the maximum number of triangles
        long triangles = 0;
        for (int i = 0; i < N; i++) {
            long reservedPoints = A[i];
            long remainingSides = N - i - 1;

            // Calculate the number of triangles that can be formed with the current side
            long possibleTriangles = Math.min(reservedPoints / 2, remainingSides);

            // Update the total count of triangles
            triangles += possibleTriangles;

            // Update the reserved points for the remaining sides
            for (int j = i + 1; j < N; j++) {
                A[j] = Math.max(0, A[j] - 2);
            }
        }

        // Print the result
        System.out.println(triangles);

        // Close the scanner
        scanner.close();
    }
}
