
/**
 * Approach 1: DFS + Backtracking 
 * ? Complexity
 ** Time complexity: O(n * n * 4^g)  {g==> gold-cell!=0}
 ** Space complexity: O(4^g)
 */
    
class Solution {
    public int dfs(int[][] grid, int row, int col){
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] <= 0) {
            return 0;
        }

        grid[row][col] = -grid[row][col];

        int down = dfs(grid, row+1, col);
        int right = dfs(grid, row, col+1);
        int up = dfs(grid, row-1, col);
        int left = dfs(grid, row, col-1);

        grid[row][col] = -grid[row][col];

        return grid[row][col] + Math.max(Math.max(left, right), Math.max(up, down));
    }

    public int getMaximumGold(int[][] grid) {
        int m = grid.length, n = grid[0].length, ans = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        return ans;
    }
}

    /**
     * Approach 2: BFS 
     *  It's recommended to avoid using BFS for this specific scenario related to Path sum
     **  and opt for DFS with backtracking instead.  
     */