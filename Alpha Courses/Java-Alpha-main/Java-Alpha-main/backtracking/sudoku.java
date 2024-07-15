public class sudoku {
    public static boolean sudukusol(int arr[][], int row,int col){
        if(row==9){
            printarr(arr);
            return true;
        }
        //work
        int nextrow = row,nextcol = col+1;
        if(col+1==9){
            nextrow = row+1;
            nextcol = 0 ;
        } 
        if(arr[row][col]!=0){
            if(sudukusol(arr, nextrow, nextcol)){
                return true;
            }
            return false;
        }

        for(int digit = 1 ; digit <=9 ; digit++ ){
            if(isSafe(arr,row,col,digit)){
                arr[row][col] = digit;
                if(sudukusol(arr, nextrow, nextcol)){
                    return true;
                }
                arr[row][col]=0;
            }
        
        }       
       return false;

    }
    private static boolean isSafe(int[][] arr, int row, int col, int digit) {
        // row 
        for(int i = 0 ; i < 9 ; i++){
            if(arr[i][col]==digit){
                return false;
            }
        }
        //col
        for(int i = 0 ; i < 9 ; i++){
            if(arr[row][i]==digit){
                return false;
            }
        }
        //grid
        int sr = (row/3)*3;
        int sc = (col/3)*3;

        for(int i=sr ; i < sr+3 ; i++){
            for(int j=sc ; j < sc+3;j++){
                if(arr[i][j]==digit){
                    return false;
                }
            }
        }

        return true;
    }

    public static void printarr(int [][] arr) {
        System.out.println("---------solution--------");
        for(int i = 0 ; i < arr.length ; i++){
            for(int j=0 ; j < arr.length ; j++){
                System.out.print(" "+ arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int arr[][] =
        {{4,0,1,3,0,0,0,0,8},
        {0,2,6,0,0,0,0,9,3},
        {0,0,0,0,7,0,0,2,0},
        {1,9,5,6,0,2,8,3,0},
        {0,0,0,0,9,0,6,1,0},
        {0,8,2,7,1,3,4,5,0},
        {2,0,9,0,8,7,0,0,0},
        {0,4,0,0,0,0,0,0,1},
        {0,0,0,2,0,4,0,8,0}
        };

        if(sudukusol(arr,0,0)){
            System.out.println("Solution is present");
            
        }else{
            System.out.println("Solution is not present");
        }
    }
}
