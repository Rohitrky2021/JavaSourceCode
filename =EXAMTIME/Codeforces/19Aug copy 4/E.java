import java.util.Scanner;

public class E {
    private static final int MOD = 998244353;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        // For the case where k = 2, special handling is required since it simplifies the combinations significantly
        if (k == 2) {
            long result = 1;
            for (int i = 0; i < n - 1; i++) {
                result = (result * 2) % MOD;
            }
            System.out.println(result);
            return;
        }

        // For general case where k >= 2
        long[] factorial = new long[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = (factorial[i - 1] * i) % MOD;
        }

        long result = 0;
        for (int i = k; i <= n; i++) {
            long combination = (factorial[n] * modInverse((factorial[i] * factorial[n - i]) % MOD, MOD)) % MOD;
            result = (result + combination) % MOD;
        }

        System.out.println(result);
    }

    private static long modInverse(long a, long mod) {
        return pow(a, mod - 2, mod);
    }

    private static long pow(long a, long b, long mod) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * a) % mod;
            }
            a = (a * a) % mod;
            b >>= 1;
        }
        return res;
    }
}
