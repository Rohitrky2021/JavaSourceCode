// Java Program to compute sum of ranges for
// different range queries

// Here processing every query takes O(1) time. ----------->Almost same as Spare TAble 
import java.util.*;

// Class to represent a query range
class Query {
	int L;
	int R;

	Query(int L, int R) {
		this.L = L;
		this.R = R;
	}
}

// class MO{
public class MOsum {

	// Prints sum of all query ranges. m is number of queries
	// n is size of array a[].
	static void queryResults(int a[], int n, ArrayList<Query> q, int m) {

		// Find block size
		int block = (int) Math.sqrt(n);

		// Sort all queries so that queries of same blocks
		// are arranged together.
		Collections.sort(q, new Comparator<Query>() {

			// Function used to sort all queries so that all queries
			// of the same block are arranged together and within a block,
			// queries are sorted in increasing order of R values.
			public int compare(Query x, Query y) {

				// Different blocks, sort by block.
				if (x.L / block != y.L / block)
					return (x.L < y.L ? -1 : 1);

				// Same block, sort by R value
				return (x.R < y.R ? -1 : 1);
			}
		});

		// Initialize current L, current R and current sum
		int currL = 0, currR = 0;
		int currSum = 0;

		// Traverse through all queries
		for (int i = 0; i < m; i++) {
			// L and R values of current range
			int L = q.get(i).L, R = q.get(i).R;

			// Remove extra elements of previous range. For
			// example if previous range is [0, 3] and current
			// range is [2, 5], then a[0] and a[1] are subtracted
			while (currL < L) {
				currSum -= a[currL];
				currL++;
			}

			// Add Elements of current Range
			while (currL > L) {
				currSum += a[currL - 1];
				currL--;
			}
			while (currR <= R) {
				currSum += a[currR];
				currR++;
			}

			// Remove elements of previous range. For example
			// when previous range is [0, 10] and current range
			// is [3, 8], then a[9] and a[10] are subtracted
			while (currR > R + 1) {
				currSum -= a[currR - 1];
				currR--;
			}

			// Print sum of current range
			System.out.println("Sum of [" + L +
					", " + R + "] is " + currSum);
		}
	}

	// Driver program
	public static void main(String argv[]) {
		ArrayList<Query> q = new ArrayList<Query>();
		q.add(new Query(0, 4));
		q.add(new Query(1, 3));
		q.add(new Query(2, 4));

		int a[] = { 1, 1, 2, 1, 3, 4, 5, 2, 8 };
		queryResults(a, a.length, q, q.size());
	}
}
// This code is contributed by Ajay

// This code is contributed by vt_m.
// Let us consider the following problem to understand MO’s Algorithm.
// We are given an array and a set of query ranges, we are required to find the
// sum of every query range.

// Example:

// Input: arr[] = {1, 1, 2, 1, 3, 4, 5, 2, 8};
// query[] = [0, 4], [1, 3] [2, 4]
// Output: Sum of arr[] elements in range [0, 4] is 8
// Sum of arr[] elements in range [1, 3] is 4
// Sum of arr[] elements in range [2, 4] is 6
// A Naive Solution is to run a loop from L to R and calculate the sum of
// elements in given range for every query [L, R]

// Time Complexity Analysis:
// The function mainly runs a for loop for all sorted queries. Inside the for
// loop, there are four while queries
// that move ‘currL’ and ‘currR’.

// How much currR is moved? For each block, queries are sorted in increasing
// order of R. So, for a block, currR moves
// in increasing order.
// In worst case, before beginning of every block, currR at extreme right and
// current block moves it back the extreme left.
// This means that for every block, currR moves at most O(n). Since there are
// O(√n) blocks, total movement of currR is O(n * √n).

// How much currL is moved? Since all queries are sorted in a way that L values
// are grouped by blocks, movement is O(√n) when
// we move from one query to another quert. For m queries, total movement of
// currL is O(m * √n)
// Please note that a Simple and more Efficient solution to solve this problem
// is to compute prefix sum for all elements
// from 0 to n-1. Let the prefix sum be stored in an array preSum[] (The value
// of preSum[i] stores sum of arr[0..i]).
// Once we have built preSum[], we can traverse through all queries one by one.
// For every query [L, R], we return value
// of preSum[R] – preSum[L]. Here processing every query takes O(1) time.

// Auxiliary Space: O(1), since no extra space has been taken.

// The idea of this article is to introduce MO’s algorithm with a very simple
// example. We will soon be
// discussing more interesting problems using MO’s algorithm.