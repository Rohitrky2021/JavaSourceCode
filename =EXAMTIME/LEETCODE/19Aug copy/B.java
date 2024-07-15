class Solution {
    public int minimumLevels(int[] possible) {
        int n = possible.length;
        int[] prefixSum = new int[n + 1];
        
        // Calculating prefix sums to get points for each player at each level
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + (possible[i] == 1 ? 1 : -1);
        }
        
        // If Danielchandg plays all levels, he will get points from 0 to n - 1
        int maxPointsDanielchandg = prefixSum[n];
        
        // If Danielchandg plays only first i levels and Bob plays the rest, calculate points
        int minLevelsToBeatBob = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int pointsDanielchandg = prefixSum[i];
            int pointsBob = prefixSum[n] - prefixSum[i];
            if (pointsDanielchandg > pointsBob) {
                // Danielchandg can beat Bob
                minLevelsToBeatBob = Math.min(minLevelsToBeatBob, i + 1);
            }
        }
        
        return minLevelsToBeatBob == Integer.MAX_VALUE ? -1 : minLevelsToBeatBob;
    }
}

public class B {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example test cases
        int[] possible1 = {1, 0, 1, 0};
        int[] possible2 = {1, 1, 1, 1, 1};
        int[] possible3 = {0, 0};

        System.out.println("Example 1: " + solution.minimumLevels(possible1)); // Output: 1
        System.out.println("Example 2: " + solution.minimumLevels(possible2)); // Output: 3
        System.out.println("Example 3: " + solution.minimumLevels(possible3)); // Output: -1
    }
}
