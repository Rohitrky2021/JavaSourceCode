import java.util.Scanner;
import java.util.ArrayList;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        ArrayList<Long> w = new ArrayList<>();

        for (int i = 0; i < N; ++i) {
            w.add(scanner.nextLong());
        }

        ArrayList<Long> s = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            s.add(15L);
        }

        for (int i = N - 2; i >= 0; --i) {
            for (int j = i + 1; j < N; ++j) {
                if (w.get(i) < w.get(j)) {
                    s.set(i, 10L);
                    for (int k = j + 1; k < N; ++k) {
                        if (w.get(j) > w.get(k)) {
                            s.set(i, 5L);
                            break;
                        }
                    }
                    break;
                }
            }
        }

        long g = 0;
        for (long sc : s) {
            g += sc;
        }

        System.out.println(g);

        scanner.close();
    }
}
