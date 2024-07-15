import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class DefKin {
    // https://www.spoj.com/problems/DEFKIN/

    // get the delta x and y from both side
    // then x*y to make this reactange area max we can sort both the x val and y val
    // arr[]--> then take the largest ones

    public static void main(String[] args) {
        int t, w, h, n, dx, dy;

        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        int x[] = new int[40010];
        int y[] = new int[40010];

        while (t-- > 0) {
            w = sc.nextInt();
            h = sc.nextInt();
            n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                x[i] = sc.nextInt();
               
            }
            for (int i = 0; i < n; i++) {
                y[i] = sc.nextInt();
               
            }

            Arrays.sort(x);
            Arrays.sort(y);

              // Corner Cases For the start x Val
            dx = x[0] - 1;
            dy = y[0] - 1;

            for (int i = 1; i < n; i++) {
                dx = Math.max(dx, x[i] - x[i - 1] - 1);
                dy = Math.max(dy, y[i] - y[i - 1] - 1);

            }

            // Corner Cases For the Last x Val
            dx = Math.max(dx, w - x[n - 1]);
            dy = Math.max(dy, h - y[n - 1]);

            System.out.println(dx+" "+dy );

            System.out.println(dx * dy);

        }

    }
}
