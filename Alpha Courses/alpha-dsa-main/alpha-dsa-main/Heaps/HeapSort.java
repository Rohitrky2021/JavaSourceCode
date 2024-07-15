package Heaps;

public class HeapSort {

    public static void heapify(int[] arr, int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIndex = i;

        if (left < size && arr[maxIndex] < arr[left]) {
            maxIndex = left;
        }

        if (right < size && arr[maxIndex] < arr[right]) {
            maxIndex = right;
        }

        if (maxIndex != i) {
            // swap
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;

            heapify(arr, maxIndex, size);
        }
    }

    public static void heapsort(int[] arr) {
        // step 1 - build maxHeap
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }

        // step 2 - push largest at end
        for (int i = n - 1; i > 0; i--) {
            // swap first with last
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }
    }

    public static void main(String args[]) {
        int[] arr = { 1, 2, 4, 5, 3 };

        heapsort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
