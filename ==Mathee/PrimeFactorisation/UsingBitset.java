package PrimeFactorisation;

import java.util.*;
import java.util.BitSet;

public class UsingBitset {
    static void sieveOfEratosthenes(int n) {
        // Create a BitSet to represent the numbers from 2 to n
        BitSet prime = new BitSet(n + 1);

        // Initialize 2 as prime
        prime.set(2);

        for (int p = 3; p <= n; p += 2) {
            if (!prime.get(p)) {
                // p is a prime number, mark its multiples as composite
                for (long j = (long) p * p; j <= n; j += 2 * p) {
                    prime.set((int) j);
                }
            }
        }

        // Printing prime numbers
        System.out.print("2 ");
        for (int i = 3; i <= n; i += 2) {
            if (!prime.get(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        int n = 10; // Change this to the desired value of N
        sieveOfEratosthenes(n);
    }
}

// The maximum
// value of
// N that
// you can
// use with
// the Sieve
// of Eratosthenes
// algorithm depends
// on several factors,
// including the
// available memory
// on your system,
// the efficiency
// of your code,
// and the
// specific constraints
// of your
// programming environment.However,for
// practical purposes, the
// following guidelines
// can be considered:

// Memory Constraints:
// The primary
// limiting factor for
// large values
// of N
// is the
// amount of
// available memory.
// A BitSet
// with N
// bits requires N/8
// bytes of

// memory (since each bit is represented by one byte). If you're working with a 32-bit BitSet, you'll need N/32 integers of memory.

// Efficiency: As N increases, the time complexity of the Sieve of Eratosthenes algorithm also increases. It becomes more computationally expensive to mark multiples of primes, especially for larger primes.

// Hardware: The amount of memory and computational power available on your computer or server also plays a role. High-performance servers with large amounts of RAM can handle larger values of N compared to typical desktop computers or embedded systems.

// Programming Environment: Some programming environments may impose their own limitations on memory usage or execution time.

// Given these considerations, there isn't a fixed "maximum" value of N that applies universally. Instead, it's advisable to approach the problem based on your specific hardware and software constraints.

// For very large values of N (e.g., N > 10^7), you may need to consider alternative approaches, such as segmented sieves, distributed computing, or using external storage for intermediate results. These approaches can help overcome memory and performance limitations associated with large N values.

// As for the logic of the Sieve of Eratosthenes algorithm, it works as follows:

// Create a boolean array or BitSet of size N+1, initially assuming all numbers from 2 to N are prime.

// Start with the first prime number, 2. Mark all multiples of 2 (excluding 2 itself) as non-prime.

// Move to the next unmarked number, which is

// a prime (3 in this case). Mark all multiples of 3 (excluding 3 itself) as non-prime.

// Continue this process for each unmarked number until you reach the square root of N. After this step, all remaining unmarked numbers are primes.

// Iterate through the boolean array or BitSet to find and print the prime numbers.

// The key optimization in this algorithm is that you only need to check multiples of prime numbers up to the square root of N, as all larger multiples would have already been marked as non-prime by the time you reach them. This optimization significantly reduces the number of operations required for large values of N.