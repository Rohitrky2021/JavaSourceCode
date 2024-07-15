import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class c1 {

    private final Scanner sc;

    public c1() throws IOException {
        sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] P = new int[N][2];
        for (int[] p : P) {
            p[0] = sc.nextInt() + 1000;
            p[1] = sc.nextInt() + 1000;
        }
        solve(N, P);
    }

    public void solve(int N, int[][] P) {
        Set<Integer> S = new HashSet<Integer>();
        for (int[] p : P)
            S.add(10000 * p[0] + p[1]);

        int res = 0;
        for (int n = 0; n < N; ++n)
            for (int m = n + 1; m < N; ++m) {
                int xx = P[n][0] + P[m][0], yy = P[n][1] + P[m][1];
                if (xx % 2 == 0 && yy % 2 == 0) {
                    int x = xx / 2, y = yy / 2;
                    if (S.contains(10000 * x + y))
                        ++res;
                }
            }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new c1();
    }
}
