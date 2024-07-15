import java.util.List;

public class sep17 {
        public int countWays(List<Integer> nums) {
            int n = nums.size();
            int greaterCount = 0; // Count of students whose condition requires more students to be selected.
            int lessCount = 0;    // Count of students whose condition requires fewer students to be selected.
    
            for (int i = 0; i < n; i++) {
                if (nums.get(i) > i) {
                    greaterCount++;
                } else if (nums.get(i) < i) {
                    lessCount++;
                }
            }
    
            // Calculate the number of ways to select students to make them happy.
            long result = 1; // Initialize as long to avoid integer overflow.
            int mod = 1_000_000_007; // Modulo value to avoid overflow.
    
            for (int i = 0; i < lessCount; i++) {
                result = (result * greaterCount) % mod;
            }
    
            for (int i = 1; i <= greaterCount; i++) {
                result = (result * i) % mod;
            }
    
            return (int) result;
        }
         
    }
    