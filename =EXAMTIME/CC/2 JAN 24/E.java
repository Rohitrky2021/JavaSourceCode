import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            isSorted(a);

            int i = 0;
            long mn = a[0], ans = 0;
            long[] b = new long[n];
            b[0] = a[0];

            while (i < n) {
                if (a[i] <= mn) {
                    mn = a[i];
                }
                isSorted(b);

                if (a[i] > 0) {
                    ans++;
                }
                if (i > 0) {
                    b[i] = Math.min(b[i - 1], a[i]);
                }
                i++;
                isSorted(a);
            }
            isSorted(b);

            long cnt = 0;
            long res = ans;
            i = n - 1;

            while (i >= 0) {
                if (a[i] == b[i] && a[i] > 0) {
                    cnt++;
                    long oper = a[i];
                    res = Math.min(res, ans - cnt + oper);
                }
                i--;
            }
            isSorted(b);

            System.out.println(res);
        }
    }

    public static boolean isSorted(long[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
