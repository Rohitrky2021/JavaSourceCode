public class gridway {
    public static int waysgrid(int arr[][] , int row , int col){
        //base
        if(row==arr.length-1 && col == arr.length-1){
            return 1;
        }else{
            if(row==arr.length || col==arr.length){
                return 0;
            }
        }
        //work 
         return waysgrid(arr, row, col+1)+ waysgrid(arr, row+1, col);
        
    }
    public static void main(String[] args) {
        int n =3,m=3;
        int arr[][] = new int [n][m];

        System.out.println(waysgrid(arr, 0, 0));

    }
}
