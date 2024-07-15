package T01_Arrays;

public class A03_binarySearch {

    static int binarySearch(int arr[], int k) { // only for sorted Array or list
        int s = 0;
        int e = arr.length - 1;
        while (s < e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] > k) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return -1; // not found
    }
    static int binarySearch2(int arr[], int s, int e, int k) {
        if (s > e) {
            return -1;
        }
        int mid = s + (e - s) / 2;

        if (arr[mid] == k) {
            return mid;
        } else if (arr[mid] > k) {
            return binarySearch2(arr, s, mid - 1, k);
        } else {
            return binarySearch2(arr, mid + 1, e, k);
        }
    }

}
