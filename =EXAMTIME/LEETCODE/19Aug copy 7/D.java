import java.util.*;

public class D {
    // Utility function to calculate GCD of three numbers
    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private static int gcd(int a, int b, int c) {
        return gcd(gcd(a, b), c);
    }

    // Utility function to get the prime factors of a number
    private static Set<Integer> getPrimeFactors(int num) {
        Set<Integer> factors = new HashSet<>();
        while (num % 2 == 0) {
            factors.add(2);
            num /= 2;
        }
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            while (num % i == 0) {
                factors.add(i);
                num /= i;
            }
        }
        if (num > 2) {
            factors.add(num);
        }
        return factors;
    }

    public static long trickyTriplets(int n, int[] a) {
        // Map to store numbers by their prime factors
        Map<Set<Integer>, List<Integer>> factorGroups = new HashMap<>();
        
        for (int num : a) {
            Set<Integer> factors = getPrimeFactors(num);
            factorGroups.computeIfAbsent(factors, k -> new ArrayList<>()).add(num);
        }
        
        Set<Integer> uniqueBeautiness = new HashSet<>();
        
        for (List<Integer> group : factorGroups.values()) {
            if (group.size() >= 3) {
                // Generate all possible triplets
                for (int i = 0; i < group.size(); i++) {
                    for (int j = i + 1; j < group.size(); j++) {
                        for (int k = j + 1; k < group.size(); k++) {
                            int gcdValue = gcd(group.get(i), group.get(j), group.get(k));
                            uniqueBeautiness.add(gcdValue);
                        }
                    }
                }
            }
        }
        
        return uniqueBeautiness.size();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(trickyTriplets(6, new int[]{2, 4, 8, 3, 9, 27})); // Output: 2
        System.out.println(trickyTriplets(4, new int[]{10, 20, 40, 80})); // Output: 2
        System.out.println(trickyTriplets(3, new int[]{3,5,2})); // Output: 2

    }
}
