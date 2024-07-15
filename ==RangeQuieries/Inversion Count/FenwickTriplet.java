
import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.lang.*;
import java.util.Collections;

// class GFG {
public class FenwickTriplet {
    // https://www.geeksforgeeks.org/count-inversions-of-size-three-in-a-give-array/

    // Java program to count inversions of size 3 using
    // Binary Indexed Tree

    // It is beneficial to declare the 2D BIT globally
    // since passing it into functions will create
    // additional overhead
    static int N = 100005;
    static int BIT[][] = new int[4][N];

    // update function. "t" denotes the t'th Binary
    // indexed tree
    static void updateBIT(int t, int i, int val, int n) {
        // Traversing the t'th BIT
        while (i <= n) {
            BIT[t][i] = BIT[t][i] + val;
            i = i + (i & (-i));
        }
    }

    // function to get the sum.
    // "t" denotes the t'th Binary indexed tree
    static int getSum(int t, int i) {
        int res = 0;

        // Traversing the t'th BIT
        while (i > 0) {
            res = res + BIT[t][i];
            i = i - (i & (-i));
        }
        return res;
    }

    // Converts an array to an array with values from 1 to n
    // and relative order of smaller and greater elements
    // remains same.
    static void convert(int arr[], int n) {
        // Create a copy of arr[] in temp and sort
        // the temp array in increasing order
        int temp[] = new int[n];
        for (int i = 0; i < n; i++)   temp[i] = arr[i];
      
        Arrays.sort(temp);

        // Traverse all array elements
        for (int i = 0; i < n; i++) {

            // lower_bound() Returns pointer to the
            // first element greater than or equal
            // to arr[i]
            arr[i] = Arrays.binarySearch(temp, arr[i]) + 1;
        }
    }

    // Returns count of inversions of size three
    static int getInvCount(int arr[], int n) {
        // Convert arr[] to an array with values from
        // 1 to n and relative order of smaller and
        // greater elements remains same.
        convert(arr, n);

        // iterating over the converted array in
        // reverse order.
        for (int i = n - 1; i >= 0; i--) {

            // update the BIT for l = 1
            updateBIT(1, arr[i], 1, n);

            // update BIT for all other BITs
            for (int l = 1; l < 3; l++) {
                updateBIT(l + 1, arr[i], getSum(l, arr[i] - 1), n);
            }
        }

        // final result
        return getSum(3, n);
    }

    // Driver program to test above function
    public static void main(String[] args) {
        int arr[] = { 8, 4, 2, 1 };
        int n = arr.length;
        System.out.print("Inversion Count : " + getInvCount(arr, n));
    }
}

// This code is contributed by Utkarsh
