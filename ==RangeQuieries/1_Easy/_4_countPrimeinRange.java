import java.util.*;

public class countPrimeinRange {
    
    // Function to count primes in a range using Sieve of Eratosthenes
    public static int[] countPrimesInRange(int maxLimit) {
        boolean[] isPrime = new boolean[maxLimit + 1];
        Arrays.fill(isPrime, true);
        
        // Sieve of Eratosthenes
        for (int p = 2; p * p <= maxLimit; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= maxLimit; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        
        // Count primes and store in prefix array
        int[] prefix = new int[maxLimit + 1];
        for (int i = 2; i <= maxLimit; i++) {
            prefix[i] = prefix[i - 1];
            if (isPrime[i]) {
                prefix[i]++;
            }
        }
        
        return prefix;
    }
    
    // Function to answer queries in O(1) time
    public static int countPrimesInRange(int[] prefix, int L, int R) {
        return prefix[R] - prefix[L - 1];
    }
    
    public static void main(String[] args) {
        int maxLimit = 10000;
        int[] prefix = countPrimesInRange(maxLimit);
        
        // Example queries
        int L1 = 1, R1 = 10;
        int L2 = 5, R2 = 10;
        
        System.out.println(countPrimesInRange(prefix, L1, R1));
        System.out.println(countPrimesInRange(prefix, L2, R2));
    }
}
