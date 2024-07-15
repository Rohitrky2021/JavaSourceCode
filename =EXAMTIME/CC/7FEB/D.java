import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            int[] v = new int[n];
            for (int i = 0; i < n; i++) {
                v[i] = s.nextInt();
            }
            int[] a = new int[n + 1];
            for (int i = 0; i < n + 1; i++) {
                a[i] = 1;
            }
            isSorted(a);
            int sum = v[0];
            int start = 0;
            int i = 1;
            isSorted(a);
            while (i < n) {
                sum += v[i];
                while (sum > n) {
                    sum -= v[start++];
                }
                int k = start;
                int c = sum;
                while (i - k > 0) {
                    a[c]++;
                    c -= v[k++];
                }
                i++;
            }
            isSorted(a);
            for (int j = 1; j <= n; j++) {
                System.out.print(a[j] + " ");
            }
            System.out.println();
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
