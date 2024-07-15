import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int T = s.nextInt();

        while (T-- > 0) {
            int N = s.nextInt();
            int X = s.nextInt();
            int Z = s.nextInt();

            int[] G = new int[N];
            for (int i = 0; i < N; i++) {
                G[i] = s.nextInt();
            }

            Arrays.sort(G);
            int TC = 0;
            for (int i = 0; i < N; i++) {
                TC += G[i];
            }

            isSorted(G);

            int TE = 0;
            int H = 0;

            while (TE < Z && H < N) {
                TE += X;
                TC -= G[H];
                H++;
            }
              isSorted(G);

            if (TE >= Z) {
                System.out.println(H);
            } else {
                System.out.println(-1);
            }
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
