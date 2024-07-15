import java.util.Scanner;

public class on {

    public static long getSubarraySum(int[] arr) {
        int n = arr.length;
        long max_diff = Long.MIN_VALUE; // Initialize max_diff to the minimum possible value
        long left_sum = 0, left_min_sum = 0, right_sum = 0, right_min_sum = 0;

        for (int i = 0; i < n; i++) {
            left_sum += arr[i];
            left_min_sum = Math.min(left_min_sum, left_sum);
            long left_diff = left_sum - left_min_sum;

            right_sum += arr[n - 1 - i];
            right_min_sum = Math.min(right_min_sum, right_sum);
            long right_diff = right_sum - right_min_sum;

            if (i < n - 1) {
                max_diff = Math.max(max_diff, left_diff - right_diff);
            }
        }

        return max_diff;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        long result = getSubarraySum(arr);
        System.out.println(result);
        math.
    }
}
