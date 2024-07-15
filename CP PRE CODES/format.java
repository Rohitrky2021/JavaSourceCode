import java.util.Scanner;

import javax.swing.plaf.synth.SynthStyleFactory;

import java.lang.reflect.Array;
import java.util.*;

public class format{
    public static double recursiveFactorial(int number){ // 1 – double can hold very large numbers compared with integer.

        if(number == 0 || number == 1){ // base for calculation. If the number received is 0 or 1 we return 1. Factorial of 0 or 1 is 1.
        
        return 1;
        
        }
           return number * (recursiveFactorial(number-1)); // 2 – recursive call.
        
        }
        
    public static void main (String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        

        while(T-->0){
        int n=sc.nextInt();
        int X=sc.nextInt();
        int index = 0;  

            int arr[]=new int[n];
            int ans[]=new int[n];
            
           for (int i = 0; i < arr.length; i++) {
            
                arr[i]=sc.nextInt();
                
           }
           Arrays.sort(arr);

           int len = arr.length; 
           for(int i = 0; i < len; i++){  
            //we will skip the index until there are duplicates ahead  
             while (i < len - 1 && arr[i] == arr[i + 1])   
                i++;  
              
            //store element in the distinctArray  
           ans[index] = arr[i];  
            index++;  
        }  
          
        int diff=Math.abs(n-X);
        //printans   
        int m=n-index;

        if(m>X){
            System.out.println(index);
        }
        else{
            System.out.println(ans.length-Math.abs(m-X));
            System.out.println("2nd");
        }
        System.out.println(index);

        System.out.println(ans.length);
        for(int i = 0; i < index; i++)  
            System.out.print(ans[i] + " ");   




        }
        
    }
}
