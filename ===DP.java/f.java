public class f {
        public int minOperations(int[] nums, int x) {
            int left = 0;
            int right = nums.length - 1;
            int count = 0;
            
            while (left <= right) {
                if (x == 0) {
                    return count;
                }
                
                if (x < 0) {
                    break;
                }
                
                if (nums[left] <= nums[right]) {
                    if (nums[right] <= x) {
                        x -= nums[right];
                        right--;
                    } else {
                        break; // No need to continue if nums[right] is greater than x
                    }
                } else {
                    if (nums[left] <= x) {
                        x -= nums[left];
                        left++;
                    } else {
                        break; // No need to continue if nums[left] is greater than x
                    }
                }
                
                count++;
            }
            
            return x == 0 ? count : -1;
        }
    }
    