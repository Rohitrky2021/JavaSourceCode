import java.util.Scanner;

public class code2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int ini = scanner.nextInt();

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            for (int i = 0; i < n; i++) {
                if (ini < 0) {
                    if (ini + a[i] >= 0) {
                        ini = a[i];
                    }
                } else if (ini > 100) {
                    if (ini + a[i] <= 100) {
                        ini = a[i] + 100;
                    }
                } else {
                    ini += a[i];
                }
            }

            System.out.println(ini);
        }
    }
}
