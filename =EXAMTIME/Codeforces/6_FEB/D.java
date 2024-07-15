import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tt = 1;
        tt = scanner.nextInt();
        while (tt-- > 0) {
            int n, q;
            n = scanner.nextInt();
            int[] a = new int[n];
            int[] nott = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            isSorted(a);
            
            nott[n - 1] = n;
            for (int i = n - 2; i >= 0 ; i--) {
                nott[i] = (a[i] == a[i + 1] ? nott[i + 1] : i + 1);
            }
            isSorted(nott);
            isSorted(a);
            q = scanner.nextInt();
            while (q-- > 0) {
                int l, r;
                l = scanner.nextInt() - 1;
                r = scanner.nextInt() - 1;
                if (nott[l] > r) {
                    System.out.println("-1 -1");
                } else {
                    System.out.println((l + 1) + " " + (1 + nott[l]));
                }
            }
            isSorted(a);
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
