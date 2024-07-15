import java.util.Arrays;

// Three elements arr[i], arr[j] and arr[k]
//  form an inversion of size 3 
//  if a[i] > a[j] >a[k]
//   and 
//   i < j < k. 
// Find total number of inversions of size 3.

public class FT2 {

    static final int MAX_SIZE = 100005;
    static int NUM_TREES = 4; // Set the number of BITs here

    // Use a 2D array to maintain multiple BITs
    static int BIT[][] = new int[NUM_TREES + 1][MAX_SIZE];

    static void updateBIT(int treeIndex, int index, int value, int size) {
        while (index <= size) {
            BIT[treeIndex][index] += value;
            index += (index & -index);
        }
    }

    static int getSum(int treeIndex, int index) {
        int result = 0;
        while (index > 0) {
            result += BIT[treeIndex][index];
            index -= (index & -index);
        }
        return result;
    }

    static void convertAndSort(int arr[]) {
        int temp[] = Arrays.copyOf(arr, arr.length);
        Arrays.sort(temp);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Arrays.binarySearch(temp, arr[i]) + 1;
        }
    }

    static int getInvCount(int arr[], int l) {
        int n = arr.length;
        convertAndSort(arr);

        for (int i = n - 1; i >= 0; i--) {
            updateBIT(1, arr[i], 1, n);
            for (int treeIndex = 1; treeIndex < l; treeIndex++) {
                updateBIT(treeIndex + 1, arr[i], getSum(treeIndex, arr[i] - 1), n);
            }
        }

        return getSum(l, n);
    }

    public static void main(String[] args) {
        int arr[] = {1,3,2,4,5};
        int l = 4; // Set the value of l here
        int inversionCount = getInvCount(arr, l);
        System.out.print("Inversion Count: " + inversionCount);
    }
}
