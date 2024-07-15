public class F {
    public int minLevelsToGainMorePoints(int[] possible) {
        int n = possible.length;
        
        // Count the total number of possible levels
        int totalPossibleLevels = 0;
        for (int i = 0; i < n; i++) {
            totalPossibleLevels += possible[i];
        }
        
        // If there are no possible levels, return -1
        if (totalPossibleLevels == 0) {
            return -1;
        }
        
        // Initialize variables to keep track of Danielchandg's points and Bob's points
        int danielPoints = 0, bobPoints = 0;
        int minLevelsToGainMorePoints = Integer.MAX_VALUE;
        
        // Loop through all possible levels that Danielchandg can play
        for (int i = 0; i < n - 1; i++) {
            if (possible[i] == 1) {
                // Danielchandg plays level i
                danielPoints++;
                // Bob plays the remaining levels
                bobPoints = totalPossibleLevels - danielPoints;
                // Calculate the difference in points between Danielchandg and Bob
                int diff = danielPoints - bobPoints;
                // Update minLevelsToGainMorePoints if Danielchandg has more points
                // System.out.println(danielPoints+" "+diff);
                if (diff >= 0) {
                    minLevelsToGainMorePoints = Math.min(minLevelsToGainMorePoints, i + 1);
                    break;
                }
            }
        }
        
        // If it's impossible for Danielchandg to gain more points, return -1
        if (minLevelsToGainMorePoints == Integer.MAX_VALUE) {
            return -1;
        }
        
        return minLevelsToGainMorePoints;
    }
    
    public static void main(String[] args) {
        F solution = new F();
        
        // Example 1
        int[] possible1 = {1, 0, 1, 0};
        System.out.println(solution.minLevelsToGainMorePoints(possible1)); // Output: 1
        
        // Example 2
        int[] possible2 = {1, 1, 1, 1, 1};
        System.out.println(solution.minLevelsToGainMorePoints(possible2)); // Output: 3
        
        // Example 3
        int[] possible3 = {0, 0};
        System.out.println(solution.minLevelsToGainMorePoints(possible3)); // Output: -1
    }
}
