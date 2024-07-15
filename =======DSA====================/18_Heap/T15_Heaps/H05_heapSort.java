package T15_Heaps;

public class H05_heapSort {

    static void sort(int arr[]) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            heapify(arr, 0, i);
        }
    }

    static void heapify(int arr[], int i, int n) {
        int maxIdx = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }

        if (right < n && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }

        if (maxIdx != i) {
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[i];
            arr[i] = temp;
            heapify(arr, maxIdx, n);
        }
    }

    static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 1, 4, 2, 5, 7, 9, 3 };
        sort(arr);
        printArr(arr);
    }
}
