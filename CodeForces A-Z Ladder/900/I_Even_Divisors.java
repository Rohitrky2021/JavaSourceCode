import java.util.Scanner;

public class I_Even_Divisors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt(); // Number of test cases

        for (int i = 0; i < t; i++) {
            long a = scanner.nextLong(); // Value of n for the current test case

            // Check if n has an odd divisor greater than one
            if ((a&(a-1))==0) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }

        scanner.close();
    }

    // Function to check if n has an odd divisor greater than one
    private static boolean hasOddDivisor(long n) {
        // If n is even, return true since it always has an odd divisor (2)
        if (n % 2 == 0) {
            return true;
        }

        // Iterate from 3 up to the square root of n
        for (long i = 3; i * i <= n; i += 2) {
            // If n is divisible by i, return true
            if (n % i == 0) {
                return true;
            }
        }

        // If no odd divisor greater than one is found, return false
        return false;
    }
}
