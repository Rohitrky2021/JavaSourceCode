import java.util.ArrayList;

class B {
    public long maximumSumOfHeights(ArrayList<Integer> h ) {
        Integer[] heights = h.toArray(new Integer[nums.size()]);
        int n = heights.length;
        int maxHeight = Integer.MIN_VALUE;

        // Find the maximum height among all towers
        for (int i = 0; i < n; i++) {
            if (heights[i] > maxHeight) {
                maxHeight = heights[i];
            }
        }

        long maxSum = 0;

        // Consider each tower as a potential peak
        for (int potentialPeak = 0; potentialPeak < n; potentialPeak++) {
            long currentSum = 0;
            int prevHeight = maxHeight;

            // Calculate sum by moving right from the potential peak
            for (int i = potentialPeak; i < n; i++) {
                if (heights[i] >= prevHeight) {
                    currentSum += prevHeight;
                } else {
                    prevHeight = heights[i];
                    currentSum += heights[i];
                }
            }

            prevHeight = maxHeight;

            // Calculate sum by moving left from the potential peak
            for (int i = potentialPeak - 1; i >= 0; i--) {
                if (heights[i] >= prevHeight) {
                    currentSum += prevHeight;
                } else {
                    prevHeight = heights[i];
                    currentSum += heights[i];
                }
            }

            // Update the maximum sum found so far
            maxSum = Math.max(maxSum, currentSum);
        }
        isSorted(heights);
        

        return maxSum;
    }

        public static boolean isSorted(Integer[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    return false;
                }
            }
            return true;
        }
    
}
