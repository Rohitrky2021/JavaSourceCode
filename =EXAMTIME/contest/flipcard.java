import java.util.Scanner;
import java.util.*;

public class flipcard {
    public static void main(String arg[]){
        Scanner sc=new Scanner(System.in);
        long T=sc.nextLong();
        while(T-->0){
            long s=sc.nextLong();
            long fu=sc.nextLong();
            if(s==fu){
                System.out.println("0");
            }
            else{
                // System.out.println(s);
                System.out.println(Math.min(s, fu));
            }

        }
    }
    // int sc=sc.nextInt();
}
