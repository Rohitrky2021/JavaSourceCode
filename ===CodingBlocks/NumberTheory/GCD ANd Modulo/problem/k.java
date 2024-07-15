
    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;
    
    public class k {
        public static void main(String[] args) {
            int[] array1 = {2, 4, 6, 8};
            int[] array2 = {3, 5, 7, 9};
    
            List<Pair> result = findPairs(array1, array2);
    
            for (Pair pair : result) {
                System.out.println("Pair: (" + pair.first + ", " + pair.second + ")");
            }
        }
    
        static class Pair {
            int first;
            int second;
    
            Pair(int first, int second) {
                this.first = first;
                this.second = second;
            }
        }
    
        // Function to find pairs that meet the criteria
        static List<Pair> findPairs(int[] array1, int[] array2) {
            List<Pair> pairs = new ArrayList<>();
            Map<Integer, Integer> primeFactorsCount = new HashMap<>();
    
            // Count prime factors for elements in array2
            for (int num2 : array2) {
                countPrimeFactors(primeFactorsCount, num2);
            }
    
            for (int num1 : array1) {
                int diff = Math.abs(num1 - 1);
                int gcd = findGCD(num1, num1 + 1);
    
                if (diff != 1 && gcd != 1 && !containsCommonPrimeFactor(primeFactorsCount, num1)) {
                    pairs.add(new Pair(num1, num1 + 1));
                }
            }
    
            return pairs;
        }
    
        // Function to count prime factors of a number and store in the map
        static void countPrimeFactors(Map<Integer, Integer> map, int num) {
            for (int i = 2; i * i <= num; i++) {
                while (num % i == 0) {
                    map.put(i, map.getOrDefault(i, 0) + 1);
                    num /= i;
                }
            }
            if (num > 1) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
    
        // Function to find the greatest common divisor (GCD) of two numbers
        static int findGCD(int a, int b) {
            if (b == 0) {
                return a;
            } else {
                return findGCD(b, a % b);
            }
        }
    
        // Function to check if there are common prime factors between num and num + 1
        static boolean containsCommonPrimeFactor(Map<Integer, Integer> primeFactorsCount, int num) {
            for (int i = 2; i <= num + 1; i++) {
                if (primeFactorsCount.containsKey(i) && primeFactorsCount.get(i) > 0) {
                    return true;
                }
            }
            return false;
        }
    }
    