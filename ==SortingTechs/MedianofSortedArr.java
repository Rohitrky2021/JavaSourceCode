
import java.util.Scanner;

public class MedianofSortedArr {
    public static int findMedian(int[] arr1, int[] arr2, int n) {
        int lo1 = 0, hi1 = n - 1;
        int lo2 = 0, hi2 = n - 1;

        if (n == 1) {
            return (arr1[0] + arr2[0]) / 2;
        }

        while (true) {
            int m1, m2, median1, median2;
            median1 = arr1[(hi1 + lo1) >> 1];
            median2 = arr2[(hi2 + lo2) >> 1];

            m1 = (hi1 + lo1) >> 1;
            m2 = (hi2 + lo2) >> 1;

            if (hi1 - lo1 == 1) {
                return (Math.max(arr1[lo1], arr2[lo1]) + Math.min(arr1[hi1], arr2[hi2])) / 2;
            }

            if (median1 == median2)
                return median1;

            if (m1 > m2) {
                hi1 = m1;
                lo2 = m2;
            } else {
                hi2 = m2;
                lo1 = m1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        for (int i = 0; i < n; i++) {
            arr1[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            arr2[i] = scanner.nextInt();
        }

        int median = findMedian(arr1, arr2, n);
        System.out.println(median);
        scanner.close();
    }
}
