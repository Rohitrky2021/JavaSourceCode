import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
    public class g1 {

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

        
        public static void pairs(int marks[]){
            int count=0,mc=0,ans=0;
            for(int i=0;i<marks.length;i++){
                int current=marks[i];
                for(int j=0;j<marks.length;j++){
                    for(int k=i;k<=j;k++){
                        Arrays.sort(marks);
                        System.out.print(marks[k]);
                        mc++;
                        ans+=Math.abs(marks[i]-marks[j]);
    
                    }
                    System.out.print(" " );
                    // System.out.print(mc);
    
                   count++;
                }
                if (mc >(marks.length)*(marks.length+1)/2){
                    break;
                }
                System.out.print("" );
    
    
            }
            System.out.println((ans/2));
    }
    public static void main (String args[]){
        Scanner sc=new Scanner(System.in);
        // int T=sc.nextInt();

        // while(T-->0){
        int n=sc.nextInt();

            int marks[]=new int[n];
            int sum=0;
           for (int i = 0; i < marks.length; i++) {
            // for(int j=0;j<marks.length;j++){
                marks[i]=sc.nextInt();
                // sum+=recursiveFactorial(marks[i]);

            // }
           }

        }
    }
// }





