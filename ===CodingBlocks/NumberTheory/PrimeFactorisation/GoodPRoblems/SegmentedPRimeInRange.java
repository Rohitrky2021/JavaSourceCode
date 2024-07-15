
import java.util.*;
import java.lang.Math;
// https://www.geeksforgeeks.org/segmented-sieve-print-primes-in-a-range/?ref=lbp

public class SegmentedPRimeInRange {
    // fillPrime function fills primes from 2 to sqrt of high in chprime ArrayList
    public static void fillPrime(ArrayList<Integer> chprime, int high) {
        boolean[] ck = new boolean[high + 1];
        Arrays.fill(ck, true);
        ck[1] = false;
        ck[0] = false;

        for (int i = 2; (i * i) <= high; i++) {
            if (ck[i] == true) {
                for (int j = i * i; j <= Math.sqrt(high); j = j + i) {
                    ck[j] = false;
                }
            }
        }
        for (int i = 2; i * i <= high; i++) {
            if (ck[i] == true) {
                // cout<< i<<"\n";
                chprime.add(i);
            }
        }
    }

    // in segmented sieve we check for prime from range [low, high]
    public static void segmentedSieve(int low, int high) {
        ArrayList<Integer> chprime = new ArrayList<Integer>();
        fillPrime(chprime, high);
        // chprimes has primes in range [2,sqrt(n)]
        // we take primes from 2 to sqrt[n] because the multiples of all primes below
        // high are marked by these
        // primes in range 2 to sqrt[n] for eg: for number 7 its multiples i.e 14 is
        // marked by 2, 21 is marked by 3,
        // 28 is marked by 4, 35 is marked by 5, 42 is marked 6, so 49 will be first
        // marked by 7 so all number before 49
        // are marked by primes in range [2,sqrt(49)]

        boolean[] prime = new boolean[high - low + 1];
        Arrays.fill(prime, true);
        // here prime[0] indicates whether low is prime or not similarly prime[1]
        // indicates whether low+1 is prime or not
        for (int i : chprime) {
            int lower = (low / i);
            // here lower means the first multiple of prime which is in range [low,high]
            // for eg: 3's first multiple in range [28,40] is 30
            if (lower <= 1) {
                lower = i + i;
            } else if (low % i != 0) {
                lower = (lower * i) + i;
            } else {
                lower = (lower * i);
            }
            for (int j = lower; j <= high; j = j + i) {
                prime[j - low] = false;
            }
        }
        for (int i = low; i <= high; i++) {
            if (prime[i - low] == true) {
                System.out.printf("%d ", i);
            }
        }
    }

    public static void main(String[] args) {
        // low should be greater than or equal to 2
        int low = 2;
        // low here is the lower limit
        int high = 100;
        // high here is the upper limit
        // in segmented sieve we calculate primes in range [low,high]
        // here we initially we find primes in range [2,sqrt(high)] to mark all their
        // multiples as not prime
        // then we mark all their(primes) multiples in range [low,high] as false
        // this is a modified sieve of eratosthenes , in standard sieve of eratosthenes
        // we find prime from 1 to n(given number)
        // in segmented sieve we only find primes in a given interval
        System.out.println("Primes in Range " + low + " to " + high + " are ");
        segmentedSieve(low, high);
    }
}
