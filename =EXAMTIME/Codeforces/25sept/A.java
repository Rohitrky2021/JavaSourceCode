import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = scanner.nextInt(); // Number of sets
            int[] union = new int[51]; // Array to store the union of all sets
            int maxAttainable = 0;

            for (int i = 0; i < n; i++) {
                int k = scanner.nextInt(); // Number of elements in the set
                int setMask = 0; // Bit mask to represent the current set

                for (int j = 0; j < k; j++) {
                    int element = scanner.nextInt();
                    setMask |= (1 << element); // Set the corresponding bit for the element
                }

                // Update the union set using bitwise OR
                for (int j = 1; j <= 50; j++) {
                    if ((setMask & (1 << j)) != 0) {
                        union[j] |= setMask;
                    }
                }
            }

            // Find the maximum number of elements in an attainable set
            for (int i = 1; i <= 50; i++) {
                maxAttainable = Math.max(maxAttainable, Integer.bitCount(union[i]));
            }

            System.out.println(maxAttainable);
        }
    }
}
