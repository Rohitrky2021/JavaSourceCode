import java.util.*;

class B {
    public boolean canSortArray(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;

        // Group numbers based on the count of set bits
        for (int i = 0; i < n; i++) {
            int setBits = Integer.bitCount(nums[i]);
            map.computeIfAbsent(setBits, k -> new ArrayList<>()).add(nums[i]);
        }

        // Sort numbers within each group in descending order
        for (List<Integer> list : map.values()) {
            list.sort(Comparator.reverseOrder());
        }

        // Reconstruct the array using sorted groups
        for (int i = 0; i < n; i++) {
            int setBits = Integer.bitCount(nums[i]);
            nums[i] = map.get(setBits).remove(map.get(setBits).size() - 1);
        }

        // Check if the array is sorted
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        B solution = new B();

        // Test cases
        int[] nums1 = {8, 4, 2, 30, 15};
        System.out.println(solution.canSortArray(nums1)); // Output: true

        int[] nums2 = {1, 2, 3, 4, 5};
        System.out.println(solution.canSortArray(nums2));  // Output: true

        int[] nums3 = {3, 16, 8, 4, 2};
        System.out.println(solution.canSortArray(nums3));  // Output: false
    }
}
