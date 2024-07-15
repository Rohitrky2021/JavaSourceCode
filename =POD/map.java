public class map {
    public static long countSubarraysWithMinMax(long[] arr, long x, long y) {
        long count = 0;
        long n = arr.length;
        long minCount = 0;
        long maxCount = 0;
        long start = 0;

        for (long end = 0; end < n; end++) {
            if (arr[(int)end] == x) {
                minCount++;
            }
            if (arr[(int)end] == y) {
                maxCount++;
            }

            while (minCount > 0 && maxCount > 0) {
                count++;

                if (arr[(int)start] == x) {
                    minCount--;
                }
                if (arr[(int)start] == y) {
                    maxCount--;
                }

                start++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        long[] arr = {1, 2, 3, 2};
        long x = 2;
        long y = 3;

        long count = countSubarraysWithMinMax(arr, x, y);
        System.out.println(count);
    }
}
