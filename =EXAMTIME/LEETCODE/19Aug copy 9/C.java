import java.util.HashMap;
import java.util.Map;

class C {
    private Map<String, Integer> memo;

    public int maximumLength(int[] nums, int k) {
        memo = new HashMap<>();
        return helper(nums, k, 0, -1, 0, 0);
    }

    private int helper(int[] nums, int k, int index, int prevSum, int length, int maxLength) {
        if (index == nums.length) {
            return maxLength;
        }

        String key = index + "," + prevSum + "," + length;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Option 1: Do not include the current element in the subsequence
        int exclude = helper(nums, k, index + 1, prevSum, length, maxLength);

        // Option 2: Include the current element in the subsequence
        int include = 0;
        if (prevSum == -1 || (prevSum + nums[index]) % k == 0) {
            include = helper(nums, k, index + 1, (prevSum == -1 ? 0 : (prevSum + nums[index]) % k), length + 1, Math.max(maxLength, length + 1));
        }

        int result = Math.max(exclude, include);
        memo.put(key, result);

        return result;
    }

    public static void main(String[] args) {
        C solution = new C();

        // Test case 1
        int[] nums1 = {1, 2, 3, 10, 2};
        int k1 = 6;
        System.out.println(solution.maximumLength(nums1, k1)); // Expected Output: 3

        // Test case 2
        int[] nums2 = {1, 7, 9};
        int k2 = 10;
        System.out.println(solution.maximumLength(nums2, k2)); // Expected Output: 2

        // Additional Test cases from the prompt
        int[] nums3 = {1, 2, 3, 4, 5};
        int k3 = 2;
        System.out.println(solution.maximumLength(nums3, k3)); // Expected Output: 5

        int[] nums4 = {1, 4, 2, 3, 1, 4};
        int k4 = 3;
        System.out.println(solution.maximumLength(nums4, k4)); // Expected Output: 4
    }
}
