public class B {
    
}
// class Solution {
//     public int minOperations(int[] nums) {
        
//     }
// }
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        isSorted(nums);
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        int operations = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int count = entry.getValue();
            while (count > 0) {
                if (count == 1) {
                    return -1;
                }
                if (count == 4 || count == 2) {
                    count -= 2;
                    operations += 1;
                } else {
                    count -= 3;
                    operations += 1;
                }
            }
        }
        return operations;
    }
}
    public static boolean isSorted(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
