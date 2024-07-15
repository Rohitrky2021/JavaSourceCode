import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Vector;

public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            long k = scanner.nextLong();

            long[] a = new long[n];
            Deque<Long> q = new ArrayDeque<>();
            Vector<Boolean> vis = new Vector<>(n + 1);
            for (int i = 0; i <= n; i++) {
                vis.add(false);
            }

            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextLong();
                q.addLast(a[i]);
                vis.set((int) a[i], true);
            }

            long f = 0;
            for (int i = 0; i <= n; i++) {
                if (!vis.get(i)) {
                    f = i;
                    break;
                }
            }

            k = k % (n + 1);
            q.addLast(f);
            for (int i = 0; i < k; i++) {
                long x = q.removeLast();
                q.addFirst(x);
            }

            for (int i = 0; i < n; i++) {
                System.out.print(q.getFirst() + " ");
                q.removeFirst();
            }
            System.out.println();
        }
    }
}
