import java.util.Scanner;

public class MS2{
    static final int MOD = 1000000007;

    public static long countValidPasswords(int n, int k) {
        long totalPasswords = 1;
        long totalInvalidPasswords = 0;

        for (int i = 0; i < n; i++) {
            totalPasswords = (totalPasswords * 26) % MOD;

            if (i >= k - 1) {
                totalInvalidPasswords = (totalInvalidPasswords + totalPasswords) % MOD;
            }
        }

        long validPasswords = (totalPasswords - totalInvalidPasswords + MOD) % MOD;

        return validPasswords;
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
