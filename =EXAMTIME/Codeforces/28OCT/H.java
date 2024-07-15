import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = scanner.nextInt(); // Length of the array a
            int[] a = new int[n];
            Map<Integer, Integer> m = new HashMap<>();

            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
                m.put(a[i], m.getOrDefault(a[i], 0) + 1);
            }

            if (m.size() >= 3) {
                System.out.println("No");
                continue; // Move on to the next test case
            }

            if (m.size() == 1) {
                System.out.println("Yes");
                continue; // Move on to the next test case
            }

            int[] v = new int[2];
            int i = 0;

            for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
                v[i++] = entry.getValue();
            }

            if (Math.abs(v[0] - v[1]) >= 2) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }

        scanner.close();
    }
}
