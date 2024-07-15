import java.util.Arrays;

class Solution {
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    public static void main(String[] args) {
        int arr[] = {1,2,2,1,2};
        

        System.out.println(majorityElement(arr));
    }
}