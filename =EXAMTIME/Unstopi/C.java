import static java.lang.Math.abs;
import static java.lang.Math.max;

class C {
    public int ans = 0;

    int solve(int root, int[] cost) {
        int n = cost.length;
        if (root > n)
            return 0;
        int sum1 = solve(root * 2, cost);
        int sum2 = solve(root * 2 + 1, cost);
        ans += abs(sum1 - sum2);
        return cost[root - 1] + max(sum1, sum2);
    }

    public int minIncrements(int n, int[] cost) {
        solve(1, cost);
        return ans;
    }

    public static void main(String[] args) {
        C solution = new C();

        // Test case
        int[] cost = {0, 3, 6, 2, 1, 5, 4}; // Adjusted index by adding 0 for root node
        int n = 7; // Number of nodes
        int minIncrements = solution.minIncrements(n, cost);
        System.out.println("Minimum total weight increase needed: " + minIncrements);
    }
}
