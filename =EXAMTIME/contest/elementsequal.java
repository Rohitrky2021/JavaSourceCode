import java.util.Arrays;
import java.util.Scanner;

public class elementsequal {
    public static void main (String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        while(T-->0){
            int n=sc.nextInt();
            int count=0;
            int arr[]=new int[n];
           for (int i = 0; i < arr.length; i++) {
                arr[i]=sc.nextInt();
            
           }
           Arrays.sort(arr);
           for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]==arr[i+1]){
                count++;
            }
            if(arr[i+1]!=arr[i]&& arr[i+1]%arr[i]==0){
                count++;
            }
              }
              if(count>=1){
                System.out.println((arr.length)-count);
              }
              else{
                System.out.println(arr.length);
              }
              
              

           


        }
        
    }
    
}
