
import java.util.*;



import java.util.Arrays;

class Mobius_Using_Sieve {//  O(N * log(log(N))),

    static final int MAXN = 100005;

    static int[] lp = new int[MAXN];
    static int[] m = new int[MAXN];

    static void initializeMobius() {
        Arrays.fill(lp, 0);
        Arrays.fill(m, 1);

        m[1] = 1;
        for (int i = 2; i < MAXN; ++i) {
            if (lp[i] == 0) {
                for (int j = i; j < MAXN; j += i) {
                    if (lp[j] == 0) {
                        lp[j] = i;
                    }
                }
            }

            m[i] = calculateMobius(i);
        }
    }

    static int calculateMobius(int x) {
        int cnt = 0;
        while (x > 1) {
            int k = 0, d = lp[x];
            while (x % d == 0) {
                x /= d;
                ++k;
                if (k > 1) {
                    return 0;
                }
            }
            ++cnt;
        }
        return (cnt % 2 == 1) ? -1 : 1;
    }

    public static void main(String[] args) {
        initializeMobius();

        // Printing Möbius function values for numbers in the range [1, 20]
        System.out.println("Möbius function values for numbers in the range [1, 20]:");
        for (int i = 1; i <= 20; i++) {
            System.out.println("μ(" + i + ") = " + m[i]);
        }
    }
}

