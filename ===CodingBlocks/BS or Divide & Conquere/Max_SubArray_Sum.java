 
import java.util.Scanner;

public class Max_SubArray_Sum {

    static long[] arr;

    static long maxCrossing(int l, int m, int r) {
        long sum = 0;
        long leftSum = Long.MIN_VALUE;

        for (int i = m; i >= l; i--) {
            sum += arr[i];
            leftSum = Math.max(leftSum, sum);
        }

        sum = 0;
        long rightSum = Long.MIN_VALUE;

        for (int i = m + 1; i <= r; i++) {
            sum += arr[i];
            rightSum = Math.max(rightSum, sum);
        }

        return leftSum + rightSum;
    }

    static long maxSubarray(int l, int r) {
        if (l == r) {
            return arr[l];
        }

        int m = (l + r) / 2;
        long a = maxSubarray(l, m);
        long b = maxSubarray(m + 1, r);
        long c = maxCrossing(l, m, r);

        return Math.max(Math.max(a, b), c);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            arr = new long[n];

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextLong();
            }

            long ans = maxSubarray(0, n - 1);
            System.out.println(ans);
        }
    }
}
