package T06_DividAndConquer;

public class QuickSort {
    public static void main(String[] args) {
        int arr[] = { 1, 5, 4, 2, 3, 4, 2, 2, 4, 5, 3 };
        sort(arr, 0, arr.length - 1);
        MergeSort.printArr(arr);
    }

    public static void sort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }

        int pivot = partition(arr, si, ei);
        sort(arr, si, pivot - 1);
        sort(arr, pivot + 1, ei);

    }

    public static int partition(int arr[], int si, int ei) {
        // int pivot = arr[ei];
        int i = si - 1;

        for (int j = si; j < ei; j++) {
            if (arr[j] <= arr[ei]) {
                i++;
                if (i != j) {
                    arr[i] ^= arr[j]; //swap
                    arr[j] ^= arr[i];
                    arr[i] ^= arr[j];
                }
            }
        }
        i++;
        if (ei != i) {
            arr[ei] ^= arr[i]; //swap
            arr[i] ^= arr[ei];
            arr[ei] ^= arr[i];

        }
        return i;
    }
}
