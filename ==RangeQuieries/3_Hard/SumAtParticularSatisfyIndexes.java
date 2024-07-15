import java.util.*;
// Queries to calculate sum of array elements present at every Yth index starting from the index X
// 3 Methods Possible 
    // Input: arr[] = { 1, 2, 7, 5, 4 }, Q[][] = { { 2, 1 }, { 3, 2 } } 
    // Output: 16 5 
    // Explanation: 
    // Query1: arr[2] + arr[2 + 1] + arr[2 + 2] = 7 + 5 + 4 = 16. 
    // Query2: arr[3] = 5.
    // ----->M1 NORMAL scanning in the range -->https://www.geeksforgeeks.org/queries-to-calculate-sum-of-array-elements-present-at-every-yth-index-starting-from-the-index-x/
    // Time Complexity: O(|Q| * O(N)) 
    // Auxiliary Space: O(1)
    
    // -------------->>>M2-using DP + Square Root Decomposition technique & M3 will be its spce optimisation 
    // if i + j < N
// dp[i][j] = dp[i + j][j] + arr[i]
// Otherwise, 
// dp[i][j] = arr[i]

// dp[i][j]: Stores the sum of the given expression where X = i, Y = j
// Java program for the above approach

// Time complexity: O(N * sqrt(N) + |Q| * sqrt(N)) 
// Auxiliary Space:O(N * sqrt(N))------->M3 -->O(N)
    public class SumAtParticularSatisfyIndexes {
	
static int sz = 20;
static int sqr = (int)(Math.sqrt(sz)) + 1;

// Function to sum of arr[x]+arr[x+y]+arr[x+2*y] + ...
// for all possible values of X and Y, where Y is
// less than or equal to Math.sqrt(N).
static void precomputeExpressionForAllVal(int arr[],
										int N,
										int dp[][])
{
	
	// Iterate over all possible values of X
	for(int i = N - 1; i >= 0; i--)
	{
		
		// Precompute for all possible values
		// of an expression such that y <= Math.sqrt(N)
		for(int j = 1; j <= Math.sqrt(N); j++)
		{
			
			// If i + j less than N
			if (i + j < N)
			{
				
				// Update dp[i][j]
				dp[i][j] = arr[i] + dp[i + j][j];
			}
			else
			{
				
				// Update dp[i][j]
				dp[i][j] = arr[i];
			}
		}
	}
}

// Function to Find the sum of
// arr[x]+arr[x+y]+arr[x+2*y] + ...
// for all queries
static void querySum(int arr[], int N,
					int Q[][], int M)
{
	
	// dp[x][y]: Stores sum of
	// arr[x]+arr[x+y]+arr[x+2*y] + ...
	int [][]dp = new int[sz][sqr];

	precomputeExpressionForAllVal(arr, N, dp);
	
	// Traverse the query array, Q[][]
	for(int i = 0; i < M; i++)
	{
		int x = Q[i][0];
		int y = Q[i][1];

		// If y is less than or equal
		// to Math.sqrt(N)
		if (y <= Math.sqrt(N))
		{
			System.out.print(dp[x][y] + " ");
			continue;
		}
		
		// Stores the sum of
		// arr[x]+arr[x+y]+arr[x+2*y] + ...
		int sum = 0;

		// Traverse the array, arr[]
		while (x < N)
		{
			
			// Update sum
			sum += arr[x];

			// Update x
			x += y;
		}
		System.out.print(sum + " ");
	}
}

// Driver Code
public static void main(String[] args)
{
	int arr[] = { 1, 2, 7, 5, 4 };
	int Q[][] = { { 2, 1 }, { 3, 2 } };

	int N = arr.length;
	int M = Q.length;

	querySum(arr, N, Q, M);
}
}

// This code is contributed by shikhasingrajput


