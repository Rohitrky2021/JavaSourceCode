import java.util.Arrays;

public class optimised {
    // Use this only When Constrain in --> 10^6  ---> Otherwise Use SquareRoot Method -->in O(sqrt(n))
    public static void main(String[] args) {
        int n = 1000_000_000; // Upper limit to find primes
        boolean[] primes = findPrimes(n);

        System.out.println("Prime numbers up to " + n + ":");
        // for (int i = 2; i <= n; i++) {
        //     if (primes[i]) {
        //         System.out.print(i + " ");
        //     }
        // }
        System.out.print(primes[n] + " ");
    }

    public static boolean[] findPrimes(int n) {
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);

        primes[0] = primes[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }

        return primes;
    }
}
