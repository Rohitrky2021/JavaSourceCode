package Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String args[]) {
        int[] arr = { 1, 2, 3, 5, 4 };
        System.out.println("Input array: " + Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    /**
     * Sorts an input array of integers using selection sort.
     * 
     * @param arr the input array to sort
     */
    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) { // iterate over the array
            int last = arr.length - i - 1; // set the last index of the unsorted part of the array
            int maxIndex = getMaxElement(arr, 0, last); // find the index of the maximum element in the unsorted part of
                                                        // the array
            swap(arr, maxIndex, last); // swap the maximum element with the last element of the unsorted part of the
                                       // array
        }
    }

    /**
     * Finds the index of the maximum element in a subarray of an input array.
     * 
     * @param arr   the input array of integers
     * @param start the start index of the subarray
     * @param end   the end index of the subarray
     * @return the index of the maximum element in the subarray
     */
    static int getMaxElement(int[] arr, int start, int end) {
        int max = start; // set the maximum element to the first element of the subarray
        for (int i = 0; i <= end; i++) { // iterate over the subarray
            if (arr[max] < arr[i]) { // if the current element is greater than the maximum element
                max = i; // set the maximum element to the current element
            }
        }
        return max; // return the index of the maximum element
    }

    /**
     * Swaps two elements in an input array.
     * 
     * @param arr    the input array of integers
     * @param first  the index of the first element to swap
     * @param second the index of the second element to swap
     */
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first]; // store the value of the first element in a temporary variable
        arr[first] = arr[second]; // set the value of the first element to the value of the second element
        arr[second] = temp; // set the value of the second element to the value of the temporary variable
    }
}