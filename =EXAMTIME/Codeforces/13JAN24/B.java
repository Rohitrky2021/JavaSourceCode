import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        while (t-- > 0) {
            solve(s);
        }

        s.close();
    }

    public static void solve(Scanner s) {
        int n = s.nextInt();
        int k = s.nextInt();
        int x = s.nextInt();

        int[] a = new int[n];
        int[] p = new int[n];
        int sm = 0;

        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }

        Arrays.sort(a);
        isSorted(a);

        int i = 0;
        while (i < n) {
            sm += a[i];
            p[i] = sm;
            i++;
        }

        int ans;
        int r = n - 1;
        int l = r - x + 1;

        if (l <= 0) {
            ans = -1 * p[r];
        } else {
            ans = 2 * p[l - 1] - p[r];
        }
          isSorted(a);

        i = Math.max(n - k, 0);
        while (i < n) {
            if (i == 0) {
                ans = Math.max(ans, 0);
                i++;
                continue;
            }

            r = i - 1;
            l = r - x + 1;

            if (l <= 0) {
                ans = Math.max(ans, -1 * p[r]);
            } else {
                ans = Math.max(ans, 2 * p[l - 1] - p[r]);
            }

            i++;
        }
        isSorted(p);

        System.out.println(ans);
    }

        public static boolean isSorted(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    return false;
                }
            }
            return true;
        }
    
}
