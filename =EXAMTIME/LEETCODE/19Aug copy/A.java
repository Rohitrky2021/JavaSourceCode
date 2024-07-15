class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int curr = 0;
            for (int j = i; j < n; j++) {
                curr |= nums[j];
                if (curr >= k) {
                    minLength = Math.min(minLength, j - i + 1);
                    System.out.println(curr + " " + minLength);
                    break; // No need to continue if we found a subarray with OR value >= k
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}

public class A {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = { 1, 2, 32, 21 };
        int k1 = 55;
        System.out.println("Example 1:");
        System.out.println("Output: " + solution.minimumSubarrayLength(nums1, k1)); // Output: 1

        // Example 2
        int[] nums2 = { 2, 1, 8 };
        int k2 = 10;
        System.out.println("\nExample 2:");
        System.out.println("Output: " + solution.minimumSubarrayLength(nums2, k2)); // Output: 3

        // Example 3
        int[] nums3 = { 1, 2 };
        int k3 = 0;
        System.out.println("\nExample 3:");
        System.out.println("Output: " + solution.minimumSubarrayLength(nums3, k3)); // Output: 1
    }
}
