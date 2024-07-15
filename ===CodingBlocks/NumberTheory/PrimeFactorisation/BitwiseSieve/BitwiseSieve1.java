// https://www.geeksforgeeks.org/bitwise-sieve/?ref=lbp

// Java program to implement normal Sieve
// of Eratosthenes using simple optimization
// to reduce size of prime array to half and
// reducing iterations.
import java.util.Arrays;

public class BitwiseSieve1 {

	static void normalSieve(int n)
	{
		// prime[i] is going to store true if
		// if i*2 + 1 is composite.
		boolean prime[]=new boolean[n / 2];
		Arrays.fill(prime, false);
	
		// 2 is the only even prime so we can
		// ignore that. Loop starts from 3.
		for (int i = 3 ; i * i < n; i += 2)
		{
			// If i is prime, mark all its
			// multiples as composite
			if (prime[i / 2] == false)
				for (int j = i * i; j < n; j += i * 2)
					prime[j / 2] = true;
		}
	
		// writing 2 separately
		System.out.print("2 ");
	
		// Printing other primes
		for (int i = 3; i < n ; i += 2)
			if (prime[i / 2] == false)
				System.out.print(i + " ");
	}
	public static void main (String[] args)
	{
		int n = 10 ;
		normalSieve(n);
	}
}

// Time Complexity: O(nlogn)
// Space Complexity: O(n)
// One optimization in the below implementation is, we have skipped all even numbers altogether. 
// We reduce the size of the prime array to half. We also reduce all iterations to half. 