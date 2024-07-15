// https://www.geeksforgeeks.org/partition-the-array-in-k-segments-such-that-bitwise-and-of-individual-segment-sum-is-maximized/?ref=ml_lbp

// Java program to find maximum possible AND
// Performance Analysis:

// Time Complexity: O(20*n2k) in the worst case.

// Space Complexity: O(n*k) in worst case.

public class PartisionToMaxSum {//DP also USED 

	
	// Function to check whether a k segment partition
	// is possible such that bitwise AND is 'mask'
	static boolean checkpossible(int mask, int arr[],
								int prefix[], int n, int k)
	{
		int i,j;
		
		// dp[i][j] stores whether it is possible to partition
		// first i elements into j segments such that all j
		// segments are 'good'
		boolean dp[][] = new boolean[n + 1][k + 1];
	
		// Initialising dp
		for(i = 0; i < n + 1; i++)
		{
			for(j = 0; j < k + 1; j++)
			{
				dp[i][j] = false ;
			}
		}
		
		dp[0][0] = true;
	
		// Filling dp in bottom-up manner
		for ( i = 1; i <= n; i++)
		{
			for (j = 1; j <= k; j++)
			{
				// Finding a cut such that first l elements
				// can be partitioned into j-1 'good' segments
				// and arr[l+1]+...+arr[i] is a 'good' segment
				for (int l = i - 1; l >= 0; --l)
				{
					if (dp[l][j - 1] && (((prefix[i] - prefix[l])
							& mask) == mask))
					{
						dp[i][j] = true;
						break;
					}
				}
			}
		}
	
		return dp[n][k];
	}
	
	// Function to find maximum possible AND
	static int Partition(int arr[], int n, int k)
	{
		// Array to store prefix sums
		int prefix[] = new int[n+1];
	
		for (int i = 1; i <= n; i++)
		{
			prefix[i] = prefix[i - 1] + arr[i];
		}
	
		// Maximum no of bits in the possible answer
		int LOGS = 20;
	
		// This will store the final answer
		int ans = 0;
	
		// Constructing answer greedily selecting
		// from the higher most bit
		for (int i = LOGS; i >= 0; --i)
		{
			// Checking if array can be partitioned
			// such that the bitwise AND is ans|(1<<i)
			if (checkpossible(ans | (1 << i), arr, prefix, n, k))
			{
				// if possible, update the answer
				ans = ans | (1 << i);
			}
		}
	
		// Return the final answer
		return ans;
	}

	// Driver code
	public static void main (String[] args)
	{
		
		int arr[] = {0, 1, 2, 7, 10, 23, 21, 6, 8, 7, 3}, k = 2;
	
		// n = 11 , first element is zero
		// to make array 1 based indexing. So, number of
		// elements are 10
		int n = arr.length - 1 ;
		
		// Function call
		System.out.println(Partition(arr, n, k));
	}
}

// This code is contributed by AnkitRai01

// Approach: 
// First, try to answer a simpler question: given an integer x and determine if it is possible to partition the given array into K segments such that the bitwise AND of sum of segments has all set bits of x? 
// Let’s denote the sum of elements in the ith segment by S\textsubscript{i}     . Also, let’s call a segment good if S\textsubscript{i}     has all set bits of x. It’s clear now that for a good segment i, AND(S\textsubscript{i}     , x)=x. 
// Also, all K segments should be good for getting bitwise AND of x. Now to check whether we can partition the array into k good segments. We can use dynamic programming here. 
// Let dp[i][j]= true, denote that it is possible to partition first i elements into j segments such that all j are good segments otherwise false. 
// The recurrence for above dp is: 
 

// dp[i][j] is 1, if for some index k<i, AND(sum of a[k+1]…a[i], x)=x and dp[k][j-1]=1. Otherwise, dp[i][j] is 0

// Build the dp table starting from the most significant bit of the possible answer greedily.
// Below is the implementation of the above approach: 