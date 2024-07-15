import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class format2{
    public static double recursiveFactorial(int number){ // 1 – double can hold very large numbers compared with integer.

 

        if(number == 0 || number == 1){ // base for calculation. If the number received is 0 or 1 we return 1. Factorial of 0 or 1 is 1.
        
        return 1;
        
        }
        
         
        
        return number * (recursiveFactorial(number-1)); // 2 – recursive call.
        
        }
       
    public static void main (String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        
        int arr[]=new int[2*T];
        // while(T-->0){
        // int n=sc.nextInt();

            int count=0;
           for (int i = 0; i < T; i++) {
            for(int j=0;j<2;j++){
                arr[j]=sc.nextInt();
            }
            if(arr[0]==arr[1]){
                count++;
            }

           }
           if(count>2){
            System.out.println("Yes");
           }
           else{
            System.out.println("No");
           }

// System.out.println(sum);

        }
        
    }
// }
