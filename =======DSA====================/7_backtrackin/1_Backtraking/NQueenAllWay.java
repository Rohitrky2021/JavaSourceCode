package T07_Backtraking;

import java.util.Scanner;

public class NQueenAllWay {
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
        sc.close();
    }

    public static void function(char board[][], int row) {
        if (row == board.length) {
            printBoard(board);
            return;
        }

        for (int j = 0; j < board.length; j++) {
            board[row][j] = 'Q';
            function(board, row + 1);
            board[row][j] = 'X';
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
