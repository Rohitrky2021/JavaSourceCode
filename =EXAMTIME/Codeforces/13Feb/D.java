import java.util.*;

public class D {
    static class FenwickTree {
        private int[] tree;

        public FenwickTree(int size) {
            tree = new int[size + 1];
        }

        public void update(int index, int delta) {
            while (index < tree.length) {
                tree[index] += delta;
                index += index & -index;
            }
        }

        public int query(int index) {
            int sum = 0;
            while (index > 0) {
                sum += tree[index];
                index -= index & -index;
            }
            return sum;
        }

        public int rangeQuery(int left, int right) {
            return query(right) - query(left - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            FenwickTree modX = new FenwickTree(x);
            FenwickTree modY = new FenwickTree(y);

            long beautifulPairs = 0;

            for (int i = 0; i < n; i++) {
                beautifulPairs += modY.query((a[i] % y == 0) ? y : a[i] % y); // beautiful pairs condition 2
                beautifulPairs += modX.rangeQuery(((x - a[i] % x) % x) + 1, x); // beautiful pairs condition 1
                modX.update(a[i] % x + 1, 1); // Update frequency of current mod x
                modY.update(a[i] % y + 1, 1); // Update frequency of current mod y
            }

            System.out.println(beautifulPairs);
        }
    }
}
