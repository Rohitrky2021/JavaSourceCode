import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t > 0) {
            g(s);
            t--;
        }
    }

    public static void g(Scanner s) {
        int n = s.nextInt();
        int m = s.nextInt();

        int[] x = new int[n];
        int[] y = new int[m];

        for (int i = 0; i < n; i++) {
            x[i] = s.nextInt();
        }

        for (int i = 0; i < m; i++) {
            y[i] = s.nextInt();
        }

        Arrays.sort(y);
        int p = 0;

        for (int i = 0; i < n; i++) {
            while (p < m && y[p] >= x[i]) {
                System.out.print(y[p] + " ");
                p++;
            }
            System.out.print(x[i] + " ");
        }

        while (p < m) {
            System.out.print(y[p] + " ");
            p++;
        }
        System.out.println();
    }
}
