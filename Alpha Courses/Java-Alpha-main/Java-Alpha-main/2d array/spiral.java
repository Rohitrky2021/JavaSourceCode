public class spiral {
    public static boolean diagonalsum(int matrix[][],int key) {
        int row = 0;
        int col = matrix[0].length-1;
        while(row < matrix.length && col >= 0){
            if(matrix[row][col]==key){
                System.out.print("("+row+","+col+")");
                return true;
            }
            else if(matrix[row][col] > key){
                col--;
            }
            else if(matrix[row][col] < key){
                row++;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        int matrix[][] = {{1,3,5,7},
                          {10,11,16,20},
                          {23,30,34,60}};
        int key= 13;
        boolean sum = diagonalsum(matrix,key);
        System.out.print(sum);
        
    }
}


