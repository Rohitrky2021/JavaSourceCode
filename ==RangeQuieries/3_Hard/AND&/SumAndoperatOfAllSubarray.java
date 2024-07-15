
// Time Complexity: O(N*log(max(A))
// Auxiliary Space: O(1)

// Java program to find sum of bitwise AND
// of all subarrays
// class GFG
public class SumAndoperatOfAllSubarray {
// {
	
// Function to find the sum of
// bitwise AND of all subarrays
static int findAndSum(int []arr, int n)
{
	// variable to store
	// the final sum
	int sum = 0;

	// multiplier
	int mul = 1;

	for (int i = 0; i < 30; i++)
	{
		// variable to check if
		// counting is on
		boolean count_on = false;

		// variable to store the
		// length of the subarrays
		int l = 0;

		// loop to find the contiguous
		// segments
		for (int j = 0; j < n; j++)
		{
			if ((arr[j] & (1 << i)) > 0)
				if (count_on)
					l++;
				else
				{
					count_on = true;
					l++;
				}

			else if (count_on)
			{
				sum += ((mul * l * (l + 1)) / 2);
				count_on = false;
				l = 0;
			}
		}

		if (count_on)
		{
			sum += ((mul * l * (l + 1)) / 2);
			count_on = false;
			l = 0;
		}

		// updating the multiplier
		mul *= 2;
	}

	// returning the sum
	return sum;
}

// Driver Code
public static void main(String[] args)
{
	int []arr = { 4,5,7,5 };
	int n = arr.length;

	System.out.println(findAndSum(arr, n));
}
}

// This code is contributed
// by Code_Mech.

// logic----------------------------------------->
// Simple Solution: A simple solution will be to generate all the sub-arrays, and sum up the AND values of all the sub-arrays.
//  It will take linear time on average to find the AND value of a sub-array and thus, the overall time complexity will be O(n3).

// Efficient Solution: For the sake of better understanding, let’s assume that any bit of an element is represented by 
// the variable ‘i’, and the variable ‘sum’ is used to store the final sum.
// The idea here is, we will try to find the number of AND values(sub-arrays with bit-wise and(&)) with ith bit set. 
// Let us suppose, there is ‘Si‘ number of sub-arrays with ith bit set. For, ith bit, the sum can be updated as sum += (2i * S).
// We will break the task into multiple steps. At each step, we will try to find the number of AND values with ith bit set.
//  For this, we will simply iterate through the array and find the number of contiguous segments with ith bit set and their lengths.
//   For, each such segment of length ‘l’, value of sum can be updated as sum += (2i * l * (l + 1))/2.
// Since, for each bit, we are performing O(N) iterations and as there are at most log(max(A)) bits, 
// the time complexity of this approach will be O(N*log(max(A)), assuming max(A) = maximum value in the array.

// Below is the implementation of the above idea: 