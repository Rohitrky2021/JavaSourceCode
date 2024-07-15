public class mergesort {
    public static void merged(int arr[], int lb, int mid, int ub) {
        int merged[] = new int[ub - lb+1];

        int i = lb;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= ub) {
            if (arr[i] <= arr[j]) {
                merged[k] = arr[i];
                i++;
                k++;
            } else {
                merged[k] = arr[j];
                j++;
                k++;
            }
        }
 
        // remaining elements
        /*
         * if (i > mid) {
         * while (j <= ub) {
         * merged[k] = arr[j];
         * k++;
         * j++;
         * 
         * }
         * } else {
         * while (i <= mid) {
         * merged[k] = arr[i];
         * i++;
         * k++;
         * }
         * }
         */

        while (i <= mid) {
            merged[k] = arr[i];
            k++;
            i++;
        }
        while (j <= ub) {
            merged[k] = arr[j];
            j++;
            k++;

        }

        // loop for store original array into merged array for k or new merge k
        for (k = 0, i = lb; k < merged.length; i++, k++) {
            arr[i] = merged[k];
        }
    }

    public static void mergeSort(int arr[], int lb, int ub) {
        if (lb >= ub) {
            return;
        }
        // if(lb<ub){
        int mid = lb + (ub - lb) / 2;
        mergeSort(arr, lb, mid);
        mergeSort(arr, mid + 1, ub);
        merged(arr, lb, mid, ub);
    // }
    }

    public static void main(String args[]) {
        int arr[] = { 15, 5, 24, 8, 1, 3, 16, 10, 20 };
        int n = arr.length;
        mergeSort(arr, 0, n - 1);

        // print
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();}
}
