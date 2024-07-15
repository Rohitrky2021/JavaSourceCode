// TC--> O(N*loglogN)--> BY Ignoring the Precomputation Time 

    // https://www.geeksforgeeks.org/print-all-prime-factors-and-their-powers/

// Java Program to print prime
// factors and their powers using
// Sieve Of Eratosthenes
import java.io.*;
public class facto {  

// Using SieveOfEratosthenes
// to find smallest prime
// factor of all the numbers.
// For example, if N is 10,
// s[2] = s[4] = s[6] = s[10] = 2
// s[3] = s[9] = 3
// s[5] = 5
// s[7] = 7
static void sieveOfEratosthenes(int N,int s[])
{
	// Create a boolean array
	// "prime[0..n]" and initialize
	// all entries in it as false.
	boolean[] prime = new boolean[N + 1];

	// Initializing smallest
	// factor equal to 2
	// for all the even numbers
	for (int i = 2; i <= N; i += 2)
		s[i] = 2;

	// For odd numbers less
	// then equal to n
	for (int i = 3; i <= N; i += 2)
	{
		if (prime[i] == false)
		{
			// s(i) for a prime is
			// the number itself
			s[i] = i;

			// For all multiples of
			// current prime number
			for (int j = i; j * i <= N; j += 2)
			{
				if (prime[i * j] == false)
				{
					prime[i * j] = true;

					// i is the smallest prime
					// factor for number "i*j".
					s[i * j] = i;
				}
			}
		}
	}
}

// Function to generate prime
// factors and its power
static void generatePrimeFactors(int N)
{
	// s[i] is going to store
	// smallest prime factor of i.
	int[] s = new int[N + 1];

	// Filling values in s[] using sieve  
	sieveOfEratosthenes(N, s);//  Using the Above Method  

	System.out.println("Factor Power");

	int curr = s[N]; // Current prime factor of N
	int cnt = 1; // Power of current prime factor

	// Printing prime factors
	// and their powers
	while (N > 1)
	{
		N /= s[N];

		// N is now N/s[N]. If new N
		// also has smallest prime
		// factor as curr, increment power
		if (curr == s[N])
		{
			cnt++;
			continue;
		}

		System.out.println(curr + "\t" + cnt);

		// Update current prime factor
		// as s[N] and initializing
		// count as 1.
		curr = s[N];
		cnt = 1;
	}
}

private static int distinctValuesOfK(int aPow, int bPow, int l) {
	// Calculate the powers of primes for a and b
	int a = (int) Math.pow(l, 1.0 / aPow);
	int b = (int) Math.pow(l, 1.0 / bPow);
	
	// Count the number of divisors of l that are divisible by both a and b
	int count = countDivisors(l, a, b);
	
	return count;
}

private static int countDivisors(int l, int a, int b) {
	int count = 0;
	for (int i = 1; i <= Math.sqrt(l); i++) {
		if (l % i == 0) {
			if (i % a == 0 && (l / i) % b == 0) {
				if (i == l / i) // check if divisor is the same
					count++;
				else
					count += 2; // increment by 2 for two distinct divisors
			}
		}
	}
	return count;
}

// Driver Code
public static void main(String[] args)
{
	int N = 20;
	System.err.println(distinctValuesOfK(2,1,20));
	
	generatePrimeFactors(N);
}
}

// This code is contributed by mits
