
// https://www.geeksforgeeks.org/java-program-for-products-of-ranges-in-an-array/

// --->with a modulo value if at any step hav to take %p then next steps
//     Given an array A[] of size N. Solve Q queries.
//  Find the product in the range [L, R] under modulo P ( P is Prime). 

// Examples:  

// Input : A[] = {1, 2, 3, 4, 5, 6} 
//           L = 2, R = 5, P = 229
// Output : 120

// Input : A[] = {1, 2, 3, 4, 5, 6},
//          L = 2, R = 5, P = 113
// Output : 7 

// M1-->brute 
// Product in range Queries in O(N)

import java.io.*;
import java.util.Arrays;

/**
 * The ProductOfRange class calculates the product of elements in a given range of an array.
 */
public class ProductOfRange {

	/**
	 * Calculates the product of elements in the given range of the array.
	 *
	 * @param A The input array.
	 * @param L The left index of the range (inclusive).
	 * @param R The right index of the range (inclusive).
	 * @param P The modulus value.
	 * @return The product of elements in the given range modulo P.
	 */
	static int calculateProduct(int[] A, int L, int R, int P) {

		// As our array is 0 based and L and R are given as 1 based index.
		L = L - 1;
		R = R - 1;

		int ans = 1;
		for (int i = L; i <= R; i++) {
			ans = ans * A[i];
			ans = ans % P;
		}

		return ans;
	}

	// Driver code
	static public void main(String[] args) {
		int[] A = { 1, 2, 3, 4, 5, 6 };
		int P = 229;
		int L = 2, R = 5;
		System.out.println(
				calculateProduct(A, L, R, P));

		L = 1;
		R = 3;
		System.out.println(
				calculateProduct(A, L, R, P));
	}
}

// This code is contributed by vt_m.

}

// ================>>>>>>> M2 --> using Modular Multiplicative Inverse: Now each
// query can be answered in O(1).

// Java program to find Product
// in range Queries in O(1)
class GFG {

	static int MAX = 100;
	int pre_product[] = new int[MAX];
int inverse_product[] = new int[MAX];

	// Returns modulo inverse of a
	// with respect to m using extended
	// Euclid Algorithm Assumption: a
	// and m are coprimes,
	// i.e., gcd(a, m) = 1
int modInverse(int a, int m)
{
	int m0 = m, t, q;
	int x0 = 0, x1 = 1;

	if (m == 1)
		return 0;

	while (a > 1)
	{

		// q is quotient
		q = a / m;

		class GFG {
			// Function to calculate gcd
			int gcd(int a, int b) {
				if (b == 0)
					return a;
				return gcd(b, a % b);
			}

			// Function to calculate modular
			// inverse of a under modulo m
			int modInverse(int a, int m) {
				int m0 = m;
				int y = 0, x = 1;

				if (m == 1)
					return 0;

				while (a > 1) {
					// q is quotient
					int q = a / m;

					int t = m;

					// m is remainder now,
					// process same as
					// Euclid's algo
					m = a % m;
					a = t;

					t = x;

					x = y - q * x;

					y = t;
				}

				// Make x1 positive
				if (y < 0)
					y += m0;

				return y;
			}

			// calculating pre_product array
			void calculate_Pre_Product(int A[], int N, int P) {
				int[] pre_product = new int[N];
				pre_product[0] = A[0];

				for (int i = 1; i < N; i++) {
					pre_product[i] = pre_product[i - 1] * A[i];
					pre_product[i] = pre_product[i] % P;
				}
			}

			// Calculating inverse_product array.
			void calculate_inverse_product(int A[], int N, int P) {
				int[] inverse_product = new int[N];
				inverse_product[0] = modInverse(pre_product[0], P);

				for (int i = 1; i < N; i++)
					inverse_product[i] = modInverse(pre_product[i], P);
			}

			// Function to calculate Product
			// in the given range.
			int calculateProduct(int A[], int L, int R, int P) {
				// As our array is 0 based as and
				// L and R are given as 1 based index.
				L = L - 1;
				R = R - 1;
				int ans;

				if (L == 0)
					ans = pre_product[R];
				else
					ans = pre_product[R] * inverse_product[L - 1];

				return ans;
			}

			// Driver code
			public static void main(String[] s) {
				GFG d = new GFG();

				// Array
				int A[] = { 1, 2, 3, 4, 5, 6 };

				// Prime P
				int P = 113;

				// Calculating PreProduct and
				// InverseProduct
				d.calculate_Pre_Product(A, A.length, P);
				d.calculate_inverse_product(A, A.length, P);

				// Range [L, R] in 1 base index
				int L = 2, R = 5;
				System.out.println(d.calculateProduct(A, L, R, P));
				L = 1;
				R = 3;
				System.out.println(d.calculateProduct(A, L, R, P));

			}
		}

// This code is contributed by Prerna Saini
