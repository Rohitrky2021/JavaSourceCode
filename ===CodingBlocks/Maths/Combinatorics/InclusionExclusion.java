import java.io.*;
public class InclusionExclusion {
    // https://www.geeksforgeeks.org/inclusion-exclusion-principle-and-programming-applications/

    // | A1 ∪ A2  |= |A1 |+ | A2| – |A1 ∩ A2|
    // Problem 1: How many numbers between 1 and 1000, including both, are divisible by 3 or 4? 
    // Java program to count the
// number of numbers between
// 1 and 1000, including both,
// that are divisible by 3 or 4

class GFG {

    // function to count the divisors
    public static int countDivisors(int N, int a, int b) {
        // Counts of numbers
        // divisible by a and b
        int count1 = N / a;
        int count2 = N / b;

        // inclusion-exclusion
        // principle applied
        int count3 = (N / (a * b));

        return count1 + count2 - count3;
    }

    // Driver Code
    public static void main(String[] args) {
        int N = 1000, a = 3, b = 4;
        System.out.println(countDivisors(N, a, b));
    }
}

// This code is contributed by m_kit

// Problem 2:
//  Given N prime numbers and a number M, find out how many numbers from 1 to M are divisible by any of the N given prime numbers. 
// Java program to count the
// number of numbers in range
// 1-M that are divisible by
// given N prime numbers



class GFG {
	// function to count the number
	// of numbers in range 1-M that
	// are divisible by given N
	// prime numbers
    // Time Complexity: O(2^N*N)
	public static int count(int a[], int m, int n)
	{
		int odd = 0;
		int even = 0;
		int counter = 0;
		int i = 0;
		int j = 0;
		int p = 1;
		int pow_set_size = (1 << n); // if want to run count=setsize --> can do setsize-1 as--> Removing the Zero subset 

		// Run from counter 000..0 to 111..1
		for (counter = 1; counter < pow_set_size; counter++) {  // We Used BitMasking to Calculate the Subsets 
			p = 1;
			for (j = 0; j < n; j++) {
				// Check if jth bit in the
				// counter is set If set
				// then print jth element from set
				if ((counter & (1 << j)) > 0) {  // making my product of number
					p *= a[j];  // subset todivide with the even or odd 
				}
			}

			// if set bits is odd, then add to
			// the number of multiples
			if (Integer.bitCount(counter) % 2 == 1) {  // built in Method to Count the Set Bits 
				odd += (m / p);// Subsett of set theeory we add and subtract accordinly for these to handle intersection and union 
			}
			else {
				even += (m / p);
			}
		}

		return odd - even; // We can also do it by odd and even k jgh replace ans and in return ans -simple --> overall m 0
	}

	// Driver Code
	public static void main(String[] args)
	{
		int a[] = { 2, 3, 5, 7 };
		int m = 100;
		int n = a.length;
		System.out.println(count(a, m, n));
	}
}


// Examples : 

// Input: N numbers = {2, 3, 5, 7}   M = 100 
// Output: 78   

// Input: N numbers = {2, 5, 7, 11}   M = 200
// Output: 137

}
