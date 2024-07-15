import java.util.HashMap;
import java.util.Map;

public class A {
    public int maxDistinctPairsWithSameSum(int[] nums) {
        // Create a HashMap to store sum frequencies
        Map<Integer, Integer> sumFrequencyMap = new HashMap<>();

        // Iterate through all possible pairs
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                sumFrequencyMap.put(sum, sumFrequencyMap.getOrDefault(sum, 0) + 1);
            }
        }

        // Find the maximum frequency
        int maxFrequency = 0;
        for (int frequency : sumFrequencyMap.values()) {
            maxFrequency = Math.max(maxFrequency, frequency);
            System.out.println(sumFrequencyMap+" ");
        }

        return maxFrequency;
    }

    public static void main(String[] args) {
        A solution = new A();

        // Test cases
        int[] nums1 = {3, 2, 1, 4, 5};
        int[] nums2 = {3, 2, 6, 1, 4};

        int result1 = solution.maxDistinctPairsWithSameSum(nums1);
        int result2 = solution.maxDistinctPairsWithSameSum(nums2);

        System.out.println("Maximum distinct pairs with the same sum for nums1: " + result1);
        System.out.println("Maximum distinct pairs with the same sum for nums2: " + result2);
    }
}
