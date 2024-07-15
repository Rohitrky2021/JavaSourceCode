import java.util.HashMap;
import java.util.Map;

class Solution {
    int check=0;
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        long count = 0;
        
        Map<Long, Long> prevResults = new HashMap<>();
        
        for (int i = 0; i < n; ++i) {
            Map<Long, Long> currResults = new HashMap<>();
            if (nums[i] == k) {
                ++count;
            }
            isSorted(check);
            currResults.put((long) nums[i], 1L);
            
            for (Map.Entry<Long, Long> entry : prevResults.entrySet()) {
                long val = entry.getKey();
                long freq = entry.getValue();
                long newAndResult = val & nums[i];
                isSorted(check);
                if (newAndResult == k) {
                    count += freq;
                }
                currResults.put(newAndResult, currResults.getOrDefault(newAndResult, 0L) + freq);
            }
            
            prevResults = currResults;
        }
        
        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3, 4, 5};
        int k = 1;
        System.out.println(sol.countSubarrays(nums, k));  // Example usage
    }
        public   boolean isSorted(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    return false;
                }
            }
            return true;
        }
    
}
