// Given an array of integers, calculate sum of  for all the pairs in the given where i < j. 
// Here & is bitwise AND operator. Expected time complexity is O(n). 
// Examples :
// -------------------------------------------------->
// Time Complexity: O(n)
// Auxiliary Space: O(1)
// -------------------------------------------------->
// Input:  arr[] = {5, 10, 15}
// Output: 15
// Required Value = (5 & 10) + (5 & 15) + (10 & 15) 
//                = 0 + 5 + 10 
//                = 15

// Input: arr[] = {1, 2, 3, 4}
// Output: 3
// Required Value = (1 & 2) + (1 & 3) + (1 & 4) + 
//                  (2 & 3) + (2 & 4) + (3 & 4) 
//                = 0 + 1 + 0 + 2 + 0 + 0
//                = 3
// An efficient Java program to compute
// sum of bitwise AND of all pairs
import java.io.*;

// class GFG {
    public class PairsAndsum {
	// Returns value of "arr[0] & arr[1] +
	// arr[0] & arr[2] + ... arr[i] & arr[j] +
	// ..... arr[n-2] & arr[n-1]"
	static int pairAndSum(int arr[], int n)
	{
		int ans = 0; // Initialize result

		// Traverse over all bits
		for (int i = 0; i < 32; i++) {
			// Count number of elements with i'th bit set
			// Initialize the count
			int k = 0;
			for (int j = 0; j < n; j++) {
				if ((arr[j] & (1 << i)) != 0)
					k++;
			}

			// There are k set bits, means k(k-1)/2 pairs.
			// Every pair adds 2^i to the answer. Therefore,
			// we add "2^i * [k*(k-1)/2]" to the answer.
			ans += (1 << i) * (k * (k - 1) / 2);
		}
		return ans;
	}

	// Driver program to test above function
	public static void main(String args[])
	{
		int arr[] = { 5, 10, 15 };
		int n = arr.length;
		System.out.println(pairAndSum(arr, n));
	}
}

// Auxiliary Space: O(1)

// An Efficient Solution can solve this problem in O(n) time. The assumption here is that integers are represented using 32 bits.
// The idea is to count number of set bits at every i’th position (i>=0 && i<=31).
//  Any i’th bit of the AND of two numbers is 1 if the corresponding bit in both the numbers is equal to 1. 
// Let k be the count of set bits at i’th position.
//  Total number of pairs with i’th set bit would be kC2 = k*(k-1)/2 (Count k means there are k numbers which have i’th set bit). 
//  Every such pair adds 2i to total sum. Similarly, we work for all other places and add the sum to our final answer.
// This idea is similar to this. Below is the implementation.