import java.util.*;
public class usingMAp {

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Create HashMap to store the elements of nums1 and their frequencies
        Map<Integer, Integer> map = new HashMap<>();
        
        // Add elements of nums1 to the HashMap with their frequencies
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // Create a list to store the intersection elements
        List<Integer> intersectionList = new ArrayList<>();
        
        // Find the intersection by checking elements of nums2 in the HashMap
        for (int num : nums2) {
            if (map.containsKey(num)) {
                intersectionList.add(num);
                // Remove the element from the HashMap to avoid duplicates
                map.get(num, map.get(num)- 1) ;
            }
        }
        
        // Convert the intersection list to the final output array
        int[] output = new int[intersectionList.size()];
        for (int i = 0; i < intersectionList.size(); i++) {
            output[i] = intersectionList.get(i);
        }
        
        return output;
    }
}

}
