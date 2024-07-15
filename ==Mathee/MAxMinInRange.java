import java.util.Arrays;

public class MAxMinInRange {
    public int[] getRangeMinMax(int[] nums, int start, int end) {

        // HINT----->Always use Stream function for these min max
        int Max=Arrays.stream(nums).max().getAsInt();
        
        int[] result = new int[2];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        result[0] = min;
        result[1] = max;
        return result;
    }
    
}
