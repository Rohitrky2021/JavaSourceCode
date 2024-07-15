
public class Minsub {
        public static int minSubsequenceLengthd(int[] nums, int k) {
            int n = nums.length;
            int left = 0;
            int minLength = Integer.MAX_VALUE;
            int currentSum = 0;
    
            for (int right = 0; right < n; right++) {
                currentSum += nums[right];
    
                while (currentSum >= k) {
                    minLength = Math.min(minLength, right - left + 1);
                    currentSum -= nums[left];
                    left++;
                }
            }
    
            return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
        }

        public static int minSubsequenceLength(int[] nums, int k) {
            int n = nums.length;
            int left = 0;
            int minLength = Integer.MAX_VALUE;
            int currentSum = 0;
    
            for (int right = 0; right < n; right++) {
                currentSum += nums[right];
    
                while (left <= right && currentSum - nums[left] >= k) {
                    currentSum -= nums[left];
                    left++;
                }
    
                if (currentSum >= k) {
                    minLength = Math.min(minLength, right - left + 1);
                }
            }
    
            return (minLength == Integer.MAX_VALUE) ? 0 : minLength+1;
        }
    
    
        public static void main(String[] args) {
            int[] nums = {7,2,3,4};
            int k = 8;
            int minLength = minSubsequenceLength(nums, k);
            System.out.println("Minimum length of subsequence with sum at least " + k + " is: " + minLength);
        }
    }
    