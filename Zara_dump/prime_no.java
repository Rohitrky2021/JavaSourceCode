import java.util.*;
import java.util.Scanner;
public class prime_no {
    public static void main(String args[])
    { int i;
        int K=1;
      Scanner sc=new Scanner(System.in);
      System.out.println("ENTER THE NO.");
      int a=sc.nextInt();
      for(i=2;i<Math.sqrt(a);i++){
        if(a%i==0){K=0;
            // System.out.println("NOT A PRIME NO.");
        }
        else{
        }
               
        
    }
    if(K==0){
        System.out.println("NOT A PRIME NO.");
        
    }
    else{
        System.out.println("YA! ITS PRIME BRO");

    }

      

    }
        public static boolean isSorted(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    return false;
                }
            }
            return true;
        }
    
    
}
