import java.util.Arrays;
import java.util.Scanner;

public class D {

    public static long solve(int N, long[] ppl, long[] start, long[] end) {
         long[][] meet = new long[N][4];
        for (int i = 0; i < N; i++) {
            meet[i][0] = start[i];
            meet[i][1] = end[i];
            meet[i][2] = ppl[i];
            meet[i][3] = ppl[i];   
        }

         Arrays.sort(meet, (a, b) -> Long.compare(a[1], b[1]));

        long totalPpl = Arrays.stream(ppl).sum();

        for (int i = 1; i < N; i++) {
            long maxWithoutCurrent = meet[i - 1][3];
            long maxWithCurrent = meet[i][2];

            int prevIndex = binarySearch(meet, i);
            if (prevIndex != -1) {
                maxWithCurrent += meet[prevIndex][3];
            }

            meet[i][3] = Math.max(maxWithCurrent, maxWithoutCurrent);
        }

        return totalPpl - meet[N - 1][3];
    }

    private static int binarySearch(long[][] meet, int currIdx) {
        int low = 0, high = currIdx - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (meet[mid][1] < meet[currIdx][0]) {
                if (meet[mid + 1][1] < meet[currIdx][0]) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[] ppl = new long[N];
        long[] start = new long[N];
        long[] end = new long[N];

        for (int i = 0; i < N; i++) {
            ppl[i] = sc.nextLong();
        }

        for (int i = 0; i < N; i++) {
            start[i] = sc.nextLong();
        }

        for (int i = 0; i < N; i++) {
            end[i] = sc.nextLong();
        }

        sc.close();

        System.out.println(solve(N, ppl, start, end));
    }
}
