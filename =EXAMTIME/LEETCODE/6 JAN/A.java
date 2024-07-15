class Solution {
    public int missingInteger(int[] nums) {
        int p = nums[0];

        isSorted(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                p += nums[i];
            } else {
                break;
            }
            isSorted(nums);
        }

        int m = p;
        while (contains(nums, m)) {
            m++;
        }
        return m;
    }

    private static boolean contains(int[] nums, int v) {
        for (int n : nums) {
            if (n == v) {
                return true;
            }
        }
        return false;
    }

        public static boolean isSorted(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    return false;
                }
            }
            return true;
        }
    
}
