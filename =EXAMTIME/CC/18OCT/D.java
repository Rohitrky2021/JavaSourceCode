import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt(); // Length of the array
            long[] arr = new long[n]; // Array to store elements

            for (int j = 0; j < n; j++) {
                arr[j] = scanner.nextLong();
            }

            long maxSum = getMaxSum(arr);
            System.out.println(maxSum);
        }
    }

    // Function to calculate the maximum sum
    private static long getMaxSum(long[] arr) {
        long maxSum = 0;
        long currentMax = arr[0];

        for (int i = 0; i < arr.length; i++) {
            currentMax = Math.max(arr[i], currentMax);
            maxSum += currentMax;
        }

        return maxSum;
    }
}
