import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class cp {

    static final int MAX_SIZE = 1000005;
    static int NUM_TREES = 3; // Set the number of BITs here

    // Use a 2D array to maintain multiple BITs
    static long BIT[][] = new long[NUM_TREES + 1][MAX_SIZE];

    static void updateBIT(int treeIndex, int index, long value, int size) {
        while (index <= size) {
            BIT[treeIndex][index] += value;
            index += (index &( -index));  //==> N= N +/-  ( N & (-N))  ==> Deleting or Adding the last set bit to a number    where -N = ~N + 1; 
        }
    }

    static long getSum(int treeIndex, int index) {
        long result = 0;
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

    static long getInvCount(int arr[], int l) {
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

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Read the number of men in the Roman army
        int n = Integer.parseInt(reader.readLine().trim());

        // Read the powers of men in the Roman army
        int[] powers = Arrays.stream(reader.readLine().trim().split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();

        // Read the value of l
        int l = 3; // Set the value of l here

        // Calculate and print the weakness of the Roman army
        long inversionCount = getInvCount(powers, l);
        System.out.println(inversionCount);
    }
}
