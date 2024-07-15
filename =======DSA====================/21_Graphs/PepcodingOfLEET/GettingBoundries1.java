public class GettingBoundries1 {

    // https://leetcode.com/problems/number-of-enclaves/

    // Trick -->Reverse Thinking All 4 Boundries k 1 ko Check dfs Krke Jitne Connected Honge Unko Zero Krdenge 
    // those 1's who are left are not connected to any Boundary 

    public int numEnclaves(int[][] grid) {
        int count=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if(i==0||j==0||i==grid.length-1||j==grid.length-1){
                    dfs(grid, i, j);
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if(grid[i][j]==1){
                    count++;
                }
            }}
        return count;
    }
    public void dfs(int[][] grid,int i,int j){
        for (int m = 0; m < 4; m++) {
            if(i<0 || j<0 || i>=grid.length ||j>=grid.length){
                return;
            }
            grid[i][j]=0;
            dfs(grid, i+direc[m][0], j+direc[m][1]);
        }

    }
    static int[][] direc = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };


}
