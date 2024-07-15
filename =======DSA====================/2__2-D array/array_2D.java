import java.util.*;
import java.util.Scanner;
public class array_2D {
    public static void input(int marks[][]){
        int i,j;
        int m=marks.length,n=marks[0].length;
        Scanner sc=new Scanner(System.in);
        for( i=0;i<m;i++){
            for(j=0;j<n;j++){
            marks[i][j]=sc.nextInt();

            }
        }
        for( i=0;i<m;i++){
            for(j=0;j<n;j++){
        System.out.print(marks[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static boolean findkey(int marks[][],int key){
        int i,j;
        int m=marks.length,n=marks[0].length;
        for( i=0;i<m;i++){
            for(j=0;j<n;j++){
                if(marks[i][j]==key){
                    System.out.println("the values are found at"+i+" "+j);
                    
                    return true;

                }
        
            }
        }return false;
        }
    public static void main (String args[]){
       int marks[][]=new int[3][3];
    // int marks[]={1,2,3,4,5,6,7,8,9};
    // Scanner sc=new Scanner(System.in);
    input(marks);
    System.out.println(findkey(marks, 5)); 




    }
    public static void spiral(int marks[][]){
        for(int i=0;)
    }
}
