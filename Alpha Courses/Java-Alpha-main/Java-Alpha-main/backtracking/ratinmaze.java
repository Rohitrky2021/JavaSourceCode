public class ratinmaze {
    private static boolean mazepath(int[][] maze,int ans[][], int row, int col ,int direc ) {
      
        //base 
        if(row == maze.length-1 && col == maze.length-1){
            ans[row][col] =  1 ; 
            return true;
        }


        //down 2
        if(row >= 0 && row < maze.length-1  && maze[row][col]==1){
            direc = 2;
          
            ans[row][col] = 1 ;
            if(mazepath(maze, ans, row+1, col, direc)){
                return true;
            }
            ans[row][col] = 0 ;
           
        }
        //right 4
        

        if(col >= 0 && col < maze.length-1  && maze[row][col]==1){
            direc = 4;
         
            ans[row][col] = 1 ;
           if(mazepath(maze, ans, row, col+1, direc)){
            return true;
           }
            ans[row][col] = 0 ;
        }

         //up 1
         
        
         if(row > 0 && row <= maze.length-1  && maze[row][col]==1){
            direc =1 ;
            ans[row][col] = 1 ;
            if(mazepath(maze, ans, row-1, col, direc)){
                return true;
            }
            ans[row][col] = 0 ;
            
        }
        

        //left 3
        if(col > 0 && col <= maze.length-1  && maze[row][col]==1){
            direc = 3;
            ans[row][col] = 1 ;
            if(mazepath(maze, ans, row, col-1, direc)){
                return true;
            }
            ans[row][col] = 0 ;
            
        }    
        return false;
    }
        

    public static void printarr(int arr[][]){
        System.out.println("-----------Possible way is ------------");
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0 ; j < arr.length ; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        } 
    }

    public static void main(String[] args) {
        int maze[][] = 
        { {1,1,0,0},
          {1,1,0,1},
          {0,1,1,1},
          {0,1,0,1}
        };
        int ans[][] = new int [maze.length][maze.length];
 
       if(mazepath(maze,ans,0,0,0)){
            printarr(ans);
       }else{
        System.out.print("Solution is not present");
       }
    }

}
