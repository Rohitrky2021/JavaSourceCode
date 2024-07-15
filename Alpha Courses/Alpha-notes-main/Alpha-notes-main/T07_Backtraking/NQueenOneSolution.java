package T07_Backtraking;

import java.util.Scanner;

public class NQueenOneSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char board[][] = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = 'X';
            }
        }
        if (function(board, 0)) {
            printBoard(board);
        } else {
            System.out.println("No ans avilable ");
        }
        sc.close();
    }

    public static boolean function(char board[][], int row) {
        if (board.length == row) {
            return true;
        }
        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, row, i)) {
                board[row][i] = 'Q';
                if (function(board, row + 1)) {
                    return true;
                }
                board[row][i] = 'X';
            }
        }
        return false;
    }

    public static boolean isSafe(char board[][], int row, int col) {

        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; j++, i--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void printBoard(char board[][]) {
        System.out.println("----CHESS BOARD----");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
