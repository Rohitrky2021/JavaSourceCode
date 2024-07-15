import java.util.*;

public class E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // number of test cases
        while (t-- > 0) {
            int n = scanner.nextInt(); // number of cities
            int m = scanner.nextInt(); // number of days
            int k = scanner.nextInt(); // number of days of rain to prevent

            List<Integer> rain = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                rain.add(l);
                rain.add(r);
            }

            int[] count = new int[n * 2 + 5];
            for (int i = 0; i < rain.size(); i += 2) {
                count[rain.get(i)]++;
                count[rain.get(i + 1) + 1]--;
            }

            for (int i = 1; i < count.length; i++) {
                count[i] += count[i - 1];
            }

            int maxDry = 0;
            for (int i = 1; i <= n; i++) {
                int dryCities = 0;
                for (int j = i; j <= n; j++) {
                    if (count[j * 2 - 1] < k) {
                        dryCities++;
                    }
                }
                maxDry = Math.max(maxDry, dryCities);
            }

            System.out.println(maxDry);
        }
    }
}
