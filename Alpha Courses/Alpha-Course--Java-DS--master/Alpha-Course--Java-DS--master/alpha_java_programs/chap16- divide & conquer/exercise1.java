// Apply Merge sort to sort an array of strings. 
// where arr = {"sun", "earth", "mars", "mercury"}
import java.util.Arrays;
public class exercise1 {
    public static void main(String[] args) {
        String[] arr = {"sun", "earth", "mars", "mercury"};

        mergeSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(String[] arr) {
        if (arr.length <= 1) {
            return;
        }

        int mid = arr.length / 2;
        String[] left = new String[mid];
        String[] right = new String[arr.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = 0; i < arr.length - mid; i++) {
            right[i] = arr[i + mid];
        }

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    public static void merge(String[] arr, String[] left, String[] right) {
        int leftIndex = 0;
        int rightIndex = 0;
        int arrIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex].compareTo(right[rightIndex]) < 0) {
                arr[arrIndex++] = left[leftIndex++];
            } else {
                arr[arrIndex++] = right[rightIndex++];
            }
        }

        while (leftIndex < left.length) {
            arr[arrIndex++] = left[leftIndex++];
        }

        while (rightIndex < right.length) {
            arr[arrIndex++] = right[rightIndex++];
        }
    }
}
