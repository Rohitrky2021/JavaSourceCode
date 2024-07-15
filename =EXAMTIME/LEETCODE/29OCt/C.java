public class C {
    
}

class Solution {
    public int minIncrementOperations(int[] nums, int k) {
        int n = nums.length;
        int minOperations = 0;
        
        for (int i = 1; i < n; i++) {
            int diff = Math.max(0, k - nums[i]);
            minOperations += diff;
            nums[i] += diff;
            nums[i - 1] = Math.max(nums[i - 1], nums[i]);
        }
        
        return minOperations;
    }
}



class Solution {
    public int minIncrementOperations(int[] nums, int k) {
        int n = nums.length;
        int minOperations = 0;
        
        for (int windowSize = 3; windowSize <= n; windowSize++) {
            for (int i = 0; i <= n - windowSize; i++) {
                int j = i + windowSize - 1;
                int maxInWindow = getMaxInWindow(nums, i, j);
                if (maxInWindow >= k) {
                    continue;  
                }
                int diff = k - maxInWindow;
                minOperations += diff;
                nums[i] += diff;
            }
        }
        
        return minOperations;
    }
    
     private int getMaxInWindow(int[] nums, int left, int right) {
        int max = nums[left];
        for (int i = left + 1; i <= right; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}

class Solution {
    public int minIncrementOperations(int[] nums, int k) {
    int operations = 0;
    int n = nums.length;

    for (int i = 0; i < n; i++) {
        int diff = k - nums[i]; // Calculate the difference between k and the current element.
        if (diff > 0) {
            nums[i] += diff; // Increment the element to make it greater than or equal to k.
            operations += diff; // Update the total operations.
        }
    }

    return operations;
}

    public int minIncrementOperationsd(int[] nums, int k) {
        int operations = 0;
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            int max = Math.max(nums[i], Math.max(nums[i + 1], nums[i + 2]));
            if (max < k) {
                int increment = k - max;
                nums[i] += increment;
                nums[i + 1] += increment;
                nums[i + 2] += increment;
                operations += increment;
            }
        }

  
        return operations;
    }
}


