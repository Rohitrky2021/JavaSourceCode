/*
 * Given an integer array nums, return all the triplets [nums[i], nums[j],  
 * nums[k]] such that i != j, i != k, 
 * and j != k, and nums[i] + nums[j] + nums[k] == 0.
 */
import java.util.ArrayList;
import java.util.List;

public class exercise5 {
    /**
     * @param nums
     * @return
     */
    public static List<List<Integer>> findTriplets(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        // sort the array
        java.util.Arrays.sort(nums);
        // fix the first element and find the other two
        for (int i = 0; i < nums.length - 2; i++) {
            // to avoid duplicates, we can skip the element if it is the same as the previous one
            if (i == 0 || nums[i] != nums[i - 1]) {
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum == 0) {
                        // found a triplet
                        triplets.add(java.util.Arrays.asList(nums[i], nums[left], nums[right]));
                        // skip the duplicate elements
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        // move the pointers inward
                        left++;
                        right--;
                    } else if (sum < 0) {
                        // move the left pointer inward
                        left++;
                    } else {
                        // move the right pointer inward
                        right--;
                    }
                }
            }
        }
        return triplets;
    }
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> triplets = findTriplets(nums);
        System.out.println(triplets);
    }
}
