// Modify array by replacing each element with nearest power of GCD of all previous elements
// Input: arr[] = {4, 2, 8, 2}
// Output: 4 1 8 2
// Explanation: 
//  For element arr[0], the element remains the same.
// For element arr[1], the GCD of preceding elements is 4. The power of 4 which is nearest to 2 is 1.
// For element arr[2], the GCD of preceding elements is 2. The power of 2 which is nearest to 8 is 8.
// For element arr[3], the GCD of preceding elements is 2. The power of 2 which is nearest to 2 is 2.
// Hence, the modified array becomes {4, 1, 8, 2}.
// Java program for the above approach
// Time Complexity: O(N*log(M)), where M is the maximum element of the array. 
// Auxiliary Space: O(1)

// https://www.geeksforgeeks.org/modify-array-by-replacing-each-element-with-nearest-power-of-gcd-of-all-previous-elements/

import java.util.*;

/**
 * The GCDModifyArray class contains methods to modify an array such that each element is the nearest power of X with respect to Y.
 */
public class GCDModifyArray {
 
	/**
	 * Calculates the greatest common divisor (GCD) of two numbers using the Euclidean algorithm.
	 *
	 * @param x The first number.
	 * @param y The second number.
	 * @return The GCD of x and y.
	 */
	static int gcd(int x, int y) {
		if (x == 0)
			return y;
		return gcd(y % x, x);
	}

	/**
	 * Calculates the logarithm of a number with respect to a given base.
	 *
	 * @param x The number.
	 * @param b The base.
	 * @return The logarithm of x with respect to b.
	 */
	static int log1(int x, int b) {
		return (int)(Math.log(x) / Math.log(b));
	}

	/**
	 * Finds the nearest power of X with respect to Y.
	 *
	 * @param x The base number.
	 * @param y The target number.
	 * @return The nearest power of X with respect to Y.
	 */
	static int getNP(int x, int y) {

		// Base Case
		if (y == 1)
			return 1;

		// Find the value of K
		int k = (int)(log1(x, y));

		// Nearest power of GCD closest to Y
		if (Math.abs(Math.pow(y, k) - x) < Math.abs(Math.pow(y, (k + 1)) - x))
			return (int)(Math.pow(y, k));
		return (int)(Math.pow(y, (k + 1)));
	}

	/**
	 * Modifies the given array such that each array element is the nearest power of X with respect to Y.
	 *
	 * @param arr The input array.
	 * @return The modified array.
	 */
	
	static ArrayList<Integer> modifyEle(ArrayList<Integer> arr) {
		int prevGCD = arr.get(0);

		// Traverse the array
		for (int i = 1; i < arr.size(); i++) {

			// Find the current number
			int NP = getNP(arr.get(i), prevGCD);

			// Update the GCD
			prevGCD = gcd(arr.get(i), prevGCD);

			// Update the array at the current index
			arr.set(i, NP);
		}

		// Return the updated GCD array
		return arr;
	}

	/**
	 * The main method of the GCDModifyArray class.
	 *
	 * @param args The command-line arguments.
	 */
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>() ;
		arr.add(4);
		arr.add(2);
		arr.add(8);
		arr.add(2);

		// Function Call
		ArrayList<Integer> ans = new ArrayList<Integer>();
		ans = modifyEle(arr);
		System.out.print("[");
		for (int i = 0; i < ans.size(); i++)
			if (i < ans.size() - 1)
				System.out.print(ans.get(i) + ", ");
			else
				System.out.print(ans.get(i));
		System.out.print("]");
	}
}

// This code is contributed by susmitakundugoaldanga.

// For calculating the power of X which is closest to Y, the idea is to get the value of K such that 
// the absolute difference between XK and Y is minimum.
// For finding the value of K, find the floor value of logx(Y).
// Therefore, K and (K + 1) will be the two integers for which the nearest power can be a possible value.
// Follow the steps below to solve the problem:

// Initialize a variable, say prefixGCD with arr[0], to store the prefix GCD till each index of the array.
// Traverse the given array arr[] over the range of indices [1, N] and perform the following steps:
// Find the floor value of logprefixGCD(arr[i]), say K.
// Find the value of (arr[i]K) and (arr[i]K + 1) and check which is closest to arr[i] and assign that value to the current index of the array.
// Update prefixGCD as the gcd of prefixGCD and arr[i].
// After completing the above steps, print the modified array.
