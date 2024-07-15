import java.io.*;
import java.util.*;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int testCases = Integer.parseInt(br.readLine());
        while (testCases-- > 0) {
            String[] ab = br.readLine().split(" ");
            long a = Long.parseLong(ab[0]);
            long b = Long.parseLong(ab[1]);

            if (b <= 3) {
                pw.println(-1);
            } else if (a == b) {
                if (a % 2 == 0) {
                    pw.println(2 + " " + (a - 2));
                } else {
                    long i = 2;
                    long p = -1;
                    for (i = 2; i * i <= a; i++) {
                        if (a % i == 0) {
                            p = i;
                            break;
                        }
                    }
                    if (p == -1 || a - p == 0) {
                        pw.println(-1);
                    } else {
                        pw.println(p + " " + (a - p));
                    }
                }
            } else {
                pw.println(2 + " " + (b - (b & 1) - 2));
            }
        }

        pw.close();
    }
}
