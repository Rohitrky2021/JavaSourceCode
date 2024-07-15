import java.util.DoubleSummaryStatistics;

import javax.swing.plaf.basic.BasicBorders.MarginBorder;

public class spiral_matrix {
    
    public static void main(String[] args){
        // int maxi[][]=new int[3][3];
        // int maxi=(1,2,3,4,5,6,7,8,9)
        int maxi[][]={{1,2,4},{4,5,6},{7,8,9}};
        print(maxi);
        // diagonal_sum(maxi);
        printspiral(maxi);
        dsum(maxi);
        alterdsum(maxi);
        advdsum(maxi);
        
        





    }
    public static void print(int maxi[][]){
        int m=maxi.length; 
        int n=maxi[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(maxi[i][j]+" ");
            }
            System.out.println();
        }

    }


    
    public static void printspiral(int maxi[][]){
        int er=maxi.length-1; 
        int ec=maxi[0].length-1;
        int sr=0,sc=0;
        // top
        while(er>=sr && ec>=sc){
            // top
        for(int j=sc;j<=ec;j++){
            System.out.print(maxi[sr][j]);

        }
        System.out.println();
        // right
        for(int i=sr+1;i<=er;i++){
            System.out.print(maxi[i][ec]);
                    }
        System.out.println();
        // bottom
         for(int j=ec-1;j>=sc;j--){
            System.out.print(maxi[er][j]);
         }
        System.out.println();

        // left
        for(int i=er-1;i>=sr+1;i--){
            System.out.print(maxi[i][sc]);
        }
        sr++;
        sc++;
        er--;
        ec--;
        
        }
    }

    public static void dsum(int maxi[][]){
        // int j=0;
        int sum=0;
        for(int i=0;i<maxi.length;i++){
            for(int j=0;j<maxi[0].length;j++){
                if(i==j){
                    sum+=maxi[i][j];
                    
                }

            }
        }
        System.out.println(sum);

    }

    public static void alterdsum(int maxi[][]){
        // int j=0;
        int sum=0;
        int ec=maxi.length-1;
        while(ec>=0){
        for(int i=0;i<maxi.length;i++){

            for(int j=0;j<maxi[0].length;j++){

                if(i+j==maxi.length-1){

                    sum=sum+maxi[i][j];
                    
                }

            }ec--;
        }}
        System.out.println(sum);

    }


    public static void advdsum(int maxi[][]) {
        int sum=0;
        for(int i=0;i<maxi.length;i++){
            // sum=sum+maxi[i][i];
            int j=maxi.length-1-i;
            // if(i==j){
                sum=sum+maxi[i][j];

            // }
        }
        System.out.println(sum);
    }
        


}

















