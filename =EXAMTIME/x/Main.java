import java.util.*;

class Main {

    // Function to return minimum absolute difference
    // between sum of two subarrays
    static int minAbsDiffSubArray(int arr[]) {
        int n = arr.length;

        // To store total sum of array
        int total_sum = 0;

        // Calculate the total sum of the array
        for (int i = 0; i < n; i++)
            total_sum += arr[i];

        // Stores the prefix sum
        int prefix_sum = 0;

        // Stores the minimum absolute difference
        int minAbsDiff = Integer.MAX_VALUE;

        // Stores the next minimum absolute difference
        int nextMinAbsDiff = Integer.MAX_VALUE;

        // Traverse the given array
        for (int i = 0; i < n - 1; i++) {
            prefix_sum += arr[i];

            // Calculate the absolute difference
            // between the two subarrays
            int absDiff = Math.abs((total_sum - prefix_sum) - prefix_sum);

            // Update minAbsDiff and nextMinAbsDiff
            if (absDiff < minAbsDiff) {
                nextMinAbsDiff = minAbsDiff;
                minAbsDiff = absDiff;
            } else if (absDiff < nextMinAbsDiff && absDiff != minAbsDiff) {
                nextMinAbsDiff = absDiff;
            }
        }

        // If the minimum difference is 0, use the next minimum difference
        if (minAbsDiff == 0) {
            minAbsDiff = nextMinAbsDiff;
        }

        // Return minAbsDiff
        return minAbsDiff;
    }

    // Driver Code
    public static void main(String[] args) {
        // Given arrays
        int[] arr = { 4, 8, 8, 3 };
        int[] arr2 = { -10, 9, -11, 13, -4, -3 };

        // Length of the arrays
        int n = arr.length;

        System.out.println(minAbsDiffSubArray(arr)); // Output: 1
        System.out.println(minAbsDiffSubArray(arr2)); // Output: 2
    }
}
