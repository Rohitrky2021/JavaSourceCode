package Sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String args[]) {
        int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
        System.out.println("Input array: " + Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    /**
     * Sorts an input array of integers using insertion sort.
     * 
     * @param arr the input array to sort
     */
    static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) { // iterate over the array
            for (int j = i + 1; j > 0; j--) { // iterate over the sorted part of the array
                if (arr[j] < arr[j - 1]) { // if the current element is less than the previous element
                    swap(arr, j, j - 1); // swap the elements
                } else {
                    break; // exit the loop if the current element is greater than or equal to the previous
                           // element
                }
            }
        }
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