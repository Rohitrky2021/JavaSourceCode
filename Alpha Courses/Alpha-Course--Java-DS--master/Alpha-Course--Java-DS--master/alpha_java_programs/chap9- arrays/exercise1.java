/*
 * given an integer array nums, return true if any vaue appears at least
 * twice in the array and return false if every element is distince
 */
import java.util.HashSet;
public class exercise1 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5};
        System.out.println(containsDuplicate(nums1));
        int[] nums2 = {1,2,3,4,5,5};
        System.out.println(containsDuplicate(nums2));
    }
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums) {
            if(set.contains(num)) {
                return true;
            }
            else {
                set.add(num);
            }
        }
        return false;
    }
}
