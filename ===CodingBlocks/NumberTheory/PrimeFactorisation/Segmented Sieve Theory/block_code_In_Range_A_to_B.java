 
import java.util.Arrays;

public class block_code {
    static int[] p = new int[1000001];

    static void sieve() {
        Arrays.fill(p, 1);

        for (int i = 2; i <= 1000000; i++) {
            if (p[i] == 1) {
                for (int j = 2 * i; j <= 1000000; j += i) {
                    p[j] = 0;
                }
            }
        }
    }

    static int segmentedSieve(long a, long b) {
        sieve();
        boolean[] pp = new boolean[(int) (b - a + 1)];
        Arrays.fill(pp, true);

        for (long i = 2; i * i <= b; i++) {
            for (long j = a; j <= b; j++) {
                if (p[(int) i] == 1) {
                    if (j == i) {
                        continue;
                    }
                    if (j % i == 0) {
                        pp[(int) (j - a)] = false;
                    }
                }
            }
        }

        int res = 0;
        for (int i = 0; i < b - a + 1; i++) {
            if (pp[i]) {
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        long a = 10; // replace with your desired values
        long b = 50;
        int result = segmentedSieve(a, b);
        System.out.println(result);
    }
}
