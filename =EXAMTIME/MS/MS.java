import java.util.Scanner;

public class MS {
    static final long MOD = 1000000007;

    public static long countValidPasswords(int n, int k) {
        // Initialize result as 26^n
        long result = 1;
        for (int i = 0; i < n; i++) {
            result = (result * 26) % MOD;
        }

        // Calculate the number of passwords with k consecutive equal characters
        for (int i = 1; i < k; i++) {
            result -= (26 - i) * (long)Math.pow(25, n - i) % MOD;
            result = (result + MOD) % MOD;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        long result = countValidPasswords(n, k);
        System.out.println(result);

        scanner.close();
    }
}
