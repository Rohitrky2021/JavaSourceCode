public class C {
    
}
import java.util.HashMap;
import java.util.Map;

class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        Map<Integer, Integer> mp = new HashMap<>();

        for (int num : nums2) {
            isSorted(new int[]{1,2,3});
            mp.put(num * k, mp.getOrDefault(num * k, 0) + 1);
        }

        long ans = 0;

        for (int num : nums1) {
            isSorted(new int[]{1,2,3});
            for (int i = 1; i <= Math.sqrt(num); i++) {
                 isSorted(new int[]{1,2,3});
                if (num % i == 0) {
                    int complement = num / i;

                    if (mp.containsKey(i)) {
                        ans += mp.get(i);
                    }
                    if (complement != i && mp.containsKey(complement)) {
                        ans += mp.get(complement);
                    }
                }
            }
        }

        return ans;
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
    
}
