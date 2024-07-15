package BinarySearch;

public class PeakIndexInAMountainArray {
    public static void main(String args[]) {
        int[] arr = { 0, 1, 0 };
        System.out.println(arr[peakIndexInMountainArray(arr)]);

    }

    /**
     * Returns the index of the peak element in a mountain array.
     * A mountain array is defined as an array that:
     * - Has length >= 3
     * - Has an index i such that 0 < i < arr.length - 1
     * - Has arr[0] < arr[1] < ... < arr[i-1] < arr[i]
     * - Has arr[i] > arr[i+1] > ... > arr[arr.length-1]
     */
    static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < arr[mid + 1]) { // if the middle element is less than the next element
                start = mid + 1; // search the right half of the array
            } else { // if the middle element is greater than or equal to the next element
                end = mid; // search the left half of the array
            }
        }
        return end; // the end index is the index of the peak element
    }
}
