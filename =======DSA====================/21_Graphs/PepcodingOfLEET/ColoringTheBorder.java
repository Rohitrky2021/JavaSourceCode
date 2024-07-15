public class ColoringTheBorder {
    // https://leetcode.com/problems/coloring-a-border/description/
    
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        dfs(grid, row, col, grid[row][col], visited);
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0) {
                    grid[i][j] = color;
                }
            }
        }
        
        return grid;
    }

    static int[][] direc = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public void dfs(int[][] grid, int row, int col, int colr, boolean[][] visited) {
        visited[row][col] = true;
        grid[row][col] = -colr;
        int count = 0;

// -------------------------------------------------------------
        // this 4 Loop is Equalent to -->
        // dfs(grid, i+1, j, col, visited, target, n, m);
        // dfs(grid, i-1, j, col, visited, target, n, m);
        // dfs(grid, i, j+1, col, visited, target, n, m);
        // dfs(grid, i, j-1, col, visited, target, n, m);
        // ---------------------------------------------------
        for (int i = 0; i < 4; i++) {
            int rowdash = row + direc[i][0];
            int coldash = col + direc[i][1];

            if (rowdash >= 0 && coldash >= 0 && rowdash < grid.length && coldash < grid[0].length && Math.abs(grid[rowdash][coldash]) == colr) {
                count++;
                if (!visited[rowdash][coldash]) {
                    dfs(grid, rowdash, coldash, colr, visited);
                }
            }
        }
        // ----------------------------------------------------
        if (count == 4) {
            grid[row][col] = colr;
        }
    }
}
