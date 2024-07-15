import java.util.*;
public class divisor {
    public static void main (String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        // int arr[]=new int[2];
        while(T-->0){
            int a=sc.nextInt();
            int b=sc.nextInt();

            if(b%a>0){
                if(b>2*a){
                    System.out.println("yes");
                }
                else{
                    System.out.println("NO");
                }
            }
            else{
                System.out.println("yes");
            }

           

        }
        
    }}

