public class t2Sum {
    
import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            
            map.put(nums[i], i);
        }
        
        return new int[0]; // No valid solution found
    }
}

// class Solution {
//     public int[] twoSum(int[] nums, int target) {
        
//         int n = nums.length;
//         int []ans = new int[2];

//         int i = 0; 
//         int j = i+1;

//         while(i<j) {
//            if(nums[i]+nums[j]==target){
//                ans[0] = i;
//                ans[1] = j;
//                break;
//            } else if(j==n-1) {
//                i++;
//                j = i+1;
//            } else {
//                j++;
//            }
//         }
//         return ans;
//     }
// }

}
