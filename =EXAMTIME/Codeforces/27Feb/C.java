import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            long l = scanner.nextLong();

            HashSet<Long> set = new HashSet<>();

            for (int i = 0; i < 31; i++) {

                long m = (long) Math.pow(a, i);
                for (int j = 0; j < 31; j++) {
                    long n = (long) Math.pow(b, j);
                    long p = m * n;
                    if (l % p == 0) {
                        set.add(l / p);
                    }

                    if (n > l) {
                        break;
                    }
                }
                if (m > l) {
                    break;
                }

            }

            System.out.println(set.size());
        }
    }

}
