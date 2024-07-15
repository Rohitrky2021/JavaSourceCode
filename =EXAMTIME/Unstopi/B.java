class B {
    int ans = 0;

    int dfs(int n, int[] cost, int i) {
        // System.err.println(n);
        n=cost.length;
        if (i > n)
            return 0;
        int rightCost = dfs(n, cost,2 * i);
        int leftCost = dfs(n, cost, 2 * i + 1  );
        ans += Math.abs(leftCost - rightCost);
        System.err.println(ans+"<<ans");  
        return  cost[i-1] + Math.max(leftCost, rightCost);
    }

    public int minIncrements(int n, int[] cost) {
        System.err.println((1 << (n )) - 1);
        return dfs((1 << (n )) - 1, cost, 1);
    }

    public static void main(String[] args) {
        B solution = new B();

        // Test case
        int[] cost = {0, 3, 6, 2, 1, 5, 4}; // Adjusted index by adding 0 for root node
        int height = 3;
        int minIncrements = solution.minIncrements(height, cost);
        System.out.println("Minimum total weight increase needed: " + solution.ans);
    }
}
