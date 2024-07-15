public class Max_in2D_matrix {
    
}
/* 
* Approach 1: Just Implement  
* ? Complexity
** Time complexity: O(m * n). 
** Space complexity: O(3*3) 
*/
class Solution {
    public int[][] largestLocal(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int ans[][]=new int[m-2][n-2];

        for(int i=1;i<m-1;i++){
            for (int j = 1; j < n-1; j++) {
                ans[i-1][j-1]=check( grid,i, j);
            }
        }
        return ans;
    }

    public int check(int grid[][], int i, int j) {
        int max = grid[i][j];
        
        // Check the top row
        for (int col = j - 1; col <= j + 1; col++) {
            if (col >= 0 && col < grid[0].length && grid[i - 1][col] > max) {
                max = grid[i - 1][col];
            }
        }
        
        // Check the bottom row
        for (int col = j - 1; col <= j + 1; col++) {
            if (col >= 0 && col < grid[0].length && grid[i + 1][col] > max) {
                max = grid[i + 1][col];
            }
        }
        
        // Check the left and right borders of the center
        if (grid[i][j - 1] > max) {
            max = grid[i][j - 1];
        }
        if (grid[i][j + 1] > max) {
            max = grid[i][j + 1];
        }
        
        return max;
    }
    
}
 
/* 
* Approach 2: Optmise the findmax function with  fewer constant factors involved
* ? Complexity
** Time complexity:O(m * n).
** Space complexity:O(3*3) 
*/


class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] ans = new int[n-2][n-2];
        for (int k = 0; k< n-2; k++){
            for (int l = 0; l< n-2; l++){
                ans[k][l] = findmax(grid, k+1, l+1);
            }
        }
        return ans;
    }

    private int findmax(int[][] grid, int r, int c){
        int n = grid.length;
        int max = grid[r][c];
        for(int i = r-1; i< r+2; i++){
            for (int j = c-1; j<c+2; j++){
                max = Math.max(grid[i][j], max);
            }
        }
        return max;
    }
}