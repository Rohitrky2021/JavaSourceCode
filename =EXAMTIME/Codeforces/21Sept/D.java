import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = scanner.nextInt(); // Length of the paper
            int k = scanner.nextInt(); // Integer used in the operation
            String s = scanner.next(); // Input string

            int operations = 0;
            int left = 0;
            int right = 0;
            int blackCount = 0;

            while (right < n) {
                if (s.charAt(right) == 'B') {
                    blackCount++;
                }

                // If the window size exceeds k, move the left pointer
                if (right - left + 1 > k) {
                    if (s.charAt(left) == 'B') {
                        blackCount--;
                    }
                    left++;
                }

                // If blackCount becomes k, perform an operation and reset blackCount
                if (blackCount == k) {
                    operations++;
                    blackCount = 0;
                    left = right + 1; // Move left pointer to the right of the current window
                }

                right++;
            }

            // If there are still remaining black cells, count one more operation
            if (blackCount > 0) {
                operations++;
            }

            System.out.println(operations);
        }
    }
}
