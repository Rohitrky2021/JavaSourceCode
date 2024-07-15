import java.util.Scanner;
// import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    // identify prime or not
    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);

        int[] arr = { 1, 2, 4, 5 };
        // swap(arr, 0, 2);
        // System.out.println(Arrays.toString(arr));
        // max(arr);

        reverseArr(arr);
        System.out.println(Arrays.toString(arr));
        in.close();
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void max(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println(max);
    }

    static void reverseArr(int[] arr) {
        int start= 0;
        int end = (arr.length - 1);

        while (start <= (arr.length/2)) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

}
