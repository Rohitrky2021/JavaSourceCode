import java.util.*;

public class F {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n - 1];
        for (int i = 0; i < n - 1; i++) {
            a[i] = sc.nextLong();
        }
        sc.close();

        long[] b = new long[n];
        b[0] = 0;

        for (int i = 1; i < n - 1; i++) {
            b[i] = a[i - 1] ^ b[i - 1];
        }

        // Calculate the missing element
        long missing = 0;
        for (int i = 0; i < n; i++) {
            missing ^= b[i];
            missing ^= (i + 1);
        }
        b[n - 1] = missing;

        // Output the constructed array b
        for (int i = 0; i < n; i++) {
            System.out.print(b[i] + " ");
        }
    }
}
