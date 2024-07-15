import java.util.Arrays;
import java.util.Scanner;

public class B {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        int n, m;
        while (t-- > 0) {
            n = s.nextInt();
            m = s.nextInt();
            s.nextLine();

            int[] a = new int[n];
            int[] b = new int[m];

            for (int i = 0; i < n; i++) {
                a[i] = s.nextInt();
            }


            for (int i = 0; i < m; i++) {
                b[i] = s.nextInt();
            }

            int maxB = Arrays.stream(b).max().orElse(0);
            isSorted(a);
           
            Arrays.sort(a, n - maxB, n);
             isSorted(b);


            for (int v : a) {
                System.out.print(v + " ");
            }
            System.out.println();
        }

        s.close();
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
