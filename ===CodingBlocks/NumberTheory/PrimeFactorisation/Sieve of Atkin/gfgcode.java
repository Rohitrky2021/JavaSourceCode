// https://www.geeksforgeeks.org/sieve-of-atkin/?ref=lbp
// Time complexity: O(limit)
// Auxiliary space: O(limit)

// Input:  limit = 10
// Output: 2, 3, 5, 7

// Input:  limit = 20
// Output: 2, 3, 5, 7, 11, 13, 17, 19 
import java.util.*;

public class gfgcode {

    static void SieveOfAtkin(int limit) {
        // 2 and 3 are known to be prime
        if (limit > 2)
            System.out.print(2 + " ");

        if (limit > 3)
            System.out.print(3 + " ");

        // Initialize the sieve array with false values
        boolean sieve[] = new boolean[limit + 1];

        for (int i = 0; i <= limit; i++)
            sieve[i] = false;

        /*
         * Mark sieve[n] is true if one of the
         * following is true:
         * a) n = (4*x*x)+(y*y) has an odd number
         * of solutions, i.e., there exist
         * an odd number of distinct pairs
         * (x, y) that satisfy the equation
         * and n % 12 = 1 or n % 12 = 5.
         * b) n = (3*x*x)+(y*y) has an odd number
         * of solutions and n % 12 = 7
         * c) n = (3*x*x)-(y*y) has an odd number
         * of solutions, x > y and n % 12 = 11
         */
        for (int x = 1; x * x <= limit; x++) {
            for (int y = 1; y * y <= limit; y++) {

                // Main part of Sieve of Atkin
                int n = (4 * x * x) + (y * y);
                if (n <= limit && (n % 12 == 1 || n % 12 == 5))
                    sieve[n] ^= true;

                n = (3 * x * x) + (y * y);
                if (n <= limit && n % 12 == 7)
                    sieve[n] ^= true;

                n = (3 * x * x) - (y * y);
                if (x > y && n <= limit && n % 12 == 11)
                    sieve[n] ^= true;
            }
        }

        // Mark all multiples of squares as non-prime
        for (int r = 5; r * r <= limit; r++) {
            if (sieve[r]) {
                for (int i = r * r; i <= limit; i += r * r)
                    sieve[i] = false;
            }
        }

        // Print primes using sieve[]
        for (int a = 5; a <= limit; a++)
            if (sieve[a])
                System.out.print(a + " ");
        System.out.println();
    }

    // Driver code
    public static void main(String[] args) {
        int limit = 20;
        SieveOfAtkin(limit);
    }
}

// The Sieve
// of Atkin
// is an algorithm for
// finding prime
// numbers that
// has some
// advantages over
// other prime-generating algorithms
// like the
// Sieve of
// Eratosthenes.Here are
// the advantages
// of the
// Sieve of Atkin:

// Efficiency:
// The Sieve
// of Atkin
// is particularly efficient for
// generating primes
// in a
// specified range.
// It has
// better time
// complexity compared
// to traditional
// algorithms like
// trial division
// and can
// generate primes quickly,especially for
// large ranges.

// Space Efficiency:
// The Sieve
// of Atkin
// uses less
// memory compared
// to the
// Sieve of Eratosthenes for
// generating primes
// within a
// given range.
// It marks
// composite numbers
// using a
// boolean array, where
// each element
// represents whether
// a number
// is prime
// or not.
// This results
// in efficient
// memory usage.

// No Need for Division:
// Unlike trial
// division methods, the
// Sieve of
// Atkin avoids
// the need for
// division operations
// when checking for primality.Instead,
// it uses
// modular arithmetic
// and bitwise operations,
// which can
// be faster
// on modern
// CPUs.

// Deterministic Algorithm:
// The Sieve
// of Atkin
// is a
// deterministic algorithm, meaning
// it will
// always produce
// the same
// set of primes for
// a given
// range. This determinism
// is useful for
// certain applications
// where consistency
// is important.

// Optimized for
// Specific Patterns:
// The algorithm
// is specifically
// designed to
// identify prime
// numbers that
// satisfy certain
// congruence conditions modulo 4,
// which makes
// it well-suited for
// applications involving
// quadratic residues
// and certain
// mathematical problems.

// Parallelization:
// The algorithm
// can be
// parallelized easily, which
// means it
// can take
// advantage of multi-
// core processors for
// even faster
// prime generation
// in parallel
// computing environments.

// Despite these advantages,it's
// important to
// note that
// the Sieve
// of Atkin
// is most
// efficient within
// a certain
// range and
// becomes less practical for
// generating very
// large prime
// numbers or for
// prime factorization tasks,
// where more
// specialized algorithms
// like the
// quadratic sieve
// or elliptic
// curve factorization
// are often employed
// .