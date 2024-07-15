import java.util.Arrays;

public class F {

    // Function to find the maximum score
    // by placing K tiles in a grid M[][]
    static int getMaxScore(int[][] grid, int K) {
        int M = grid.length; //5 here 
        int[][] dp = new int[M][K + 1];

        // Compute the total score of the initial grid
        int totalScore = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                totalScore += grid[i][j];
            }
        }

        // Initialize the first column of dp
        for (int i = 0; i < M; i++) {
            dp[i][0] = 0;
        }

        // Initialize the dp array
        for (int i = 0; i < M; i++) {
            dp[i][1] = Arrays.stream(grid[i], 0, 1).sum();
        }
        
        // Traverse over the grid
        for (int j = 2; j <= K; j++) {
            for (int i = 0; i < M; i++) {
                int scoreHorizontal = dp[i][j - 1] + grid[i][j - 1];
                int scoreVertical = dp[(i + 1) % M][j - 1] + grid[(i + 1) % M][j - 1];
                dp[i][j] = Math.max(scoreHorizontal, scoreVertical);
            }
        }

        // Return the maximum score achievable
        return dp[0][K];
    }

    // Driver Code
    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, -1},
                {1, 3, 2},
                {0, 2, 3},
                {2, 1, 1},
                {3, 3, 0}
        };
        int K = 3;

        int maxScore = getMaxScore(grid, K);
        System.out.println("Maximum Score: " + maxScore);
    }
}
