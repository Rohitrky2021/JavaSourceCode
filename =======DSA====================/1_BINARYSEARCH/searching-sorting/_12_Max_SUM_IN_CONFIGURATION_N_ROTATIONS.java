 
public class _12_Max_SUM_IN_CONFIGURATION_N_ROTATIONS {

    public static int maxSum(int[] arr) {
        int n = arr.length;
        int arrSum = 0; // sum of array elements
        int currSum = 0; // sum of i * arr[i]
        
        // Calculate initial sums
        for (int i = 0; i < n; i++) {
            arrSum += arr[i];
            currSum += i * arr[i];
        }
        
        // Initialize maxSum with the initial configuration sum
        int maxSum = currSum;
        
        // Try all rotations one by one and find the maximum rotation sum
        for (int j = 1; j < n; j++) {
            // Calculate next rotation sum using previous sum and array elements
            currSum = currSum + arrSum - n * arr[n - j];
            
            // Update maxSum if the current sum is greater
            if (currSum > maxSum)
                maxSum = currSum;
        }
        
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20}; // Example array
        int maxSum = maxSum(arr);
        System.out.println("Maximum sum after rotation: " + maxSum);
    }
}
