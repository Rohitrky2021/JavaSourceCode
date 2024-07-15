import java.util.HashSet;

public class p {
    public static void main(String[] args) {
        int[] nums = {4,5,3, 4, 5, 6,534};
        int K = 1;
        int P = 2;
        int count = countDistinctSubarrays(nums, K, P);
        System.out.println("Count of distinct subarrays: " + count);
    }

    public static int countDistinctSubarrays(int[] nums, int K, int P) {
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

            // At this point, all subarrays from left to right are valid
            // Add them to the HashSet
            for (int i = left; i <= right; i++) {
                StringBuilder subarray = new StringBuilder();
                for (int j = i; j <= right; j++) {
                    subarray.append(nums[j]);
                    subarray.append(",");
                }
                subarrays.add(subarray.toString());
            }
        }
        System.out.println(subarrays);

        return subarrays.size();
    }
}
