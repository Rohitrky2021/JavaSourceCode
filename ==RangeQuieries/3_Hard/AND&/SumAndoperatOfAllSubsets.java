// https://www.geeksforgeeks.org/sum-bitwise-possible-subsets-given-set/?ref=ml_lbp

// Java program to calculate sum of Bit-wise
// and sum of all subsets of an array
// Complexity Analysis:
// Time Complexity: O(N)
// Auxiliary Space: O(1)


public class SumAndoperatOfAllSubsets {
	
	static final int BITS = 32;
	
	static int andSum(int arr[], int n)
	{
		int ans = 0;
	
		// assuming representation of each
		// element is in 32 bit
		for (int i = 0; i < BITS; i++) {
			int countSetBits = 0;
	
			// iterating array element
			for (int j = 0; j < n; j++) {
	
				// Counting the set bit of
				// array in ith position
				if ((arr[j] & (1 << i)) != 0)
					countSetBits++;
			}
	
			// counting subset which produce
			// sum when particular bit
			// position is set.
			int subset = (1 << countSetBits) - 1;
	
			// multiplying every position
			// subset with 2^i to count the
			// sum.
			subset = (subset * (1 << i));
	
			ans += subset;
		}
	
		return ans;
	}
	
	// Drivers code
	public static void main(String args[])
	{
		int arr[] = { 1, 2, 3};
		int size = 3;
		System.out.println (andSum(arr, size));
	
	}
}

// This code is contributed by Arnab Kundu.
// Given an array, we need to calculate the Sum of Bit-wise AND of all possible subsets of the given array.

// Examples:  

// Input : 1 2 3
// Output : 9
// For [1, 2, 3], all possible subsets are {1}, 
// {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}
// Bitwise AND of these subsets are, 1 + 2 + 
// 3 + 0 + 1 + 2 + 0 = 9.
// So, the answer would be 9.

// Input : 1 2 3 4
// Output : 13
// Refer to this Post for Count Set Bit 

// Naive Approach, we can produce all subsets using Power Set then calculate Bit-wise AND sum of all subsets.

// In a Better approach, we are trying to calculate which array element is responsible for producing the sum 
// into a subset. 

// Let’s start with the least significant bit. To remove the contribution from other bits, we calculate number
//  AND bit for all numbers in the set. Any subset of this that contains a 0 will not give any contribution
//  . All nonempty subsets that only consist of 1’s will give 1 in contribution. In total there will be 2^n – 1 such
//   subset each giving 1 in contribution. The same goes for the other bit. We get [0, 2, 2], 3 subset each giving 2.
//    Total 3*1 + 3*2 = 9 

// 2. Total 3*1 + 3*2 = 9 

// Array = {1, 2, 3}
// Binary representation
// positions       2 1 0    
//         1       0 0 1
//         2       0 1 0
//         3       0 1 1
//               [ 0 2 2 ]
// Count set bit for each position
// [ 0 3 3 ] subset produced by each 
// position 2^n -1 i.e. n is total sum 
// for each position [ 0, 3*2^1, 3*2^0 ] 
// Now calculate the sum by multiplying 
// the position value i.e 2^0, 2^1 ... . 
//  0 + 6 + 3 = 9