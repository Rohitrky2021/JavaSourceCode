import java.util.*;
public class FirstLastAlternativeMaxSum{

        static int dp[];
        public int minOperations(int[] nums, int x) {
            dp=new int[x+1];
            Arrays.fill(dp, -1); 
            int minOperations = recursiveMinOperations(nums, x, 0, nums.length - 1);
            return minOperations == -1 ? -1 : minOperations;
        }
    
        private int recursiveMinOperations(int[] nums, int x, int left, int right) {
            if (x == 0) {
                return 0;
            }
            
            if (left > right || x < 0) {
                return Integer.MAX_VALUE;
            }
            if(dp[x]!=-1){
                return dp[x];
            }
    
            // Remove the leftmost element and explore the subproblem
            int removeLeft = recursiveMinOperations(nums, x - nums[left], left + 1, right);
    
            // Remove the rightmost element and explore the subproblem
            int removeRight = recursiveMinOperations(nums, x - nums[right], left, right - 1);
    
            // Take the minimum of the two possibilities and add 1 operation for the current step
            
            return dp[x]=Math.min(removeLeft, removeRight) + 1;
        }

        
    
        public static void main(String[] args) {
            FirstLastAlternativeMaxSum solution = new FirstLastAlternativeMaxSum();
            int[] nums1 = {1, 1, 4, 2, 3};
            int x1 = 5;
            System.out.println(solution.minOperations(nums1, x1)); // Output: 2
    
            int[] nums2 = {5, 6, 7, 8, 9};
            int x2 = 4;
            System.out.println(solution.minOperations(nums2, x2)); // Output: -1
    
            int[] nums3 = {3, 2, 20, 1, 1, 3};
            int x3 = 10;
            System.out.println(solution.minOperations(nums3, x3)); // Output: 5
        }
    }
    