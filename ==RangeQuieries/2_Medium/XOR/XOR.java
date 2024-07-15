//     Count of subarrays in range [L, R] having XOR + 1 equal to XOR (XOR) 1 for M queries
//     Given an array, arr[] of N positive integers and M queries which consist
//      of two integers [Li, Ri] where 1 ? Li ? Ri ? N. For each query, find the number of subarrays
//      in range [Li, Ri] for which (X+1)=(X?1) where X denotes the xor of a subarray.

// Input: arr[]= {1, 2, 9, 8, 7}, queries[] = {{1, 5}, {3, 4}}
// Output: 6 1
// Explanation: 
// Query 1: L=1, R=5: subarrays [1, 3], [1, 4], [2, 2], [2, 5], [3, 5], [4, 4]
// Query 2: L=3, R=4: subarray [4, 4]
// Java program for the above approach
// ------------------------------------------------
// Time Complexity: O(N+M)
// Auxiliary Space: O(N+M)
import java.util.ArrayList;

/**
 * The XOR class provides a method to count the number of subarrays with even XOR values.
 * It takes an array of integers, an array of queries, and the size of the array and queries as input.
 * The countXorSubarr method calculates the XOR values of subarrays and counts the number of subarrays with even XOR values.
 * It returns an ArrayList containing the count of subarrays with even XOR values for each query.
 * 
 * Example usage:
 * int n = 5;
 * int[] arr = { 1, 2, 9, 8, 7 };
 * int m = 2;
 * int[][] queries = { { 1, 5 }, { 3, 4 } };
 * ArrayList<Integer> ans = countXorSubarr(arr, queries, n, m);
 * 
 * @param arr The input array of integers.
 * @param queries The array of queries, where each query is represented by an array of two integers [L, R].
 * @param n The size of the input array.
 * @param m The number of queries.
 * @return An ArrayList containing the count of subarrays with even XOR values for each query.
 */
    public class XOR {

	public static ArrayList<Integer> countXorSubarr(int[] arr, int[][] queries, int n, int m) {

		// As queries are in 1-based indexing,
		// add one dummy entry in beginning
		// of arr to make it 1-indexed
		// arr.insert(arr.begin(), 0);
		int[] temp_arr = new int[arr.length + 1];
		temp_arr[0] = 0;
		for (int i = 1; i < temp_arr.length; i++) {
			temp_arr[i] = arr[i - 1];
		}
		arr = temp_arr.clone();

		// sum[] will contain parity
		// of prefix sum till index i
		// count[] will contain
		// number of 0s in sum[]
		int[] count = new int[n + 1];
		int[] sum = new int[n + 1];
		count[0] = sum[0] = 0;

		for (int i = 1; i <= n; i++) {

			// Take the parity of current sum
			sum[i] = (sum[i - 1] + arr[i]) % 2;
			count[i] = count[i - 1];

			// If current parity is even,
			// increase the count
			if (sum[i] % 2 == 0)
				count[i]++;
		}

		// Array to hold the answer of 'm' queries
		ArrayList<Integer> ans = new ArrayList<Integer>();

		// Iterate through queries and use handshake
		// lemma to count even sum subarrays
		// ( Note that an even sum can
		// be formed by two even or two odd )
		for (int[] qu : queries) {
			int L = qu[0], R = qu[1];

			// Find count of even and
			// odd sums in range [L, R]
			int even = count[R] - count[L - 1];
			int odd = (R - L + 1) - even;

			// If prefix sum at L-1 is odd,
			// then we need to swap
			// our counts of odd and even
			if (sum[L - 1] == 1) {
				int temp = even;
				even = odd;
				odd = temp;
			}

			// Taking no element is also
			// considered an even sum
			// so even will be increased by 1
			// (This is the condition when
			// a prefix of even sum is taken)
			even++;

			// Find number of ways to
			// select two even's or two odd's
			int subCount = (even * (even - 1)) / 2 + (odd * (odd - 1)) / 2;

			ans.add(subCount);
		}

		return ans;
	}

	// Driver code
	public static void main(String args[])
	{
		int n = 5;
		int[] arr = { 1, 2, 9, 8, 7 };
		int m = 2;
		int[][] queries = { { 1, 5 }, { 3, 4 } };

		// Function call and print answer
		ArrayList<Integer> ans = countXorSubarr(arr, queries, n, m);
		for (int x : ans)
			System.out.print(x + " ");
		System.out.println("");

	}
}

// This code is contributed by saurabh_jaiswal.


