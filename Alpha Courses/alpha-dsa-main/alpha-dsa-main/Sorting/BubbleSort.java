package Sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String args[]) {
        int[] arr = { 1, 2, 3, 5, 4 };
        System.out.println("Input array: " + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    /**
     * Sorts an input array of integers using bubble sort.
     * 
     * @param arr the input array to sort
     */
    static void bubbleSort(int[] arr) {
        boolean swapped; // a flag to indicate whether any elements have been swapped in the current
                         // iteration
        for (int i = 0; i < arr.length; i++) { // iterate over the array
            swapped = false; // reset the swapped flag for each iteration
            for (int j = 1; j < arr.length - i; j++) { // iterate over the unsorted part of the array
                if (arr[j] < arr[j - 1]) { // if the current element is less than the previous element
                    int temp = arr[j]; // swap the elements
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapped = true; // set the swapped flag to true
                }
            }
            if (!swapped) { // if no elements were swapped in the current iteration, the array is sorted
                break; // exit the loop
            }
        }
    }
}