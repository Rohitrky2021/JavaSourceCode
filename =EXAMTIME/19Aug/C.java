import java.util.HashMap;
import java.util.Map;

class C {
    public int minChanges(int[] nums, int k) {
        int n = nums.length;
        int changes = 0;
        
        // We need to find the most frequent difference to minimize changes
        Map<Integer, Integer> diffCount = new HashMap<>();
        
        // Count the frequency of each difference
        for (int i = 0; i < n / 2; i++) {
            int diff = Math.abs(nums[i] - nums[n - i - 1]);
            diffCount.put(diff, diffCount.getOrDefault(diff, 0) + 1);
        }
        
        // Find the most frequent difference
        int maxFrequency = 0;
        int maxDiff = 0;
        for (Map.Entry<Integer, Integer> entry : diffCount.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                maxDiff = entry.getKey();
            }
        }
        
        // Calculate the number of changes required
        for (int i = 0; i < n / 2; i++) {
            int diff = Math.abs(nums[i] - nums[n - i - 1]);
            if (diff == maxDiff) {
                continue;
            }
            // If we can change one of the pair to make the difference maxDiff
            if (Math.abs(nums[i] + maxDiff - nums[n - i - 1]) <= k || Math.abs(nums[n - i - 1] + maxDiff - nums[i]) <= k) {
                changes++;
            } else {
                changes += 2;
            }
        }
        
        return changes;
    }

    public static void main(String[] args) {
        C solution = new C();
        
        // Example 1
        int[] nums1 = {1, 0, 1, 2, 4, 3};
        int k1 = 4;
        System.out.println("Example 1 Output: " + solution.minChanges(nums1, k1)); // Expected output: 2
        
        // Example 2
        int[] nums2 = {0, 1, 2, 3, 3, 6, 5, 4};
        int k2 = 6;
        System.out.println("Example 2 Output: " + solution.minChanges(nums2, k2)); // Expected output: 2
    }
}
