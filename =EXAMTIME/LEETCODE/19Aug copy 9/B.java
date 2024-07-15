import java.util.ArrayList;
import java.util.List;

class Solution {
    
    private int trial(List<Integer> nums, int rem, int k) {
        int maxLen = 0;
        
        for (int start = 0; start < nums.size(); start++) {
            List<Integer> sub = new ArrayList<>();
            sub.add(nums.get(start));
            
            for (int i = start + 1; i < nums.size(); i++) {
                int i1 = nums.get(i);
                if ((sub.get(sub.size() - 1) + i1) % k == rem) {
                    sub.add(i1);
                }
            }
            maxLen = Math.max(maxLen, sub.size());
        }
        return maxLen;
    }
    
    public int maximumLength(List<Integer> nums, int k) {
        int maximum = 0;
        
        for (int i = 0; i < k; i++) {
            maximum = Math.max(trial(nums, i, k), maximum);
        }
        
        return maximum;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> nums = List.of(1, 7, 9);
        int k = 10;
        System.out.println(solution.maximumLength(nums, k));  // Output: 2
    }
}
