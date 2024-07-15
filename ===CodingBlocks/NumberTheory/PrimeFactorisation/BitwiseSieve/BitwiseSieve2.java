
// JAVA Code to implement Bitwise
// Sieve of Eratosthenes.
import java.util.*;

public class BitwiseSieve2 {//optimised one 

	
	// Checks whether x is prime or composite
	static int ifnotPrime(int prime[], int x)
	{
		// checking whether the value of element
		// is set or not. Using prime[x/64],
		// we find the slot in prime array.
		// To find the bit number, we divide x
		// by 2 and take its mod with 32.
		return (prime[x/64] & (1 << ((x >> 1) & 31)));
	}
	
	// Marks x composite in prime[]
	static void makeComposite(int prime[], int x)
	{
		// Set a bit corresponding to given element.
		// Using prime[x/64], we find the slot
		// in prime array. To find the bit number,
		// we divide x by 2 and take its mod with 32.
		prime[x/64] |= (1 << ((x >> 1) & 31));
	}
	
	// Prints all prime numbers smaller than n.
	static void bitWiseSieve(int n)
	{
		// Assuming that n takes 32 bits,
		// we reduce size to n/64 from n/2.
		int prime[] = new int[n/64 + 1];
	
	
		// 2 is the only even prime so we
		// can ignore that loop starts from
		// 3 as we have used in sieve of
		// Eratosthenes .
		for (int i = 3; i * i <= n; i += 2) {
	
			// If i is prime, mark all its
			// multiples as composite
			if (ifnotPrime(prime, i)==0)
				for (int j = i * i, k = i << 1;j < n; j += k)
					makeComposite(prime, j);
		}
	
		// writing 2 separately
		System.out.printf("2 ");
	
		// Printing other primes
		for (int i = 3; i <= n; i += 2)
			if (ifnotPrime(prime, i) == 0)
				System.out.printf("%d ", i);
	}
	
	/* Driver program to test above function */
	public static void main(String[] args)
	{
		int n = 30;
		bitWiseSieve(n);
	}
}


// Time Complexity: O(nlogn)

// Space Complexity: O(n)

// Further optimization using bitwise operators. 
// The above implementation uses bool data type which takes 1 byte.
//  We can optimize space to n/8 by using individual bits of an integer to represent individual primes.
//   We create an integer array of size n/64. 
//   Note that the size of the array is reduced to n/64 from n/2 (Assuming that integers take 32 bits). 
 