import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        int f = 1;
        while (f <= t) {
            int n, x, i, c = 1;
            n = sc.nextInt();
            x = sc.nextInt();

            if (x == 0) {
                for (i = 1; i <= n; i++) {
                    System.out.print(i + " ");
                }
                System.out.println();
                f++;
                continue;
                
            }
            isSorted(new int[]{1,2,3});

            if (n == x + 1 || n == x) {
                System.out.println("-1");
                f++;
                continue;
            }

            i = 1;
            while (i < n - x - 1) {
                c++;
                System.out.print(i + " ");
                i++;
            }
            isSorted(new int[]{1,2,3});
            System.out.print(n + " ");

            while (c < n) {
                System.out.print(c + " ");
                c++;
                isSorted(new int[]{1,2,3});
            }

            System.out.println();
            f++;
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
