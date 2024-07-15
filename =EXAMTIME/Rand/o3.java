import java.util.*;

public class o3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input values
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int P = scanner.nextInt();

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }

        // Calculate the count of distinct subarrays
        int count = 0;
        int divisibleCount = 0;
        int left = 0;

        for (int right = 0; right < N; right++) {
            if (nums[right] % P == 0) {
                divisibleCount++;
            }

            // If the number of divisible elements exceeds K, move the left pointer to the right
            while (divisibleCount > K) {
                if (nums[left] % P == 0) {
                    divisibleCount--;
                }
                left++;
            }

            // Update the count with the number of valid subarrays ending at 'right'
            count += (right - left + 1);
        }

        System.out.println(count);

        scanner.close();
    }
}
