package T06_DividAndConquer;

public class MergeSort {

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void mergeSort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }

        int mid = si + (ei - si) / 2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);
        mergeArr(arr, si, mid, ei);
    }

    public static void mergeArr(int arr[], int si, int mid, int ei) {

        int temp[] = new int[ei - si + 1];
        int i = si;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        for (i = si, k = 0; k < temp.length; i++, k++) {
            arr[i] = temp[k];
        }

    }

    public static void main(String[] args) {
        int arr[] = { 1, 4, 2, 5, 3, 6, 9 };
        mergeSort(arr, 0, arr.length - 1);
        printArr(arr);
    }
}
