package BinarySearch;

public class SearchInRotatedSortedArray {
    public static void main(String args[]) {
        int[] arr = { 3, 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(searchInRotatedSortedArray(arr, 3));
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

    static int searchInRotatedSortedArray(int[] arr, int target) {
        int pivot = findPivot(arr);
        if (target == arr[0]) {
            return 0;
        } else if (target > arr[0]) {
            return binarySearch(arr, target, 0, pivot);
        } else {
            return binarySearch(arr, target, (pivot + 1), (arr.length - 1));
        }
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
