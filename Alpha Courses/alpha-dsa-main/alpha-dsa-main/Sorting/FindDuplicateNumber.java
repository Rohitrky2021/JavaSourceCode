package Sorting;

import java.util.Arrays;

public class FindDuplicateNumber {
    public static void main(String args[]) {
        int[] arr = { 1, 3, 4, 2, 2, 5 };
        System.out.println(findDuplicateNumber(arr));
        System.out.println(Arrays.toString(arr));

    }

    static int findDuplicateNumber(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            if (arr[i] != i + 1) {
                int correct = arr[i] - 1;
                if (arr[correct] != arr[i]) {
                    swap(arr, i, correct);
                } else {
                    return arr[i];
                }
            } else {
                i++;
            }

        }
        return -1;
    }

    static void swap(int[] arr, int f, int s) {
        int temp = arr[f];
        arr[f] = arr[s];
        arr[s] = temp;
    }
}
