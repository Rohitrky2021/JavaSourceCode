 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class EulertTot_Of_Block {
    // Its WilsonsTheorem Using EulerTotient

    public static long xpown(long x, long n, long p) {
        long res = 1;
        while (n > 0) {
            if (n % 2 != 0) {
                res = (res * x) % p;
                n--;
            } else {
                x = (x * x) % p;
                n = n / 2;
            }
        }
        return res % p;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int p = Integer.parseInt(tokenizer.nextToken());

        if (n >= p) {
            System.out.println("0");
            return;
        }

        long ans = p - 1;
        for (int i = n + 1; i <= p - 1; i++) {
            ans = (ans * xpown(i, p - 2, p)) % p;
        }
        System.out.println(ans);
    }
}
