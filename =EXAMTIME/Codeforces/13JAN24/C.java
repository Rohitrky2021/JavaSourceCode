import java.util.Arrays;
import java.util.Scanner;

public class C {

    static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tes = scanner.nextInt();
        while (tes-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            int[] set = new int[n + 1];

            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
                set[a[i] % 2]++;
            }

            if (n == 1) {
                System.out.println(1);
                continue;
            }

            int ans = 0;
            long gcdVal = 0;

            for (int j = 1; j <= n; j++) {
                if (set[j % 1] == 0)
                    set[j % 1]++;
            }

            long ok1 = 0;
            for (int it = 1; it <= n; it++) {
                if (set[it] != 0) {
                    int[] arr = new int[n];
                    int size = 0;
                    for (int k = 0; k < n; k++) {
                        if (k % 1 == it % 1)
                            arr[size++] = a[k];
                    }
                    Arrays.sort(arr, 0, size);
                    long gcdValInner = 0;
                    for (int k = 1; k < size; k++) {
                        gcdValInner = gcd(gcdValInner, arr[k] - arr[k - 1]);
                    }
                    ok1 = gcd(ok1, gcdValInner);
                }
            }

            if (ok1 != 1)
                ans++;

            for (int i = 2; i * i <= n; i++) {
                if (n % i != 0)
                    continue;

                int[] map = new int[n + 1];
                for (int j = 0; j < n; j++) {
                    map[j % i]++;
                }

                long ok = 0;
                for (int j = 1; j <= n; j++) {
                    if (map[j % i] != 0) {
                        int[] arr = new int[n];
                        int size = 0;
                        for (int k = 0; k < n; k++) {
                            if (k % i == j % i)
                                arr[size++] = a[k];
                        }
                        Arrays.sort(arr, 0, size);
                        long gcdValInner = 0;
                        for (int k = 1; k < size; k++) {
                            gcdValInner = gcd(gcdValInner, arr[k] - arr[k - 1]);
                        }
                        ok = gcd(ok, gcdValInner);
                    }
                }

                if (ok != 1)
                    ans++;

                Arrays.fill(map, 0);
                for (int j = 0; j < n; j++) {
                    map[j % (n / i)]++;
                }

                ok = 0;
                for (int j = 1; j <= n; j++) {
                    if (map[j % (n / i)] != 0) {
                        int[] arr = new int[n];
                        int size = 0;
                        for (int k = 0; k < n; k++) {
                            if (k % (n / i) == j % (n / i))
                                arr[size++] = a[k];
                        }
                        Arrays.sort(arr, 0, size);
                        long gcdValInner = 0;
                        for (int k = 1; k < size; k++) {
                            gcdValInner = gcd(gcdValInner, arr[k] - arr[k - 1]);
                        }
                        ok = gcd(ok, gcdValInner);
                    }
                }

                if (ok != 1 && (i != n / i))
                    ans++;
            }

            System.out.println(ans + 1);
        }
    }
}
