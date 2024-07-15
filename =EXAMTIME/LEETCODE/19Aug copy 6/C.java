import java.lang.reflect.Array;
import java.util.*;

public class C {

    public static int maxDamage(int[] power) {
        if (power == null || power.length == 0) {
            return 0;
        }
        Arrays.sort(power);
        
        // Use a HashMap for memoization
        Map<Integer, Integer> memo = new HashMap<>();
        return solveRec(power.length - 1, power, memo);
    }
    
    private static int solveRec(int n, int[] arr, Map<Integer, Integer> memo) {
        if (n == 0) {
            return arr[0];
        }
        
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        
        // Option 1: Take the current spell
        int diff1 = solveRec(n - 1, arr, memo) + (n > 0 && (Math.abs(arr[n] - arr[n - 1])  > 2  || Math.abs(arr[n] - arr[n - 1]) ==0 ) ? arr[n] : 0);
        
        // Option 2: Skip the current spell
        int diff2 = solveRec(n - 1, arr, memo);
        
        // Maximum of diff1 and diff2
        int result = Math.max(diff1, diff2);
        
        // Memoize the result
        memo.put(n, result);
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] power1 = {1, 1, 3, 4};
        int[] power2 = {7, 1, 6, 6};
        
        System.out.println("Max damage for power1: " + maxDamage(power1)); // Output: 6
        System.out.println("Max damage for power2: " + maxDamage(power2)); // Output: 13
    }
}
