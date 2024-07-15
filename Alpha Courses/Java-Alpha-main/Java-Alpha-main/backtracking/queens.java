public class queens {
     
    public static boolean boardfill(char arr[][] , int row) {
        if(row==arr.length){
            return true;
        }
        
        for(int j = 0 ; j < arr.length ; j++ ){
           if(issafe(arr,row,j)){
              arr[row][j]= 'Q';
              if(boardfill(arr, row+1)){
                return true;
              }  
              arr[row][j] = '.';
           }
            
        }
        return false;
    }

    public static boolean issafe(char [][] arr , int row ,int cl){
        //vertical up
        for(int i = row-1 ; i >= 0 ; i--){
            if(arr[i][cl]=='Q'){
                return false;
            }
        }
        // left diag
        for(int i = row-1, j=cl-1 ; i >= 0 && j>=0 ;j-- ,i--){
            if(arr[i][j]=='Q'){
                return false;
            }
        }

        // right diag
        for(int i = row-1, j=cl+1 ; i >= 0 && j < arr.length ;j++ ,i--){
            if(arr[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }

    public static void printarr(char[][] arr) {
        System.out.println("--------boardplace-------");
        for(int i = 0 ; i < arr.length ; i++){
            for(int j=0;j< arr.length ; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4 ;
        char arr[][] = new char[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j=0;j< n ; j++){
                arr[i][j]='.';
            }
        }
        if(boardfill(arr,0)){
            System.out.println("Solution is possible");
            printarr(arr);
        }else{
            System.out.println("Solution is not possible");
        }

    }
}
