// Java code for kth smallest element in an array

import java.util.Arrays;
import java.util.Collections;
// Time complexity: O(n * log (mx-mn)), where mn be minimum and mx be maximum.
// Auxiliary Space: O(1)

public class UsingBinarySearch {
// class GFG {
	static int count(int[] nums, int mid)
	{
		// function to calculate number of elements less
		// than equal to mid
		int cnt = 0;

		for (int i = 0; i < nums.length; i++)
			if (nums[i] <= mid)
				cnt++;

		return cnt;
	}

	static int kthSmallest(int[] nums, int k)
	{
		int low = Integer.MAX_VALUE;
		int high = Integer.MIN_VALUE;
		// calculate minimum and maximum the array.
		for (int i = 0; i < nums.length; i++) {
			low = Math.min(low, nums[i]);
			high = Math.max(high, nums[i]);
		}
		// Our answer range lies between minimum and maximum
		// element of the array on which Binary Search is
		// Applied
		while (low < high) {
			int mid = low + (high - low) / 2;
			/*if the count of number of elements in the
			array less than equal to mid is less than k
			then increase the number. Otherwise decrement
			the number and try to find a better answer.
			*/
			if (count(nums, mid) < k)
				low = mid + 1;

			else
				high = mid;
		}

		return low;
	}

	// Driver's code
	public static void main(String[] args)
	{
		int arr[] = { 1, 4, 5, 3, 19, 3 };
		int k = 3;

		// Function call
		System.out.print("Kth smallest element is "
						+ kthSmallest(arr, k));
	}
}

// The idea to solve this problem is that the Kth smallest element would be the element at the kth position 
// if the array was sorted in increasing order. Using this logic, binary search can be used to predict the
//  index of an element as if the array was sorted but without actually sorting the array. 
 

// Follow the given steps to solve the problem:

// Find low and high that is the range where our answer can lie. 
// Apply Binary Search on this range. 
// If the selected element which would be mid has less than K elements lesser to it then increase the number 
// that is low = mid + 1.
// Otherwise, Decrement the high pointer, i.e high = mid
// The Binary Search will end when only one element remains in the answer space which would be the answer.

