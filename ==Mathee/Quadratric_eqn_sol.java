// public class Quadratric_eqn_sol {
    
// }
import java.util.Scanner;

public class B {
    public static int incrementalJumps(int n, int k) {
        int T = k; // Example value of T. You can change this to the desired value.
        
        for (int i = 1; i <= T; i++) {
            int a = 1;
            int b = 1;
            int c = -2 * (T - i);

            // Calculate the discriminant
            int discriminant = b * b - 4 * a * c;

            // Check if the discriminant is non-negative and a perfect square
            if (discriminant >= 0 && isPerfectSquare(discriminant)) {
                int sqrtDiscriminant = (int) Math.sqrt(discriminant);
                int k1 = (-b + sqrtDiscriminant) / (2 * a);
                int k2 = (-b - sqrtDiscriminant) / (2 * a);

                // Check if either k1 or k2 is a positive integer
                if (k1 >=2 || k2 >=2 ) {
                    // System.out.println("YES");
                    return 1; // Exit the program
                }
            }
        }

        // System.out.println("NO");
        return 0;
    }
    private static boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int w = scanner.nextInt();
            int k = scanner.nextInt();
            System.out.println(incrementalJumps(w, k));
        }

        scanner.close();
    }
}

 