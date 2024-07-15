import java.io.*;
import java.util.*;
// ======================>>>>>>>>>    IMP IS THIS Q IS (with updates)--YA
// m1-->normal brute force = O(Q * N)

// m2->using SEGMENT TREE + Sieve of Eratosthenes
// Sieve of Eratosthenes to preprocess all the primes till the maximum value 
// arr-i can take
//  say MAX in :--->TC == O(MAX log(log(MAX)).
//                  Auxiliary Space: O(MAX+n)
// Java program to find number of prime numbers in a
// subarray and performing updates

// class GFG
public class NumberOfPrimes {    
// {
	static int MAX = 1000 ;
	static void sieveOfEratosthenes(boolean isPrime[])
	{
		isPrime[1] = false;
		for (int p = 2; p * p <= MAX; p++)
		{

			// If prime[p] is not changed, then
			// it is a prime
			if (isPrime[p] == true)
			{

				// Update all multiples of p
				for (int i = p * 2; i <= MAX; i += p)
					isPrime[i] = false;
			}
		}
	}
	
	// A utility function to get the middle index from corner indexes.
	static int getMid(int s, int e) { return s + (e - s) / 2; }
	
	/* A recursive function to get the number of primes in a given range
	of array indexes. The following are parameters for this function.
	
	st --> Pointer to segment tree
	index --> Index of current node in the segment tree. Initially
			0 is passed as root is always at index 0
	ss & se --> Starting and ending indexes of the segment represented
				by current node, i.e., st[index]
	qs & qe --> Starting and ending indexes of query range */
	
	static int queryPrimesUtil(int[] st, int ss, int se, int qs, int qe, int index)
	{
	
		// If segment of this node is a part of given range, then return
		// the number of primes in the segment	
		if (qs <= ss && qe >= se)
		return st[index];

		// If segment of this node is outside the given range
		if (se < qs || ss > qe)
			return 0;

		// If a part of this segment overlaps with the given range
		int mid = getMid(ss, se);
		return queryPrimesUtil(st, ss, mid, qs, qe, 2 * index + 1) +
		queryPrimesUtil(st, mid + 1, se, qs, qe, 2 * index + 2);
	}
	
	/* A recursive function to update the nodes which have the given
index in their range. The following are parameters
	st, si, ss and se are same as getSumUtil()
	i --> index of the element to be updated. This index is
			in input array.
diff --> Value to be added to all nodes which have i in range */
	
static void updateValueUtil(int[] st, int ss, int se, int i, int diff, int si)
{
		// Base Case: If the input index lies outside the range of
		// this segment
		if (i < ss || i > se)
			return;

		// If the input index is in range of this node, then update
		// the value of the node and its children
		st[si] = st[si] + diff;
		if (se != ss) {
			int mid = getMid(ss, se);
			updateValueUtil(st, ss, mid, i, diff, 2 * si + 1);
			updateValueUtil(st, mid + 1, se, i, diff, 2 * si + 2);
		}
	}
	
	// The function to update a value in input array and segment tree.
	// It uses updateValueUtil() to update the value in segment tree
	
	static void updateValue(int arr[], int[] st, int n,
							int i, int new_val, boolean isPrime[])
	{
		// Check for erroneous input index
		if (i < 0 || i > n - 1) {
			System.out.println("Invalid Input");
			return;
		}
		int diff = 0;
		int oldValue;

		oldValue = arr[i];

		// Update the value in array
		arr[i] = new_val;

		// Case 1: Old and new values both are primes
		if (isPrime[oldValue] && isPrime[new_val])
			return;

		// Case 2: Old and new values both non primes
		if ((!isPrime[oldValue]) && (!isPrime[new_val]))
			return;

		// Case 3: Old value was prime, new value is non prime
		if (isPrime[oldValue] && !isPrime[new_val])
		{
			diff = -1;
		}

		// Case 4: Old value was non prime, new_val is prime
		if (!isPrime[oldValue] && isPrime[new_val])
		{
			diff = 1;
		}

		// Update the values of nodes in segment tree
		updateValueUtil(st, 0, n - 1, i, diff, 0);
	}
	
	// Return number of primes in range from index qs (query start) to
	// qe (query end). It mainly uses queryPrimesUtil()
	static void queryPrimes(int[] st, int n, int qs, int qe)
	{
		int primesInRange = queryPrimesUtil(st, 0, n - 1, qs, qe, 0);
		System.out.println("Number of Primes in subarray from " +
						qs + " to " + qe + " = " + primesInRange);
	}

	// A recursive function that constructs Segment Tree
	// for array[ss..se].
	// si is index of current node in segment tree st
	static int constructSTUtil(int arr[], int ss, int se,
							int[] st, int si, boolean isPrime[])
	{
		// If there is one element in array, check if it
		// is prime then store 1 in the segment tree else
		// store 0 and return
		if (ss == se) {

			// if arr[ss] is prime
			if (isPrime[arr[ss]])
				st[si] = 1;		
			else
				st[si] = 0;
		
			return st[si];
		}

		// If there are more than one elements, then recur
		// for left and right subtrees and store the sum
		// of the two values in this node
		int mid = getMid(ss, se);
		st[si] = constructSTUtil(arr, ss, mid, st, si * 2 + 1, isPrime) +
				constructSTUtil(arr, mid + 1, se, st, si * 2 + 2, isPrime);
		return st[si];
	}
		
	/* Function to construct segment tree from given array.
This function allocates memory for segment tree and
calls constructSTUtil() to fill the allocated memory */
static int[] constructST(int arr[], int n, boolean isPrime[])
{
	// Allocate memory for segment tree

		// Height of segment tree
		int x = (int)(Math.ceil(Math.log(n)/Math.log(2)));

		// Maximum size of segment tree
		int max_size = 2 * (int)Math.pow(2, x) - 1;
		int[] st = new int[max_size];

		// Fill the allocated memory st
		constructSTUtil(arr, 0, n - 1, st, 0, isPrime);

		// Return the constructed segment tree
		return st;
}
	
// Driver code
	public static void main (String[] args)
	{
		int arr[] = { 1, 2, 3, 5, 7, 9 };
		int n = arr.length;
	
		/* Preprocess all primes till MAX.
	Create a boolean array "isPrime[0..MAX]".
	A value in prime[i] will finally be false
	if i is Not a prime, else true. */
		boolean[] isPrime = new boolean[MAX + 1];
		Arrays.fill(isPrime, Boolean.TRUE);
		sieveOfEratosthenes(isPrime);
		
		// Build segment tree from given array
		int[] st = constructST(arr, n, isPrime);

		// Query 1: Query(start = 0, end = 4)
		int start = 0;
		int end = 4;
		queryPrimes(st, n, start, end);

		// Query 2: Update(i = 3, x = 6), i.e Update
		// a[i] to x
		int i = 3;
		int x = 6;
		updateValue(arr, st, n, i, x, isPrime);

		// uncomment to see array after update
		// for(int i = 0; i < n; i++) cout << arr[i] << " ";

		// Query 3: Query(start = 0, end = 4)
		start = 0;
		end = 4;
		queryPrimes(st, n, start, end);
	}
}

// This code is contributed by avanitrachhadiya2155


