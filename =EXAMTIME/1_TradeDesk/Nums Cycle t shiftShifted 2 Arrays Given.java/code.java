import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code {
    public List<Integer> calculateMinDifference(List<Integer> nums1, List<Integer> nums2) {
        int n = nums1.size();
        List<Integer> result = new ArrayList<>();

        for (int t = 0; t < n; ++t) {
            List<Integer> numsShifted = new ArrayList<>(n);
            for (int i = 0; i < n; ++i) {
                numsShifted.add(nums1.get((i + t) % n));
            }

            int sum = 0;
            for (int i = 0; i < n; ++i) {
                sum += Math.abs(numsShifted.get(i) - nums2.get(i));
            }

            result.add(sum);
        }

        result.sort(null); // Sort in ascending order
        return result;
    }

    public static void main(String[] args) {
        // Example usage
        List<Integer> nums1 = Arrays.asList(1, 2, 3);
        List<Integer> nums2 = Arrays.asList(4, 5, 6);

        code solution = new code();
        List<Integer> result = solution.calculateMinDifference(nums1, nums2);

        System.out.println(result);
    }
}
