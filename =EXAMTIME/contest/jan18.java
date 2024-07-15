import java.util.*;
import java.util.concurrent.ForkJoinPool;

public class jan18{
    public static double recursiveFactorial(int number){ // 1 – double can hold very large numbers compared with integer.

 

        if(number == 0 || number == 1){ // base for calculation. If the number received is 0 or 1 we return 1. Factorial of 0 or 1 is 1.
        
        return 1;
        
        }
        
         
        
        return number * (recursiveFactorial(number-1)); // 2 – recursive call.
        
        }
        public static int change(int arr[]){
            int count=0;
            int change[]=Arrays.copyOf(arr, arr.length);
            Arrays.sort(arr);
            // for (int i = 0; i < change.length; i++) {
            //     System.out.println(arr[i]);
            //     // System.out.println(change[i]);
            // }
            
            // for (int i = 0; i < change.length; i++) {
            //     // System.out.println(arr[i]);
            //     System.out.println(change[i]);
            // }
            for (int i = 0; i < arr.length; i++) {
                if(arr[i]!=change[i]){
                    count++;
                }
                // if(count==0){
                //     count=-2;
                // }
            }
            return count/2;
        }
    public static void main (String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();

        while(T-->0){
        int n=sc.nextInt();
        int ans=0;
        int fp=0;


            int arr[]=new int[n];
            int arr2[]=new int[n];
            int arr3[]=new int[n];


            int sum=0;
           for (int i = 0; i < arr.length; i++) {
            // for(int j=0;j<arr.length;j++){
                arr[i]=sc.nextInt();
                // sum+=recursiveFactorial(arr[i]);

            // }
           }
           for (int i = 0; i < arr.length; i++) {
            // for(int j=0;j<arr.length;j++){
                arr2[i]=sc.nextInt();
                // sum+=recursiveFactorial(arr[i]);

            // }
           }
          for (int i = 0; i < arr2.length-1; i++) {
            arr3[i]=arr[i]+arr2[i];
          }

          for (int i = 0; i < arr2.length-1; i++) {
              if(arr3[i]<arr3[i+1]){
                  ans=i+1;
              if(arr3[ans]<arr3[fp]){
                  ans=fp;
            }
                  fp=ans;
              }
            }

          if((ans<arr.length-1  &&  (arr3[ans]==arr3[ans+1])) ){
            while(arr[ans]==arr[ans+1]){
            ans=ans+1;}
        }

          System.out.println(ans+1);
// System.out.println(sum);

        }
        
    }
}





