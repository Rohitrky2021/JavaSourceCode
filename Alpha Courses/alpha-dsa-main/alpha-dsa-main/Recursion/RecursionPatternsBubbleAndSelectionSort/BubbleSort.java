package Recursion.RecursionPatternsBubbleAndSelectionSort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 8, 7, 6, 5, 4, 32, 1 };
        bubbleSortRecursion(arr, arr.length - 1, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void bubbleSortRecursion(int[] arr, int r, int c) {
        if (r == 0) {
            return;
        }
        if (c < r) {
            if (arr[c] > arr[c + 1]) {
                // swap
                int temp = arr[c];
                arr[c] = arr[c + 1];
                arr[c + 1] = temp;
            }
            bubbleSortRecursion(arr, r, c + 1);
        } else {
            bubbleSortRecursion(arr, r - 1, 0);
        }
    }
}
