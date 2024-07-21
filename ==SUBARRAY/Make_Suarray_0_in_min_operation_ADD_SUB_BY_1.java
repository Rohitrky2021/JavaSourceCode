import java.util.*;
public class Make_Suarray_0_in_min_operation_ADD_SUB_BY_1 {
    
}

class D {
    public long minimumOperations(int[] nums, int[] tar) {
        int n = nums.length;
        int[] t = new int[n];
        
        // Calculate the difference array
        for (int i = 0; i < n; i++) {
            t[i] = tar[i] - nums[i];
        }
        
        int pos = 0;
        long m = 0, ans = 0;
        ans = Math.abs(t[0]);
        m = ans;
        
        // Determine the initial sign of the first element
        if (t[0] >= 0) pos = 1;
        
        for (int i = 1; i < n; i++) {
            // Handle sign changes
            if (t[i] < 0 && pos == 1) { //My previous was +ve & I'm Negative 
                ans += Math.abs(t[i]);
                m = Math.abs(t[i]);
                pos = 0;
                continue;
            }
            if (t[i] >= 0 && pos == 0) { //My previous was -ve & I'm +ve 
                ans += Math.abs(t[i]);
                m = Math.abs(t[i]);
                pos = 1;
                continue;
            }
            // Handle no sign change
            if (m >= Math.abs(t[i])) {
                m = Math.abs(t[i]);
                continue;
            } else {
                ans += Math.abs(t[i]) - m;
                m = Math.abs(t[i]);
            }
        }
        
        return ans;
    }

    // Driver Code
    public static void main(String[] args) {
        D solution = new D();
        int[] nums = {1, -2, 2};
        int[] tar = {2, 1, 4};
        System.out.println(solution.minimumOperations(nums, tar));  // Output should be 5
    }
}
