import java.util.HashSet;

public class f {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 6};
        int K = 1;
        int P = 2;
        int count = countDistinctSubarrays(nums, K, P);
        System.out.println("Count of distinct subarrays: " + count);
    }

    public static int countDistinctSubarrays(int[] nums, int K, int P) {
        int count = 0;
        HashSet<String> subarrays = new HashSet<>();

        int left = 0;
        int divisibleCount = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % P == 0) {
                divisibleCount++;
            }

            while (divisibleCount > K) {
                if (nums[left] % P == 0) {
                    divisibleCount--;
                }
                left++;
            }

            // Check if the subarray already exists in the HashSet
            StringBuilder subarray = new StringBuilder();
            for (int i = left; i <= right; i++) {
                subarray.append(nums[i]);
                subarray.append(",");
            }
            String subarrayString = subarray.toString();

            if (!subarrays.contains(subarrayString)) {
                subarrays.add(subarrayString);
                count++;
            }
        }

        return count;
    }
}
