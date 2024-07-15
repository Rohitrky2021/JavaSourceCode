package BinarySearch;

public class SplitArrayLargestSum {
    public static void main(String args[]) {
        int[] arr = { 7, 2, 5, 10, 8 };
        int m = 2;
        int largestSum = splitArrayLargestSum(arr, m);
        System.out.println("Largest sum among " + m + " subarrays: " + largestSum);
    }

    /**
     * Returns the largest sum among m subarrays of the input array.
     * 
     * @param arr the input array of integers
     * @param m   the number of subarrays to split the input array into
     * @return the largest sum among m subarrays of the input array
     */
    static int splitArrayLargestSum(int[] arr, int m) {
        int start = 0;
        int end = 0;

        // find the maximum element and sum of the input array
        for (int i = 0; i < arr.length; i++) {
            start = Math.max(start, arr[i]);
            end += arr[i];
        }

        // binary search for the largest sum among m subarrays
        while (start < end) {
            int mid = start + (end - start) / 2;

            int sum = 0;
            int pieces = 1;

            // split the input array into m subarrays with sum <= mid
            for (int num : arr) {
                if (sum + num > mid) {
                    sum = num;
                    pieces++;
                } else {
                    sum += num;
                }
            }

            // if the number of subarrays is greater than m, increase the sum
            if (pieces > m) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return end; // the end index is the largest sum among m subarrays
    }
}