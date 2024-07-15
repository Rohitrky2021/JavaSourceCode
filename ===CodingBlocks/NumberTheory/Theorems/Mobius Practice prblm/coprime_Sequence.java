
    // All subarray with GCD==1;
    // https://codeforces.com/contest/803/problem/F
import java.io.*;
import java.util.*;

public class coprime_Sequence {
    static PrintWriter pw;
    static Scanner sc;
    static int[] mobius, lp;

    static void mobius(int MAXN) {
        mobius = new int[MAXN + 1];
        lp = new int[MAXN + 1];
        Arrays.fill(mobius, -1);

        for (int i = 2; i <= MAXN; ++i) {
            if (lp[i] == 0) {
                mobius[i] = 1;
                for (int j = 2; i * j <= MAXN; ++j) {
                    lp[i * j] = i;
                    if (j % i == 0)
                        mobius[i * j] = 0;
                    else
                        mobius[i * j] *= -1;
                }
            }
        }
    }

    final static int MOD = (int) 1e9 + 7;

    static long pow(long base, long exp, long mod) {
        base %= mod;
        long res = 1L;

        while (exp > 0) {
            if ((exp & 1) == 1)
                res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1L;
        }

        return res;
    }

    public static void main(String[] args) throws Exception {
        pw = new PrintWriter(System.out);
        sc = new Scanner(System.in);

        int n = sc.nextInt();
        int MAXN = (int) 1e5;
        mobius(MAXN);

        int[] cnt = new int[MAXN + 1];
        for (int i = 0; i < n; i++) {
            cnt[sc.nextInt()]++;
        }

        for (int i = 2; i <= MAXN; i++) {
            for (int j = 2 * i; j <= MAXN; j += i) {
                cnt[i] += cnt[j];
            }
        }

        long[] pre = new long[n + 1];
        pre[0] = 1;

        for (int i = 1; i <= n; i++) {
            pre[i] = (2 * pre[i - 1]) % MOD;
        }

        long ans = pre[n] - 1;

        for (int i = 2; i <= MAXN; i++) {
            if (mobius[i] == 0 || cnt[i] == 0)
                continue;

            ans -= mobius[i] * (pre[cnt[i]] - 1);

            if (ans >= MOD)
                ans -= MOD;
            if (ans < 0)
                ans += MOD;
        }

        pw.println(ans);
        pw.flush();
    }
}
