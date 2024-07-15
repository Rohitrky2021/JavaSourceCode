import java.util.*;
import java.util.Scanner;
public class calculator {
    public static void main (String args[])
    {System.out.println("bro enter the 2 values then operator");
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println("Enter the operator");
        char operator=sc.next().charAt(0);

        switch(operator){
            case '+':System.out.println(a+b);
            break;
            case '-':System.out.println(a-b);
            break;
            case '/':System.out.println(a/b);
            break;
            case '*':System.out.println(a*b);
            break;
            default:
            System.out.print("bro buy a new calculator");


        }
    }
    
}
