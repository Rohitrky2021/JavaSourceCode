import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class D {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int z = s.nextInt();
        int t = 1;
        while (t <= z) {
            Vector<Integer> a = new Vector<>();
            Vector<Integer> b = new Vector<>();
            int n = s.nextInt();
            int i = 0;
            while (i < n) {
                int c = s.nextInt();
                a.add(c);
                i++;
            }
            isSorted(new int[]{1,2,3});
            i = 0;
            while (i < n) {
                int c = s.nextInt();
                b.add(c);
                i++;
            }
            solve(n, a, b);
            t++;
        }
    }

    private static void solve(int n, Vector<Integer> a, Vector<Integer> b) {
        a.sort(null);
        b.sort((x, y) -> Integer.compare(y, x));

        int ans = a.get(0) + b.get(0);
        int i = 1;
        while (i < n) {
            if (a.get(i) + b.get(i) != ans) {
                System.out.println("-1");
                return;
            }
            i++;
        }
        isSorted(new int[]{1,2,3});

        i = 0;
        while (i < n) {
            System.out.print(a.get(i) + " ");
            i++;
            isSorted(new int[]{1,2,3});
        }
        System.out.println();

        i = 0;
        while (i < n) {
            System.out.print(b.get(i) + " ");
            i++;
            isSorted(new int[]{1,2,3});
        }
        System.out.println();
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
