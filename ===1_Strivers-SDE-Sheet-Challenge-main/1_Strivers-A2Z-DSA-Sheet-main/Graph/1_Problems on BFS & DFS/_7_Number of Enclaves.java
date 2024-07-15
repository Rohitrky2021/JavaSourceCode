/*
    1020. Number of Enclaves
    You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
    
    A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.
    
    Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
    
     
    
    Example 1:
    
    
    Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]

    0 | 0 | 0 | 0                   
    1 | 0 | 1 | 0      ------>    Output: 3
    0 | 1 | 1 | 0                   
    0 | 0 | 0 | 0    

    
    Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.

    Example 2:

    Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]

    0 | 1 | 1 | 0                   
    0 | 0 | 1 | 0      ------>    Output: 0
    0 | 0 | 1 | 0                   
    0 | 0 | 0 | 0 

    Explanation: All 1s are either on the boundary or can reach the boundary.
*/

import java.util.Queue;
import java.util.LinkedList;

class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}

public class Number_of_Enclaves { 
    /*
       Time Complexity: O(N*M) 
       Space Complexity: O(N*M)
    */   
    
     
 class Solution1{
 
     // Trick -->Reverse Thinking All 4 Boundries k 1 ko Check dfs Krke Jitne Connected Honge Unko Zero Krdenge
     // those 1's who are left are not connected to any Boundary
     public int numEnclaves(int[][] grid) {
         int count = 0;
         for (int i = 0; i < grid.length; i++) {
             for (int j = 0; j < grid[0].length; j++) { // Iterate over all columns as well
                 if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) {
                     dfs(grid, i, j);
                 }
             }
         }
         for (int i = 0; i < grid.length; i++) {
             for (int j = 0; j < grid[0].length; j++) { // Iterate over all columns as well
                 if (grid[i][j] == 1) {
                     count++;
                 }
             }
         }
         return count;
     }
 
//  DFs 1 Possible 
     // public void dfs(int[][] grid, int i, int j) {
     //     if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
     //         return;
     //     }
 
     //     for (int[] dir : direc) {
     //         int newRow = i + dir[0];
     //         int newCol = j + dir[1];
     //     grid[i][j] = 0;
     //         dfs(grid, newRow, newCol);
     //     }
     // }
 
 //  DFs 2 Possible
     // public void dfs(int[][] grid, int i, int j) {
     //     if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
     //         return;
     //     }
     //     grid[i][j] = 0;
     //     dfs(grid, i - 1, j);
     //     dfs(grid, i + 1, j);
     //     dfs(grid, i, j - 1);
     //     dfs(grid, i, j + 1);
     // }

 //  Our Improved DFS
      public void dfs(int[][] grid, int i, int j) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
              return;
          }
              grid[i][j] = 0;
          for (int m = 0; m < 4; m++) {
              dfs(grid, i + direc[m][0], j + direc[m][1]);
          }
      }
     static int[][] direc = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
 }


 // =============================Using BFS --> Striver's Approach===> Only used bcoz previous one Gives StackOverFlow Error
    public static int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];

        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 || j == 0 || i == n - 1 || j == m - 1){
                    if(grid[i][j] == 1){
                        q.add(new Pair(i, j));
                        vis[i][j] = 1;
                    }
                }
            }
        }

        int[] delRow = {0, -1, 0, 1};
        int[] delCol = {-1, 0, 1, 0};
        
        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            q.remove();

            for(int i = 0; i < 4; i++){
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        System.out.println(numEnclaves(grid));
    }    
}
