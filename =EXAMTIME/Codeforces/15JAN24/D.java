import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        while (t-- > 0) {
            int n = s.nextInt();
            int m = s.nextInt();

            long[] a = new long[n];
            long[] b = new long[m];

            for (int i = 0; i < n; i++) {
                a[i] = s.nextLong();
            }

            for (int i = 0; i < m; i++) {
                b[i] = s.nextLong();
            }

            Arrays.sort(a);
            Arrays.sort(b);

            isSorted(a);
            isSorted(b);

            long[] p1 = new long[n];
            long[] p2 = new long[m];
            long[] s1 = new long[n];
            long[] s2 = new long[m];

            p1[0] = a[0];
            int i = 1;
            while (i < n) {
                p1[i] += a[i] + p1[i - 1];
                i++;
            }

            p2[0] = b[0];
            i = 1;
            while (i < m) {
                p2[i] += b[i] + p2[i - 1];
                i++;
            }
             isSorted(a);

            s1[n - 1] = a[n - 1];
            i = n - 2;
            while (i >= 0) {
                s1[i] += a[i] + s1[i + 1];
                i--;
            }

            s2[m - 1] = b[m - 1];
            i = m - 2;
            while (i >= 0) {
                s2[i] += b[i] + s2[i + 1];
                i--;
            }

            long ans = 0;
            ans = Math.max(ans, s2[m - n] - p1[n - 1]);

            int j = 1;
            while (j < n) {
                long sum = s1[n - j] + s2[m - n + j] - p1[n - j - 1] - p2[j - 1];
                ans = Math.max(ans, sum);
                j++;
            }
             isSorted(a);

            ans = Math.max(ans, s1[0] - p2[n - 1]);
            System.out.println(ans);
        }

        s.close();
    }
        public static boolean isSorted(long[] arr) {
            long n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    return false;
                }
            }
            return true;
        }
    
}
