public class Fixed&VariableSizeBothWindow {
class Solution {
        public double findMaxAverage(int[] nums, int k) {
            final double EPSILON = 0.00001;
            double min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int num : nums) {
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
            double prevMid = max;
            double error = Integer.MAX_VALUE;
            while (error > EPSILON) {
                double mid = (min + max) / 2;
                if (exist(nums, mid, k))
                    min = mid;
                else
                    max = mid;
                error = Math.abs(mid - prevMid);
                prevMid = mid;
            }
            return min;
        }
    
        public boolean exist(int[] nums, double mid, int k) {
            double sum = 0, prefixSum = 0, minSum = 0;
            for (int i = 0; i < k; i++)
                sum += nums[i] - mid;
            if (sum >= 0)
                return true;
            int length = nums.length;
            for (int i = k; i < length; i++) {
                sum += nums[i] - mid;
                prefixSum += nums[i - k] - mid;
                minSum = Math.min(minSum, prefixSum);
                if (sum >= minSum)
                    return true;
            }
            return false;
        }
    }


    class Solution {
        public double findMaxAverage(int[] nums, int k) {
          final double kErr = 1e-5;
          double l = (double) Arrays.stream(nums).min().getAsInt();
          double r = (double) Arrays.stream(nums).max().getAsInt();
      
          while (r - l > kErr) {
            final double m = (l + r) / 2;
            if (check(nums, k, m))
              l = m;
            else
              r = m;
          }
      
          return l;
        }
      
        // Returns true if there's a subarray with length >= k and average sum >= m.
        private boolean check(int[] nums, int k, double m) {
          double sum = 0;
          double prevSum = 0;
          double minPrevSum = 0;
      
          for (int i = 0; i < nums.length; ++i) {
            // -m for each num so that we can check if the sum of the subarray >= 0
            sum += nums[i] - m;
            if (i >= k) {
              prevSum += nums[i - k] - m;
              minPrevSum = Math.min(minPrevSum, prevSum);
            }
            // If sum - minPrevSum >= 0,
            // we know there's a subarray with length >= k and average sum >= m
            if (i + 1 >= k && sum >= minPrevSum)
              return true;
          }
      
          return false;
        }
      }
      