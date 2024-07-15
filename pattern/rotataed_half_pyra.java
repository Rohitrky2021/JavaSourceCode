import java.util.*;
import java.util.Scanner;
public class rotataed_half_pyra{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int i,j,cont=1;
        for(i=1;i<=n;i++){
            for(j=1;j<=(n-i);j++){
            System.out.print(" ");}
            for(j=0;j<i;j++){
                System.out.print("*");
                cont++;
            }
            System.out.println(" ");
        }


            
    }


}

