// Java program for the above approach
import java.io.*;

// class GFG{
    public class ORofAndOfAllsubarray {
        
// Time Complexity: O(N)
// Auxiliary Space: O(1)

// Function to find the Bitwise OR of
// Bitwise AND of all consecutive
// subsets of the array
static void findbitwiseOR(int[] a, int n)
{
	
	// Stores the required result
	int res = 0;

	// Traverse the given array
	for(int i = 0; i < n; i++)
		res = res | a[i];

	// Print the result
	System.out.println(res);
}

// Driver Code
public static void main(String[] args)
{
	int[] A = { 1, 2, 3 };
	int N = A.length;
	
	findbitwiseOR(A, N);
}
}

// This code is contributed by Dharanendra L V.


// Efficient Approach: The above approach can also be optimized based on the observation that the Bitwise AND of
//  any subarray is always less than or equal to the first element in the subarray. Therefore, the maximum possible value
//   is the Bitwise AND of the subarrays are the elements themselves. Therefore, the task is reduced to finding the Bitwise OR 
//   of all the array elements as the result.

// Below is the implementation of the above approach: