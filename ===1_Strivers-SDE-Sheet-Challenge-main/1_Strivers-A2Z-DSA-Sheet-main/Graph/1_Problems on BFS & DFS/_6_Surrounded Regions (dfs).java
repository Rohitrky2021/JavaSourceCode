/*
    130. Surrounded Regions
    Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
    
    A region is captured by flipping all 'O's into 'X's in that surrounded region.
         
    
    Example 1:
    Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
    Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]

    X | X | X | X                   X | X | X | X
    X | O | O | X      ------>      X | X | X | X
    X | X | O | X                   X | X | X | X
    X | O | X | X                   X | O | X | X
    
    Explanation: Notice that an 'O' should not be flipped if:
    - It is on the border, or
    - It is adjacent to an 'O' that should not be flipped.
    The bottom 'O' is on the border, so it is not flipped.
    The other three 'O' form a surrounded region, so they are flipped.

    Example 2:    
    Input: board = [["X"]]
    Output: [["X"]]

*/

public class Surrounded_Regions {
    /*
       Time Complexity:  O(N*M)
       Space Complexity: O(N*M)
    */
    public static void dfs(int row, int col, int n, int m, char[][] board, int[][] vis, int[] delRow, int[] delCol){
        vis[row][col] = 1;
        for(int i = 0; i < 4; i++){
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && board[nrow][ncol] == 'O'){
                dfs(nrow, ncol, n, m, board, vis, delRow, delCol);
            }
        }
    }
    public static void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] vis = new int[n][m];

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        for(int i = 0; i < m; i++){
            if(vis[0][i] == 0 && board[0][i] == 'O'){
                dfs(0, i, n, m, board, vis, delRow, delCol);
            }
            if(vis[n - 1][i] == 0 && board[n - 1][i] == 'O'){
                dfs(n - 1, i, n, m, board, vis, delRow, delCol);
            }
        }
        for(int i = 0; i < n; i++){
            if(vis[i][0] == 0 && board[i][0] == 'O'){
                dfs(i, 0, n, m, board, vis, delRow, delCol);
            }
            if(vis[i][m - 1] == 0 && board[i][m - 1] == 'O'){
                dfs(i, m - 1, n, m, board, vis, delRow, delCol);
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O' && vis[i][j] == 0){
                    board[i][j] = 'X';
                }
            }
        }
    }
    public static void main(String[] args) {
        char[][] board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }    
    }
}

class Solution2 {  // first chaning all connnected 0 as 1  -> then changing all 0 as X and then again 1 as 0
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int rows = board.length;
        int cols = board[0].length;

        // Mark boundary and connected 'O's as '1'
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][cols - 1] == 'O') {
                dfs(board, i, cols - 1);
            }
        }

        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[rows - 1][j] == 'O') {
                dfs(board, rows - 1, j);
            }
        }

        // Mark the remaining 'O's as 'X', and revert '1's back to 'O'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != 'O') {
            return;
        }

        board[row][col] = '1';

        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }
}

