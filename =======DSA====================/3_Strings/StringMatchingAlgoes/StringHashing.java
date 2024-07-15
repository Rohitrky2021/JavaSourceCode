 
import java.util.Scanner;

// public class PolyHashExample {
    public class StringHashing {

// High Probability of COllision so Not used In Industry 
    // Hashing takes O(n)
    static long polyHashString(String s) {
        long prime = 31, mod = 1_000_000_007;
        int n = s.length();
        long hash = 0;
        long p = 1;

        for (int i = 0; i < n; i++) {
            hash += (s.charAt(i) - 'a' + 1) * p;
            p *= prime;// increasing p power 
            p %= mod;  // Now mod so its no give wrong ans by overflow 
            hash %= mod;
        }

        return hash;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Example usage
        System.out.println("Enter a string:");
        String s = scanner.next();

        long hashValue = polyHashString(s);
        System.out.println("Hash value of the string: " + hashValue);
    }
}
