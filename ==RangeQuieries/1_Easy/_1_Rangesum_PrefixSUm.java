// use  normal prefix sum ----->>>>Here
// time complexity of every range sum query is O(1) and the overall time complexity is O(n).

// Auxiliary Space required = O(n), where n is the size of the given array.

// Java program to find sum between two indexes
// when there is no update.

import java.util.*;
import java.lang.*;

public class rangesum {
// class GFG {
	public static void preCompute(int arr[], int n,
								int pre[])
	{
		pre[0] = arr[0];
		for (int i = 1; i < n; i++)
			pre[i] = arr[i] + pre[i - 1];
	}

	// Returns sum of elements in arr[i..j]
	// It is assumed that i <= j
	public static int rangeSum(int i, int j, int pre[])
	{
		if (i == 0)
			return pre[j];

		return pre[j] - pre[i - 1];
	}

	// Driver code
	public static void main(String[] args)
	{
		int arr[] = { 1, 2, 3, 4, 5 };
		int n = arr.length;

		int pre[] = new int[n];

		preCompute(arr, n, pre);
		System.out.println(rangeSum(1, 3, pre));
		System.out.println(rangeSum(2, 4, pre));
	}
}

// Code Contributed by Mohit Gupta_OMG <(0_o)>


