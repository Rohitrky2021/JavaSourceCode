public class Tiling1 {
    public static void main(String args[]){
        System.out.println(tiling(4)); 
        
    }

    
    public static int tiling(int n){  // of n*n matrix
        if(n==0||n==1){
            return 1;
        }
        //tile of 1*2
        int v=tiling(n-1);
        int h=tiling(n-2);
        return v+h;
    }
}//for 4*n also it will same;
 
// Gist of Both 

// The code you provided in your previous message and the code you just posted are not exactly the same. 
// The first code handles tiling a floor of size n x m, where you can place tiles of size 1 x m either 
// horizontally or vertically.
//  The second code, however, handles tiling a n x n matrix, which is a different problem.

// The first code calculates the number of ways to tile a rectangular floor of size n x m, 
// while the second code calculates the number of ways to tile a square matrix of size n x n. 
// The logic and the base cases in the two codes are different.

// So, they are not the same, and they are meant for solving different tiling problems. 
// The first code solves the problem described in your initial question, while the second code 
// solves a different problem related to tiling a square matrix.