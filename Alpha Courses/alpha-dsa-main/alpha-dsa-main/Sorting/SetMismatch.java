package Sorting;

import java.util.Arrays;

public class SetMismatch {
    public static void main(String args[]) {
        int[] arr = { 2, 1, 4, 6, 2, 5 };
        System.out.println(Arrays.toString(findErrorNums(arr)));
    }

    static int[] findErrorNums(int[] arr) {

        int i = 0;

        while (i < arr.length) {
            if (arr[i] != i + 1) {
                int correct = arr[i] - 1;
                if (arr[correct] != arr[i]) {
                    swap(arr, i, correct);
                } else {
                    return new int[] { arr[i], (i + 1) };
                }
            } else {
                i++;
            }
        }
        return new int[] { -1, -1 };
    }

    static void swap(int[] arr, int f, int s) {
        int temp = arr[f];
        arr[f] = arr[s];
        arr[s] = temp;
    }
}
