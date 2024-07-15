
    import java.util.ArrayList;

    public class SpaceOptimised {
    
        static ArrayList<Integer> sieve(int n) {
            boolean[] isPrime = new boolean[n + 1];
            ArrayList<Integer> primes = new ArrayList<>();
    
            for (int i = 2; i <= n; i++) {
                if (!isPrime[i]) {
                    primes.add(i);
                    for (long j = (long) i * i; j <= n; j += i) {
                        isPrime[(int) j] = true;
                    }
                }
            }
    
            return primes;
        }
    
        static void segmentedSieve(long low, long high) {
            int sqrtHigh = (int) Math.sqrt(high);
            ArrayList<Integer> basePrimes = sieve(sqrtHigh);
    
            boolean[] isPrime = new boolean[(int) (high - low + 8)];
    
            for (int prime : basePrimes) {
                long start = Math.max(prime * prime, (low + prime - 1) / prime * prime);
                for (long j = start; j <= high; j += prime) {
                    isPrime[(int) (j - low)] = true;
                }
            }
    
            for (long i = low; i <= high; i++) {
                if (!isPrime[(int) (i - low)]) {
                    System.out.print(i + " ");
                }
            }
        }
    
        public static void main(String[] args) {
            long low = 1L;
            long high = 10000000000L; // 10^10
            segmentedSieve(low, high);
        }
    }
    