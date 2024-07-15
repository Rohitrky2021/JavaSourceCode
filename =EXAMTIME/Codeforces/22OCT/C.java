import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt(); // Number of segments
            int m = scanner.nextInt(); // Length of the array
            int[] diff = new int[m + 2]; // Array to track differences

            // Read segment data and update differences array
            for (int j = 0; j < n; j++) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                diff[l]++;
                diff[r + 1]--;
            }

            int maxCost = computeMaxCost(m, diff);
            System.out.println(maxCost);
        }
    }

    // Function to compute the maximum cost among all subsets of segments
    public static int computeMaxCost(int m, int[] diff) {
        int maxA = 0;
        int minA = 0;
        int currentA = 0;

        for (int i = 1; i <= m; i++) {
            currentA += diff[i];
            maxA = Math.max(maxA, currentA);
            minA = Math.min(minA, currentA);
        }

        return maxA - minA;
    }
}
