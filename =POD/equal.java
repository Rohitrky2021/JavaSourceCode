import java.util.Arrays;
import java.util.stream.IntStream;

public class equal {
    public static int minOperationsToEqualize(int[] nums) {
        int operations = 0;

        while (!areAllEqual(nums)) {
            int maxIndex = findMaxIndex(nums);
            int largest = nums[maxIndex];
            int nextLargest = findNextLargest(nums, largest);

            nums[maxIndex] = nextLargest;
            operations++;
        }

        return operations;
    }

    private static boolean areAllEqual(int[] nums) {
        return Arrays.stream(nums).distinct().count() == 1;
    }

    private static int findMaxIndex(int[] nums) {
        return IntStream.range(0, nums.length).reduce((i, j) -> nums[i] >= nums[j] ? i : j).orElse(-1);
    }

    private static int findNextLargest(int[] nums, int largest) {
        return Arrays.stream(nums)
                .filter(e -> e < largest)
                .reduce((a, b) -> a > b ? a : b)
                .orElse(Integer.MIN_VALUE);
    }

    public static void main(String[] args) {
        int[] nums1 = {5, 1, 3};
        System.out.println("Example 1: " + minOperationsToEqualize(nums1)); // Output: 3

        int[] nums2 = {1, 1, 1};
        System.out.println("Example 2: " + minOperationsToEqualize(nums2)); // Output: 0

        int[] nums3 = {1, 1, 2, 2, 3};
        System.out.println("Example 3: " + minOperationsToEqualize(nums3)); // Output: 4
    }
}
