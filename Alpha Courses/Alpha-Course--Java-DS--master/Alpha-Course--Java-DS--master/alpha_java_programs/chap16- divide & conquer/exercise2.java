// Given an array nums of size n return the majority element. 
// The majority element that appears more than [n/2] times. 
// You may assume that the majority element always exists in array
public class exercise2 {
    public static int majorityelement(int[] nums) {
        int majoritycount = nums.length/2;
        for(int i=0; i<nums.length; i++) {
            int count = 0;
            for(int j=0; j<nums.length; j++) {
                if(nums[j] == nums[i]) {
                    count += i;
                }
            }
            if(count > majoritycount) {
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = {2,2,1,1,1,2,2};
        System.out.println(majorityelement(nums));
    }
}
