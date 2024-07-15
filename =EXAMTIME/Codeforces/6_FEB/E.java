import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tt = scanner.nextInt();
        while (tt-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] v = new int[n];
            int[] a = new int[k];
            a[0] = n;
            a[1] = 1;
            for (int i = 0; i < k; i++) {
                int sign = (i % 2 == 0 ? -1 : 1), move = 0, mn = n + 1, mx = 0;
                for (int j = i; j < n; j += k) {
                    v[j] = a[i] + sign * move++;
                    mx = Math.max(mx, v[j]);
                    mn = Math.min(mn, v[j]);
                }
                if (sign == -1) {
                    if (i + 2 < k) {
                        a[i + 2] = mn - 1;
                    }
                } else {
                    if (i + 2 < k) {
                        a[i + 2] = mx + 1;
                    }
                }
            }
            for (int it : v) {
                System.out.print(it + " ");
            }
            System.out.println();
        }
    }
}
