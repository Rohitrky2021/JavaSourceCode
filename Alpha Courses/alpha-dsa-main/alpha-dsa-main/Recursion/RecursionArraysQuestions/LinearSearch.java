package Recursion.RecursionArraysQuestions;

public class LinearSearch {
    public static void main(String args[]) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        System.out.println(linearSearchRecursion(arr, 0, 3));
        System.out.println(findIndex(arr, 0, 3));
    }

    static boolean linearSearchRecursion(int[] arr, int index, int target) {
        if (index == arr.length) {
            return false;
        }
        if (arr[index] == target) {
            return true;
        }
        return linearSearchRecursion(arr, index + 1, target);
    }

    static int findIndex(int[] arr, int index, int target) {
        if (index == arr.length) {
            return -1;
        }
        if (arr[index] == target) {
            return index;
        }
        return findIndex(arr, index + 1, target);
    }

}
