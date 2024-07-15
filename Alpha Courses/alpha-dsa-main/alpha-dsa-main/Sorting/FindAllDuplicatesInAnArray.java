package Sorting;

import java.util.Arrays;
import java.util.ArrayList;

public class FindAllDuplicatesInAnArray {
    public static void main(String args[]) {
        int[] arr = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println((findAllDuplicateNumbers(arr)));
    }

    static ArrayList<Integer> findAllDuplicateNumbers(int[] arr) {
        
        ArrayList<Integer> ans = new ArrayList<Integer>();

        int i = 0;

        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[correct] != arr[i]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }

        for (int index = 0; index < arr.length; index++){
            if (arr[index] != index + 1) {
                ans.add(arr[index]);
            }
        }

        System.out.println(Arrays.toString(arr));
        return ans;
    }

    static void swap(int[] arr, int f, int s) {
        int temp = arr[f];
        arr[f] = arr[s];
        arr[s] = temp;
    }
}
