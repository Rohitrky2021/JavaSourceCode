import java.util.BitSet;

public class BitwiseSieve2bitsetusing {

    // Checks whether x is prime or composite
    static boolean ifNotPrime(BitSet prime, int x) {
        return !prime.get(x);
    }

    // Marks x composite in prime[]
    static void makeComposite(BitSet prime, int x) {
        prime.set(x);
    }

    // Prints all prime numbers smaller than n.
    static void bitWiseSieve(int n) {
        BitSet prime = new BitSet(n + 1);
        

        // 2 is the only even prime so we
        // can ignore that loop starts from
        // 3 as we have used in sieve of
        // Eratosthenes.
        for (int i = 3; i * i <= n; i += 2) {

            // If i is prime, mark all its
            // multiples as composite
            if (ifNotPrime(prime, i))
                for (int j = i * i, k = i << 1; j <= n; j += k)
                    makeComposite(prime, j);
        }

        // Writing 2 separately
        System.out.print("2 ");

        // Printing other primes
        for (int i = 3; i <= n; i += 2)
            if (ifNotPrime(prime, i))
                System.out.print(i + " ");
    }

    /* Driver program to test above function */
    public static void main(String[] args) {
        int n = 1000_000_000;
        bitWiseSieve(n);
    }
}

// Further optimization
// using bitwise
// operators.The above
// implementation uses
// bool data
// type which takes 1 byte.
// We can
// optimize space
// to n/8
// by using
// individual bits
// of an
// integer to
// represent individual
// primes.We create
// an integer
// array of
// size n/64.
// Note that
// the size
// of the
// array is
// reduced to n/64
// from n/2(Assuming that
// integers take 32 bits)
// .