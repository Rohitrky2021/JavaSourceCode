import java.util.Scanner;

public class E {
    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            long n = scanner.nextLong();
            int k = scanner.nextInt();
            System.out.println(countKGoodSubarrays(n, k));
        }
        scanner.close();
    }

    private static long countKGoodSubarrays(long n, int k) {
        long count = 0;
        long left = 0;

        for (long right = 0; right < n; right++) {
            if (Long.bitCount(right) <= k) {
                count += (right - left + 1);
                count %= MOD;
            } else {
                left = right + 1;
            }
        }

        return count;
    }
}
