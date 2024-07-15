import java.util.*;

public class _10_May_Kth_Min_Frac {
    /**
     * Approach 1: Brute Force (Max Heap)
     * ? Complexity
     ** Time complexity: O(n * n * logk)
     ** Space complexity: O(n)
     */

    class Solution1 {
        public int[] kthSmallestPrimeFraction(int[] arr, int k) {
            int n = arr.length;
            if (n == 2)
                return new int[] { arr[0], arr[1] };

            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> (double) a[0] / a[1]));

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    pq.offer(new int[] { arr[i], arr[j] });
                }
            }

            while (--k > 0) {
                pq.poll();
            }

            return pq.poll();
        }
    }

    /**
     * Approach 2: Modified above Brute Force --Better TC than above
     * ? Complexity
     ** Time complexity: O(n * n * logk)
     ** Space complexity: O(k)
     */

    class Solution2 {
        public int[] kthSmallestPrimeFraction(int[] arr, int k) {
            PriorityQueue<double[]> maxHeap = new PriorityQueue<>(k, (a, b) -> Double.compare(b[0], a[0]));
            int n = arr.length;

            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    maxHeap.offer(new double[] { (double) arr[i] / arr[j], arr[i], arr[j] });

                    if (maxHeap.size() > k) {
                        maxHeap.poll();
                    }
                }
            }

            double[] res = maxHeap.poll();
            return new int[] { (int) res[1], (int) res[2] };
        }
    }

    /**
     * Approach 3: Best (Binary Search)
     * ? Complexity
     ** Time complexity: O(nlogn)
     ** Space complexity: O(1)
     */

    class Solution3 {
        public int[] kthSmallestPrimeFraction(int[] arr, int k) {
            int n = arr.length;
            double left = 0, right = 1, mid;
            int[] res = new int[2];

            while (left <= right) {
                mid = left + (right - left) / 2;
                int j = 1, total = 0, num = 0, den = 0;
                double maxFrac = 0;
                for (int i = 0; i < n; ++i) {
                    while (j < n && arr[i] >= arr[j] * mid) {
                        ++j;
                    }

                    total += n - j;

                    if (j < n && maxFrac < arr[i] * 1.0 / arr[j]) {
                        maxFrac = arr[i] * 1.0 / arr[j];
                        num = i;
                        den = j;
                    }
                }
                if (total == k) {
                    res[0] = arr[num];
                    res[1] = arr[den];
                    break;
                }

                if (total > k) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            return res;
        }
    }
}