package BinarySearch;

public class ArrayRotationCount {
    // count how many times an array has been rotated about the pivot
    public static void main(String args[]) {
        int[] arr = { 4, 5, 6, 7, 0, 1 };
        System.out.println(countArrayRotation(arr));
    }

    static int countArrayRotation(int[] arr) {
        return findPivot(arr) + 1;
    }

    static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[start] < arr[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
