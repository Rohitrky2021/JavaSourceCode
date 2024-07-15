package Recursion.Backtracking;

public class nKnights {
    public static void main(String args[]) {
        boolean[][] board = {
                { false, false, false, false },
                { false, false, false, false },
                { false, false, false, false },
                { false, false, false, false }
        };
        System.out.println(knights(board, 0));
    }

    static int knights(boolean[][] board, int row) {
        if (row == board.length) {
            display(board);
            System.out.println();
            return 1;
        }

        int count = 0;

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += knights(board, row + 1);
                board[row][col] = false;
            }
        }

        return count;
    }

    static boolean isSafe(boolean[][] board, int row, int col) {
        if (isValid(board, row - 2, col - 1) && board[row - 2][col - 1]) {
            return false;
        }
        if (isValid(board, row - 2, col + 1) && board[row - 2][col + 1]) {
            return false;
        }
        if (isValid(board, row - 1, col - 2) && board[row - 1][col - 2]) {
            return false;
        }
        if (isValid(board, row - 1, col + 2) && board[row - 1][col + 2]) {
            return false;
        }
        return true;
    }

    static boolean isValid(boolean[][] board, int row, int col) {
        if (row >= 0 && row < board.length && col >= 0 && col < board.length) {
            return true;
        }
        return false;
    }

    static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) {
                    System.out.print("K ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
