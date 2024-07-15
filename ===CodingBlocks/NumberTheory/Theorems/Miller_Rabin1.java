 import java.util.*;
    // For number approx equal to 10^18---> To fing Is prime or Composite 

public class Miller_Rabin1 {
    static boolean isComposite(long n, long a, long d, int r) { //2nd
        long x = power(a, d, n);
        if (x == 1 || x == n - 1) {
            return false;
        }

        for (int i = 0; i < r - 1; i++) {
            x = (x * x) % n;
            if (x == 1) {
                return true; // Composite
            }
            if (x == n - 1) {
                return false;
            }
        }
        return true; // Composite
    }

    static long power(long x, long y, long p) {//3rd
        long res = 1;
        x = x % p;
        while (y > 0) {
            if ((y & 1) == 1) {
                res = (res * x) % p;
            }
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }
 
    static boolean millerRabin(long n, int k) { //1st
        if (n <= 1 || n == 4) {
            return false;
        }
        if (n <= 3) {
            return true;
        }

        // Find d such that n-1 = 2^r * d
        long d = n - 1;
        int r = 0;
        while ((d & 1) == 0) {
            d >>= 1;
            r++;
        }

        Random rand = new Random();
        for (int i = 0; i < k; i++) {
            long a = 2 + rand.nextInt((int) (n - 4)); // Random number in [2, n-2]
            if (isComposite(n, a, d, r)) {
                return false; // Composite
            }
        }
        return true; // Probably prime
    }

    public static void main(String[] args) {
        long n = 45; // Replace with the desired value of n
        int k = 5;   // Replace with the desired value of k

        if (millerRabin(n, k)) {
            System.out.println(n + " is probably prime.");
        } else {
            System.out.println(n + " is composite.");
        }
    }
}
