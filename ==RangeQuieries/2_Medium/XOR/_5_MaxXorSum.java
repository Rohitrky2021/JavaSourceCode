import java.util.*;
// You are given a sequence of N integers and Q queries. In each query, you are given two parameters L and R.
//  You have to find the smallest integer X such that 0 <= X < 2^31 and the sum of XOR of x with all elements
//   in range [L, R] is maximum possible.
// Examples : 
// Input  : A = {20, 11, 18, 2, 13}
//          Three queries as (L, R) pairs
//          1 3
//          3 5
//          2 4

// USING PREFIX SUM ---using “prefixSum[j] – prefixSum[i]”.
// Number (n)	1	0	0	1	0	0	1
// All 1s (N)	1	1	1	1	1	1	1
// N-n	0	1	1	0	1	1	0

    // Time complexity: O(n)
    // Auxiliary Space: O(n)   
    // Java program to find smallest integer X
    // such that sum of its XOR with range is
    // maximum.
    
    // class GFG
    public class MaxXorSum {
// {

// MAX is (1 << 31) -1 or in other terms 2^31 - 1
static int MAX = 2147483647;
static int[] prefixSum;

// Function to make prefix Sum array which
static void make_prefix(int A[], int n)
{
	prefixSum[0] = A[0];
	for (int i = 1; i < n; i++)
	prefixSum[i] = prefixSum[i - 1] + A[i];
}

// Function to find X
static int Solve(int A[], int L, int R)
{

	int n = prefixSum[R] - prefixSum[L] + A[L];
	return MAX - n;
}

// Driver program
public static void main(String[] args)
{
	prefixSum = new int[100001];
	
	// Taking inputs
	int n = 5, q = 3;
	int A[] = { 210, 11, 48, 22, 133 };
	int L[] = { 1, 4, 2 }, R[] = { 3, 4, 4 };

	make_prefix(A, n);

	for (int j = 0; j < q; j++)
	System.out.println(Solve(A, L[j], R[j]));
}
}

// This code is contributed by karandeep1234


