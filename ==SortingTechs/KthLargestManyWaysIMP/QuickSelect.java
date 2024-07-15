// Same like taking Pivot But Modified 
// Java code for kth smallest element in an array
// Time Complexity: O(N^2) in worst case and O(N) on average 
// Auxiliary Space: O(1)
import java.util.Arrays;
import java.util.Collections;

// class GFG {
public class QuickSelect {
	// Standard partition process of QuickSort.
	// It considers the last element as pivot
	// and moves all smaller element to left of
	// it and greater elements to right
	public static int partition(Integer[] arr, int l, int r)
	{
		int x = arr[r], i = l;
		for (int j = l; j <= r - 1; j++) {
			if (arr[j] <= x) {

				// Swapping arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;

				i++;
			}
		}

		// Swapping arr[i] and arr[r]
		int temp = arr[i];
		arr[i] = arr[r];
		arr[r] = temp;

		return i;
	}

	// This function returns k'th smallest element
	// in arr[l..r] using QuickSort based method.
	// ASSUMPTION: ALL ELEMENTS IN ARR[] ARE DISTINCT
	public static int kthSmallest(Integer[] arr, int l,
								int r, int K)
	{
		// If k is smaller than number of elements
		// in array
		if (K > 0 && K <= r - l + 1) {

			// Partition the array around last
			// element and get position of pivot
			// element in sorted array
			int pos = partition(arr, l, r);

			// If position is same as k
			if (pos - l == K - 1)
				return arr[pos];

			// If position is more, recur for
			// left subarray
			if (pos - l > K - 1)
				return kthSmallest(arr, l, pos - 1, K);

			// Else recur for right subarray
			return kthSmallest(arr, pos + 1, r,
							K - pos + l - 1);
		}

		// If k is more than number of elements
		// in array
		return Integer.MAX_VALUE;
	}

	// Driver's code
	public static void main(String[] args)
	{
		Integer arr[]
			= new Integer[] { 12, 3, 5, 7, 4, 19, 26 };
		int K = 3;

		// Function call
		System.out.print(
			"K'th smallest element is "
			+ kthSmallest(arr, 0, arr.length - 1, K));
	}
}

// This code is contributed by Chhavi




//     This is an optimization over method 1, if QuickSort is used as a sorting algorithm in first step.
//      In QuickSort, pick a pivot element, then move the pivot element to its correct position 
//      and partition the surrounding array. The idea is, not to do complete quicksort, but stop at the
//       point where pivot itself is k’th smallest element. Also, not to recur for both left and 
//       right sides of pivot, but recur for one of them according to the position of pivot. 

// Follow the given steps to solve the problem:

// Run quick sort algorithm on the input array
// In this algorithm pick a pivot element and move it to it’s correct position
// Now, if index of pivot is equal to K then return the value, else if the index of pivot is greater than K, then recur for the left subarray, else recur for the right subarray 
// Repeat this process until the element at index K is not found
    

