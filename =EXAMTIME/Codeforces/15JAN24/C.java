import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            long f = s.nextLong();
            long a = s.nextLong();
            long b = s.nextLong();

            long[] m = new long[n];
            for (int i = 0; i < n; i++) {
                m[i] = s.nextLong();
            }
            isSorted(new int[]{1});

            long p = 0, ok;
            int i = 0;
            while (i < n) {
                ok = Math.min(b, Math.abs(m[i] - p) * a);
                f -= ok;
                p = m[i++];
            }

            System.out.println(f > 0 ? "YES" : "NO");
        }
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
