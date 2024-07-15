import java.util.*;

public class max {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6 };
        int k = 1;

        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            indexMap.put(nums[i], i);
        }

        HashMap<Integer, Integer> absDiffMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indexMap.containsKey(nums[i] - k)) {
                absDiffMap.put(i, indexMap.get(nums[i] - k));
            }
            if (indexMap.containsKey(nums[i] + k)) {
                absDiffMap.put(i, indexMap.get(nums[i] + k));
            }
        }

        long sum = calculatePairSum(nums, absDiffMap);
        System.out.println("Sum of (i, j) pairs: " + sum);
    }

    public static long calculatePairSum(int[] nums, HashMap<Integer, Integer> absDiffMap) {
        long sum = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> entry : absDiffMap.entrySet()) {
            int i = entry.getKey();
            int j = entry.getValue();
            sum = Math.max(prefixSum(nums, i, j), sum);
        }

        return sum;
    }

    public static long prefixSum(int[] nums, int i, int j) {
        long[] prefixSum = new long[nums.length + 1];
        prefixSum[0] = 0;
        for (int k = 1; k <= nums.length; k++) {
            prefixSum[k] = prefixSum[k - 1] + nums[k - 1];
        }
        return prefixSum[j + 1] - prefixSum[i];
    }
}
