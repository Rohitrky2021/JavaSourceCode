import java.util.Scanner;
import java.util.*;

public class using_if_else_LARGEST_NUMBER {
    public static void main(String args[]){
 System.out.println("enter A");
Scanner sc=new Scanner(System.in); 
 int A=sc.nextInt();
System.out.println("enter B");
        
 int B=sc.nextInt();
System.out.println("enter C");
        
int C=sc.nextInt();
        
        
        


     if(A>=B && A>=C){
     System.out.println("A is the largest");
     }
    else if(C<=B){
     System.out.println("B is largest    ");
     }
    else
    System.out.print("C is the largest element")
    ;
    
}
    }