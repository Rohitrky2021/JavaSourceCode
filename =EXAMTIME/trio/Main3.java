import java.util.*;

public class Main3 {
    static final int MOD = 1000000007;

    static long binpow(long a, long b) {
        if (b == 0)
            return 1;
        long res = binpow(a, b / 2);
        if (b % 2 == 1)
            return (res % MOD * res % MOD * a) % MOD;
        else
            return res % MOD * res % MOD;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int test_cases = scanner.nextInt();
        while (test_cases-- > 0) {
            int n = scanner.nextInt();

            int m = (n * (n - 1)) / 2;
            Map<Integer, Integer> mp = new HashMap<>();
            int[] a = new int[m];
            for (int i = 0; i < m; i++) {
                a[i] = scanner.nextInt();
                mp.put(a[i], mp.getOrDefault(a[i], 0) + 1);
            }

            int r = n - 1;
            List<Integer> v = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
                int freq = entry.getValue();
                if (r == freq) {
                    v.add(entry.getKey());
                    r--;
                } else {
                    int x = r, p = 0;
                    while (x > 0 && freq != p) {
                        p += x;
                        v.add(entry.getKey());
                        x--;
                    }
                    r = x;
                }
            }

            for (int it : v)
                System.out.print(it + " ");

            int x = v.size();
            while (x != n) {
                System.out.print("1000000000 ");
                x++;
            }

            System.out.println();
        }
    }
}
