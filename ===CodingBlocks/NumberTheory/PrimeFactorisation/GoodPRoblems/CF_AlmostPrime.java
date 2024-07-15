
    // https://codeforces.com/problemset/problem/26/A

    // Calculate primeCount array using Sieve of Eratosthenes

import java.util.Scanner;

public class CF_AlmostPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] primeCount = new int[n + 1];

        // Calculate primeCount array using Sieve of Eratosthenes
        for (int i = 2; i <= n; i++) {
            if (primeCount[i] == 0) {
                for (int j = i; j <= n; j += i) {
                    primeCount[j]++;
                }
            }
        }

        int almostPrimeCount = 0;
        for (int i = 2; i <= n; i++) {
            if (primeCount[i] == 2) {
                almostPrimeCount++;
            }
        }

        System.out.println(almostPrimeCount);
    }
}



// A number
// is called
// almost prime if
// it has
// exactly two
// distinct prime
// divisors. For example, numbers 6,18,24
// are almost prime,while 4,8,9,42
// are not.
// Find the
// amount of
// almost prime
// numbers which
// are between 1
// and n, inclusive.