public class t3SUm {

    // M1------------------------>>
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {

            HashSet<List<Integer>> set = new HashSet<>();
            Arrays.sort(nums);

            for (int i = 0; i < nums.length - 2; i++) {
                int s = i + 1;
                int e = nums.length - 1;

                while (s < e) {
                    int sum = nums[i] + nums[s] + nums[e];
                    if (sum == 0) {
                        set.add(List.of(nums[i], nums[s], nums[e]));
                    }
                    if (sum > 0)
                        e--;
                    else
                        s++;
                }

            }
            return new ArrayList<>(set);
        }
    }

    // M2------------------------>>
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();

            // Sort the array to help in identifying unique triplets
            Arrays.sort(nums);

            for (int i = 0; i < nums.length - 2; i++) {
                if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                    int target = -nums[i];
                    int left = i + 1;
                    int right = nums.length - 1;

                    while (left < right) {
                        int sum = nums[left] + nums[right];

                        if (sum == target) {
                            ans.add(Arrays.asList(nums[i], nums[left], nums[right]));

                            // Skip duplicate elements
                            while (left < right && nums[left] == nums[left + 1])
                                left++;
                            while (left < right && nums[right] == nums[right - 1])
                                right--;

                            left++;
                            right--;
                        } else if (sum < target) {
                            left++;
                        } else {
                            right--;
                        }
                    }
                }
            }

            return ans;
        }
    }

    // M3------------------------>>
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();

            // Sort the array
            Arrays.sort(nums);

            for (int i = 0; i < nums.length - 2; i++) {
                // Skip duplicate elements for i
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                int j = i + 1;
                int k = nums.length - 1;

                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];

                    if (sum == 0) {
                        // Found a triplet with zero sum
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k]));

                        // Skip duplicate elements for j
                        while (j < k && nums[j] == nums[j + 1]) {
                            j++;
                        }

                        // Skip duplicate elements for k
                        while (j < k && nums[k] == nums[k - 1]) {
                            k--;
                        }

                        // Move the pointers
                        j++;
                        k--;
                    } else if (sum < 0) {
                        // Sum is less than zero, increment j to increase the sum
                        j++;
                    } else {
                        // Sum is greater than zero, decrement k to decrease the sum
                        k--;
                    }
                }
            }
            return ans;
        }
    }
}
