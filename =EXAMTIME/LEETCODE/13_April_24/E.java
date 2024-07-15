import java.util.ArrayDeque;
import java.util.Deque;

 class Solution {
    public long numberOfSubarrays(int[] nums) {
        int n = nums.length;
        long count = 0;
        int maxNum = Integer.MIN_VALUE;
        Deque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] > maxNum) {
                maxNum = nums[i];
                queue.clear();
            }

            while (!queue.isEmpty() && nums[i] >= queue.peekFirst()[0]) {
                int[] pair = queue.pollFirst();
                int prevIndex = pair[1];
                count += (long) (i - prevIndex) * (prevIndex - (queue.isEmpty() ? -1 : queue.peekFirst()[1]));
            }

            queue.offerFirst(new int[]{nums[i], i});
        }

        while (!queue.isEmpty()) {
            int[] pair = queue.pollFirst();
            int prevIndex = pair[1];
            count += (long) (n - prevIndex) * (prevIndex - (queue.isEmpty() ? -1 : queue.peekFirst()[1]));
        }

        return count;
    }
}


public class E {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] nums1 = {1, 4, 3, 3, 2};
        System.out.println("Output for nums1: " + solution.numberOfSubarrays(nums1)); // Output: 6

        int[] nums2 = {3, 3, 3};
        System.out.println("Output for nums2: " + solution.numberOfSubarrays(nums2)); // Output: 6

        int[] nums3 = {1};
        System.out.println("Output for nums3: " + solution.numberOfSubarrays(nums3)); // Output: 1
    }
}
