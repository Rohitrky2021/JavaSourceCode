public class nqueen {
    // working of nqueen function
    public static void nQueens(char board[][], int row) {
        // base case
        if(row == board.length) {
            printBoard(board);
            return;
        }
        // column loop
        for(int j=0; j<board.length; j++) {
            board[row][j] = 'Q'; // in this row we place the queen on each col
            nQueens(board, row+1); // call it recursively for the next row (function call)
            board[row][j] = '.'; // when the queen backtracks, we make it empty (backtrack step)
        }
    }

    // to print the board
    public static void printBoard(char board[][]) {
        System.out.println("------ chess board ------");
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board.length; j++) {
                System.out.println(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // main code
    public static void main(String[] args) {
        int n = 2;
        char board[][] = new char[n][n];

        // initialize
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = '.';
            }
        }

        // call the n queen function in which we passed the initial row as 0
        nQueens(board, 0);
    }
}