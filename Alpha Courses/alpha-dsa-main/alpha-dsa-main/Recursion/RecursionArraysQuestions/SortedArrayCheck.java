package Recursion.RecursionArraysQuestions;

public class SortedArrayCheck {
    public static void main(String args[]) {
        int[] arr = { 1 };
        System.out.println(isSorted(arr));
    }

    static boolean isSorted(int[] arr) {
        return helper(arr, 0, arr.length - 1);
    }

    static boolean helper(int[] arr, int s, int e) {
        if (s == e) {
            return true;
        }
        if (arr[s] > arr[s + 1]) {
            return false;
        }
        return helper(arr, s + 1, e);
    }
}
