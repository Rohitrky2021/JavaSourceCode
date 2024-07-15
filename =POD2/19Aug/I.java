import java.util.*;

public class I {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        I solution = new I();

        // Test Case 1
        int A1 = 3;
        int B1 = 2;
        int[] C1 = {1, 1, 1};
        System.out.println("Test Case 1: " + solution.solve(A1, B1, C1)); // Output should be 5

        // Test Case 2
        int A2 = 4;
        int B2 = 3;
        int[] C2 = {1, 3, 1, 3};
        System.out.println("Test Case 2: " + solution.solve(A2, B2, C2)); // Output should be 71
    }

    public int solve(int A, int B, int[] C) {
        int[][] dp = new int[A][9]; // dp[i][j] represents number of ways for node i+1 to have value j
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < A; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 1; i < A; i++) {
            adjList.get(C[i] - 1).add(i + 1);
        }

        // DFS traversal to compute dp values
        dfs(1, -1, B, adjList, dp);

        // Sum all possible ways for root node to have values from 1 to B
        int ans = 0;
        for (int j = 1; j <= B; j++) {
            ans = (ans + dp[0][j]) % MOD;
        }
        return ans;
    }

    private void dfs(int node, int parent, int B, ArrayList<ArrayList<Integer>> adjList, int[][] dp) {
        // Base case: leaf node
        if (adjList.get(node - 1).size() == 0) {
            dp[node - 1][1] = 1; // Only one way to assign value 1 to leaf node
            return;
        }

        // Initialize dp values for current node
        Arrays.fill(dp[node - 1], 1);

        // Recursively compute dp values for child nodes
        for (int child : adjList.get(node - 1)) {
            if (child == parent) continue;
            dfs(child, node, B, adjList, dp);
            int[] temp = new int[9]; // Temporary array to store updated dp values
            for (int i = 1; i <= B; i++) {
                for (int j = 1; j <= B; j++) {
                    if ((i & j) == 0) {
                        temp[j] = (temp[j] + dp[node - 1][i] * dp[child - 1][j]) % MOD;
                    }
                }
            }
            System.arraycopy(temp, 1, dp[node - 1], 1, B); // Update dp values for current node
        }
    }
}
