
import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class jan11{
    static int xorOfArray(int arr[], int n)
    {
        // Resultant variable
        int xor_arr = 0;
     
        // Iterating through every element in
        // the array
        for (int i = 0; i < n; i++) {
     
            // Find XOR with the result
            xor_arr = xor_arr ^ arr[i];
        }
     
        // Return the XOR
        return xor_arr;
    }
    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
     
    // method to return LCM of two numbers
    static int lcm(int a, int b)
    {
        return (a / gcd(a, b)) * b;
    }
     
    public static void main (String args[]){
        Scanner sc=new Scanner(System.in);
        // int T=sc.nextInt();

        // while(T-->0){
        // int n=sc.nextInt();

            int arr[]=new int[2];
            // int sum=0;
           for (int i = 0; i < arr.length; i++) {
            // for(int j=0;j<arr.length;j++){
                arr[i]=sc.nextInt();
                // sum+=recursiveFactorial(arr[i]);
                
            // }
           }
        //    arr[1].equalsIgnoreCase("START38");
           if(arr[0]%arr[1]==0){
          System.out.println((arr[0]/arr[1])); 
        //   System.out.println(lcm(arr[0], arr[1])); 
           }else{
            System.out.println((arr[0]/arr[1])+1); 
           }
           e
    }
}
// }
