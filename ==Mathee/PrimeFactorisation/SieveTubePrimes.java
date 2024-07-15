package PrimeFactorisation;

 
import java.util.*;

public class SieveTubePrimes{// Use this only When Constrain in --> 10^6  ---> Otherwise Use SquareRoot Method -->in O(sqrt(n))
    public static void main(String[] args) {
        int n = 10; // Upper limit to find primes
        boolean[] primes = findPrimes(n);

        System.out.println("Prime numbers up to " + n + ":");
        for (int i = 2; i <= n; i++) {
            if (primes[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static boolean[] findPrimes(int n) {
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);

        primes[0] = primes[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (primes[i]) {  // below line when we have in if (!prime[i])  ==>i.e No. has some divisors then check its not prime 
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = false;  // if want count just do here Prime[j]++;
                }
            }
        }

        return primes;
    }
}
