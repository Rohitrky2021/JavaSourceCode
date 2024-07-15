public class e {
    public static void main(String[] args) {
        int[] nums = {3,4,5,6};
        int K = 1;
        int P = 2;
        int count = countDistinctSubarrays(nums, K, P);
        System.out.println("Count of distinct subarrays: " + count);
    }

    public static int countDistinctSubarrays(int[] nums, int K, int P) {
        int n = nums.length;
        int[] prefixDivisibleCount = new int[n + 1];
        int count = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (nums[right] % P == 0) {
                prefixDivisibleCount[right + 1] = prefixDivisibleCount[right] + 1;
            } else {
                prefixDivisibleCount[right + 1] = prefixDivisibleCount[right];
            }

            while (prefixDivisibleCount[right + 1] > K) {
                if (nums[left] % P == 0) {
                    prefixDivisibleCount[left + 1] = prefixDivisibleCount[left] - 1;
                } else {
                    prefixDivisibleCount[left + 1] = prefixDivisibleCount[left];
                }
                left++;
            }

            count += (right - left + 1);
        }

        return count;
    }
}
