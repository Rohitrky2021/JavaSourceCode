 
import java.util.Arrays;

public class m {
    public static int findMaxSubarrayLength(int[] nums) {
        Arrays.sort(nums);
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int m = 0;
        int c = 1;

        for (int i = 1; i < nums.length; i++) {
            if (Math.abs(nums[i] - nums[i - 1]) <= 1) {
                c++;
            } else {
                m = Math.max(m, c);
                c = 1;
            }
        }

        m = Math.max(m, c);

        return m;
    }

    public static void main(String[] args) {
        int[] n = {8,5,4,8,5};

        int r = findMaxSubarrayLength(n);

        System.out.println("Maximum subarray length: " + r);
    }
}
