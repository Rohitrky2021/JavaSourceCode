//     Range Query on array whose each element is XOR of index value and previous element
//    i.e ==> (A[i-1]^i)--for all in L->R
// Java Program to solve range query on array
// whose each element is XOR of index value
// and previous element.

import java.io.*;

// class GFG {
public class ModifyArrInRangeforXOR {

	// function return derived formula value.
	static int fun(int x) {
		int y = (x / 4) * 4;

		// finding xor value of range [y...x]
		int ans = 0;

		for (int i = y; i <= x; i++)
			ans ^= i;

		return ans;
	}

	// function to solve query for l and r.
	static int query(int x) {

		// if l or r is 0.
		if (x == 0)
			return 0;

		int k = (x + 1) / 2;

		// finding x is divisible by 2 or not.
		return ((x %= 2) != 0) ? 2 * fun(k) : ((fun(k - 1) * 2) ^ (k & 1));
	}

	static void allQueries(int q, int l[], int r[]) {
		for (int i = 0; i < q; i++)
			System.out.println((query(r[i]) ^query(l[i] - 1)));
	}

	// Driven Program
	public static void main(String[] args) {

		int q = 3;
		int[] l = { 2, 2, 5 };
		int[] r = { 4, 8, 9 };

		allQueries(q, l, r);

	}
}

// This code is contributed by vt_m.
