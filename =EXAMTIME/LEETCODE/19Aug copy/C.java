import java.util.HashMap;

class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        if (k <= 0)
            return 1;
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;

        HashMap<Integer, Integer> bitCounts = new HashMap<>();

        int left = 0;
        int curr = 0;

        for (int right = 0; right < n; right++) {
            curr |= nums[right];
            updateBitCounts(nums[right], bitCounts, 1); // Update bit counts for the new element
            while (curr >= k) {
                minLength = Math.min(minLength, right - left + 1);
                updateBitCounts(nums[left], bitCounts, -1); // Update bit counts for the removed element
                curr = convertBitCountsToNumber(bitCounts);
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    private void updateBitCounts(int num, HashMap<Integer, Integer> bitCounts, int delta) {
        for (int i = 0; i < 32; i++) { // Assuming 32-bit integers
            if ((num & (1 << i)) != 0) {
                bitCounts.put(i, bitCounts.getOrDefault(i, 0) + delta);
            }
        }
    }

    private int convertBitCountsToNumber(HashMap<Integer, Integer> bitCounts) {
        int number = 0;
        for (int i = 31; i >= 0; i--) { // Assuming 32-bit integers
            if (bitCounts.containsKey(i) && bitCounts.get(i) > 0) {
                number |= (1 << i); // Set the ith bit in the number
            }
        }
        return number;
    }
}

public class C {
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
