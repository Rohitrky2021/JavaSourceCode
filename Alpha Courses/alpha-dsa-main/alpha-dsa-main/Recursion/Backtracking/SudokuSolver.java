package Recursion.Backtracking;

public class SudokuSolver {
    public static void main(String args[]) {
        int[][] problem = new int[][] {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 } 
            };

        // System.out.println(solve(problem));
        if (solve(problem)) {
            display(problem);
        } else {
            System.out.println("Can't solve");
        }
    }

    static boolean solve(int[][] board) {
        int n = board.length;
        int row = -1;
        int col = -1;

        boolean emptyLeft = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }
            if (!emptyLeft) {
                break;
            }
        }
        if (emptyLeft) {
            return true;
        }

        // backtrack
        for (int number = 1; number <= 9; number++) {
            if (isSafe(board, row, col, number)) {
                board[row][col] = number;
                if (solve(board)) {
                    return true;
                } else {
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    static void display(int[][] board) {
        for (int[] row : board) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    static boolean isSafe(int[][] board, int row, int col, int num) {
        // check the row
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }
        // check the column
        for (int j = 0; j < board.length; j++) {
            if (board[j][col] == num) {
                return false;
            }
        }
        // check the square
        int sqrt = (int) (Math.sqrt(board.length));
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;

        for (int k = rowStart; k <= rowStart + 2; k++) {
            for (int l = colStart; l <= colStart + 2; l++) {
                if (board[k][l] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
