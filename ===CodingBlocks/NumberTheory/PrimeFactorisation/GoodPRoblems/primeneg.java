
    import java.util.Arrays;
    import java.util.Scanner;
    
    public class primeneg {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt(); // Number of test cases
    
            for (int i = 0; i < t; i++) {
                int m = scanner.nextInt();
                int n = scanner.nextInt();
    
                generatePrimesInRange(m, n);
    
                if (i < t - 1) {
                    System.out.println(); // Separate test cases with an empty line
                }
            }
    
            scanner.close();
        }
    
        // Function to generate prime numbers in the given range [m, n]
        public static void generatePrimesInRange(int m, int n) {
            // Find the absolute values of m and n
            int absM = Math.abs(m);
            int absN = Math.abs(n);
    
            // Create an array to store prime flags
            boolean[] prime = new boolean[Math.max(absM, absN) * 2 + 1];
            Arrays.fill(prime, true);
    
            // 2 is the only even prime so we can ignore that. Loop starts from 3.
            for (int i = 3; i * i <= absN; i += 2) {
                // If i is prime, mark all its multiples as composite
                if (prime[i]) {
                    for (int j = i * i; j <= absN; j += i * 2) {
                        prime[j] = false;
                    }
                }
            }
    
            // Printing primes in the range [m, n]
            for (int i = Math.max(2, absM); i <= absN; i++) {
                if (prime[i]) {
                    // Adjust the sign based on the original input
                    int primeToPrint = (m < 0 && i % 2 != 0) ? -i : i;
                    System.out.print(primeToPrint + " ");
                }
            }
        }
    }
    