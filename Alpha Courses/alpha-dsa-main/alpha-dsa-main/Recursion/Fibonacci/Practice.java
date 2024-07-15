package Recursion.Fibonacci;

public class Practice {
    public static void main(String args[]) {
        // System.out.println(printNum(0));
        // printNum(0);
        // System.out.println(fibonacciNumber(7));
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        System.out.println(binarySearchRecursive(arr, 0, 0, arr.length - 1));
    }

    static void printNum(int n) {
        System.out.println(n);
        if (n == 5) {
            return;
        }
        printNum(n + 1);
    }

    static int fibonacciNumber(int n) {
        if (n < 2) {
            return n;
        }
        return fibonacciNumber(n - 1) + fibonacciNumber(n - 2);
    }

    static int binarySearchRecursive(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + ((end - start) / 2);
        if (arr[mid] == target) {
            return mid;
        }
        if (target < arr[mid]) {
            return binarySearchRecursive(arr, target, start, mid - 1);
        }
        return binarySearchRecursive(arr, target, mid + 1, end);
    }
}