import java.util.*;
import java.util.Scanner;
public class solid_rhom{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int i,j;
        for(i=1;i<=n;i++){
            for(j=1;j<=(n-i);j++){
                System.out.print(" ");}
            for(j=1;j<=n;j++){
                System.out.print("* ");
            }    
             

            
            System.out.println(" ");
        }


    }
}
