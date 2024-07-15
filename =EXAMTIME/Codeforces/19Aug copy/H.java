import java.util.Scanner;

public class H {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int k = scanner.nextInt();

            int answer = countNumbers(l, r, k);
            System.out.println(answer);
        }
        scanner.close();
    }

    static int countNumbers(int l, int r, int k) {
        if (k % 9 == 0) {
            // If k is divisible by 9, all numbers satisfy the condition
            return (int) ((long) (r - l) * fastPow(10, r - 1 - l) % MOD);
        } else {
            // Otherwise, count based on the sum of digits
            int count = 0;
            for (int digitSum = 1; digitSum <= 9; digitSum++) {
                if (k * digitSum % 9 == 0) {
                    count = (count + countInRange(l, r, digitSum)) % MOD;
                }
            }
            return count;
        }
    }

    static int countInRange(int l, int r, int digitSum) {
        // Count numbers in range [10^l, 10^r) with sum of digits equal to digitSum
        long count = 0;
        long pow10 = fastPow(10, r - 1); // 10^(r-1)

        // Calculate count using arithmetic progression sum formula
        for (int i = l; i < r; i++) {
            long start = pow10 / 10 * 9;
            long end = pow10;
            long numDigits = pow10 / 10;
            long fullCycles = (r - i - 1) / 9;
            long partialCycle = (r - i - 1) % 9 + 1;

            count += ((start + end) * numDigits / 2) % MOD;
            count = (count + (fullCycles * 45 * numDigits) % MOD) % MOD;
            count = (count + ((start + partialCycle * numDigits) % MOD)) % MOD;
            
            pow10 /= 10;
        }
        return (int) count;
    }

    // Function to calculate power in modular arithmetic
    static int fastPow(int base, int exp) {
        long result = 1;
        long baseLong = base;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * baseLong) % MOD;
            }
            baseLong = (baseLong * baseLong) % MOD;
            exp >>= 1;
        }
        return (int) result;
    }
}
