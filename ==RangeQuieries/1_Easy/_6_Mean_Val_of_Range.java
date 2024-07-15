// Java program to find floor value
// of mean in range l to r
import java.io.*;

public class MeanofRange {

    // To find mean of range in l to r
    static int findMean(int arr[], int l, int r) {
        // Both sum and count are
        // initialize to 0
        int sum = 0, count = 0;

        // To calculate sum and number
        // of elements in range l to r
        for (int i = l; i <= r; i++) {
            sum += arr[i];
            count++;
        }

        // Calculate floor value of mean
        int mean = (int) Math.floor(sum / count);

        // Returns mean of array
        // in range l to r
        return mean;
    }

    // Driver program to test findMean()
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        System.out.println(findMean(arr, 0, 2));
        System.out.println(findMean(arr, 1, 3));
        System.out.println(findMean(arr, 0, 4));
    }
}


// oPTIMISED coDE 
// Java program to find floor value
// of mean in range l to r
 
public class Main {
public static final int MAX = 1000005;
    static int prefixSum[] = new int[MAX];

    // To calculate prefixSum of array
    static void calculatePrefixSum(int arr[], int n)
    {
        // Calculate prefix sum of array
        prefixSum[0] = arr[0];
        for (int i = 1; i < n; i++)
            prefixSum[i] = prefixSum[i - 1] + arr[i];
    }

    // To return floor of mean
    // in range l to r
    static int findMean(int l, int r)
    {
        if (l == 0)
        return (int)Math.floor(prefixSum[r] / (r + 1));
        
        // Sum of elements in range l to
        // r is prefixSum[r] - prefixSum[l-1]
        // Number of elements in range
        // l to r is r - l + 1
        return (int)Math.floor((prefixSum[r] -
                prefixSum[l - 1]) / (r - l + 1));
    }

    // Driver program to test above functions
    public static void main(String[] args)
    {
        int arr[] = { 1, 2, 3, 4, 5 };
        int n = arr.length;
        calculatePrefixSum(arr, n);
        System.out.println(findMean(1, 2));
        System.out.println(findMean(1, 3));
        System.out.println(findMean(1, 4));
    }
}
