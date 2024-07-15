package T07_Backtraking;

import java.util.Scanner;

public class NQueenAllSolution {

    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char board[][] = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = 'X';
            }
        }
        function(board, 0);
        System.out.println("count = " + count);
        sc.close();
    }

    public static boolean isSafe(char board[][], int row, int col) {
        // up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // right up

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void function(char board[][], int row) {
        if (row == board.length) {
            printBoard(board);
            count++;
            return;
        }

        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                function(board, row + 1);
                board[row][j] = 'X';
            }
        }
    }

    public static void printBoard(char board[][]) {
        System.out.println("************");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
