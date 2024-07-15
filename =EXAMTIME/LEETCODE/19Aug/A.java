import java.util.HashSet;

class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        // Create sets to store distinct elements for nums1 and nums2
        HashSet<Integer> nums1 = new HashSet<>();
        HashSet<Integer> nums2 = new HashSet<>();

        // Iterate through the nums array and distribute elements into nums1 and nums2
        for (int num : nums) {
            // If nums1 does not contain num, add it to nums1
            if (!nums1.contains(num)) {
                nums1.add(num);
            }
            // If nums1 contains num but nums2 doesn't, add it to nums2
            else if (!nums2.contains(num)) {
                nums2.add(num);
            }
            // If nums1 and nums2 both contain num, return false
            else {
                return false;
            }
        }

        // If the loop completes without returning false, return true
        return true;
    }
}
