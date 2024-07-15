public class Sumdiff {
    // https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/description/?envType=daily-question&envId=2023-11-25
    public static void main(String[] args) {
        int[] nums = {2, 3, 5};
        int[] result = getAbsoluteSumDifference(nums);
        
        // Print the result
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    static int[] getAbsoluteSumDifference(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i] += Math.abs(nums[i] - nums[j]);
            }
        }

        return result;
    }
}
