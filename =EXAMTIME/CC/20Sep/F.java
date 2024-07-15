
    import java.util.Scanner;

    public class F {       
         public static long MOD = 1000000007;
    
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();
    
            while (t-- > 0) {
                long n = scanner.nextLong();
                long k = scanner.nextLong();
    
                // Calculate the value of 2^n modulo MOD
                long twoPowN = pow(2, n);
    
                // Calculate the sum of L-th through R-th elements of f(A) modulo MOD
                long result = solve(n, k, twoPowN);
    
                System.out.println(result);
            }
        }
    
        // Recursive function to calculate f(A) and return the sum of L-th through R-th elements
        public static long solve(long n, long k, long twoPowN) {
            if (n == 1) {
                return k; // Base case: f([1]) = 1
            }
    
            long half = twoPowN / 2;
            if (k <= half) {
                // The desired element is in the first half of f(A)
                return solve(n - 1, k, half) + k;
            } else {
                // The desired element is in the second half of f(A)
                return solve(n - 1, k - half, half);
            }
        }
    
        // Helper function to calculate x^y modulo MOD
        public static long pow(long x, long y) {
            if (y == 0) {
                return 1;
            }
            long temp = pow(x, y / 2) % MOD;
            long result = (temp * temp) % MOD;
            if (y % 2 == 1) {
                result = (result * x) % MOD;
            }
            return result;
        }
    }
    
