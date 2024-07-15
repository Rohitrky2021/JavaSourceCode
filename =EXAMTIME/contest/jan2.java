

import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class jan2 {
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
        int T=sc.nextInt();
        while(T-->0){
            int n=sc.nextInt();
            
            Boolean flag=true;
            int arr[]=new int[n];
            int sum=0;
           for (int i = 0; i < arr.length; i++) {
            // for(int j=0;j<arr.length;j++){
                arr[i]=sc.nextInt();
                // sum+=recursiveFactorial(arr[i]);

            // }
           }
           for (int i = 1; i <= arr.length-2; i++) {
            // for(int j=0;j<arr.length;j++){
                arr[i]^=(arr[i]^arr[i-1]);
                // sum+=recursiveFactorial(arr[i]);
                arr[i]=arr[i-1];
            // }
           }
           for (int j = 1; j <= arr.length-2; j++) {
            // for(jnt j=0;j<arr.length;j++){
                arr[j]^=(arr[j]^arr[j-1]);
                // sum+=recursjveFactorjal(arr[j]);
                arr[j]=arr[j+1];
            // }
           }
           for (int j =arr.length-2; j >=1; j--) {
            if(arr[j]!=arr[j+1]){
                flag=false;
            }
           }
           if(flag){
            System.out.println("YES");

           }else{
            System.out.println("NO");
           }
    
    }
}
}