import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases

        for (int t = 0; t < T; t++) {
            int M = scanner.nextInt(); // Valley's length
            int N = scanner.nextInt(); // Number of lamps

            boolean canReachOtherSide = false;

            for (int i = 0; i < N; i++) {
                int X = scanner.nextInt(); // Lamp's X coordinate
                int Y = scanner.nextInt(); // Lamp's Y coordinate
                int R = scanner.nextInt(); // Lamp's radius

                // Calculate the distance from lamp to the starting point (0, a)
                double distanceToStart = Math.sqrt(X * X + (M - Y) * (M - Y));

                // Check if lamp's light radius is enough to cover the entire distance to the ending point (M, b)
                if (distanceToStart <= R) {
                    canReachOtherSide = true;
                    break; // No need to check further lamps, we can safely reach the other side
                }
            }

            // Output the result for the current test case
            if (canReachOtherSide) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
