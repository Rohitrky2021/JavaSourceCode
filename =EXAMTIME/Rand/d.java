import java.util.HashMap;

public class d {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int K = 2;
        int P = 2;
        int count = countDistinctSubarrays(nums, K, P);
        System.out.println("Count of distinct subarrays: " + count);
    }

    public static int countDistinctSubarrays(int[] nums, int K, int P) {
        int n = nums.length;
        int[] prefixCount = new int[n + 1];
        int count = 0;
        int divisibleCount = 0;

        // Use a HashMap to store the frequency of divisibleCount values
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        frequencyMap.put(0, 1);

        for (int i = 0; i < n; i++) {
            if (nums[i] % P == 0) {
                divisibleCount++;
            }

            // Check if the current divisibleCount is greater than K
            if (divisibleCount > K) {
                // Reduce divisibleCount to the maximum allowed (K)
                divisibleCount--;
            }

            // Update the frequency map
            frequencyMap.put(divisibleCount, frequencyMap.getOrDefault(divisibleCount, 0) + 1);

            // Update the count using the frequency map
            count += frequencyMap.get(divisibleCount - K);
        }

        return count;
    }
}
