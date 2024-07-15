//WAP to implement quick sort in java
public class quicksort {
    //to print the array
    public static void printArr(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }

    public static void quickSort(int arr[], int si, int ei) {
        // base case
        if(si >= ei) {
            return;
        }

        // last element
        int pidx = partition(arr, si, ei);
        // left part
        quickSort(arr, si, pidx-1);
        // right part
        quickSort(arr, pidx+1, ei);
    }

    // partiton
    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        
        // to make space for elements smaller than pivot
        int i = si-1; 

        for(int j=si; j<ei; j++) {
            if(arr[j] <= pivot) {
                i++;
                // swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        // swap
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }

    // main code
    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 8, 2, 5};
        quickSort(arr, 0, arr.length-1);
        printArr(arr);
    }
}
