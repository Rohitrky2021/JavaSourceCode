public class queen {
    public static void main(String args[]) {
        char arr[][] = new char[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = 'x';
            }
        }
        // int count=0;
        ways(arr, 0);
        System.out.println("total ways are :" + count);

    }

    public static void print(char arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("--------queen---------");
    }

    static int count = 0;

    public static boolean safe(char arr[][], int row, int col) {
        // for the up vertical row
        for (int i = row - 1; i >= 0; i--) {
            if (arr[i][col] == 'Q') {
                return false;
            }
        }
        // for the left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (arr[i][j] == 'Q') {
                return false;
            }
        }
        // for the right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < arr.length; i--, j++) {
            if (arr[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void ways(char arr[][], int row) {
        // int count=0;
        if (row == arr.length) {
            print(arr);
            count++;
            return;
        }
        // int row=0;
        // char Q;
        for (int j = 0; j < arr.length; j++) {
            if (safe(arr, row, j)) {
                arr[row][j] = 'Q';
                // if(safe(arr, row, j)){
                ways(arr, row + 1);
                arr[row][j] = 'x';// back tracking                                                
            }

        }
        // System.out.println(count);
    }
}

// }
