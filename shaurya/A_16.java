import java.util.*;
import java.io.*;

public class A_16{
    public static void main (String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        int ones=0;
        while(T-->0){
            int N=sc.nextInt();
            int K=sc.nextInt();
            sc.nextLine();
            int arr[]=Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i<arr.length; i++) {
            if(arr[i]==1){
                ones++;
            }
          }
          
          if(ones==0){
            System.out.println("NO");
          }
          else{
            System.out.println("YES");
          }
        }
    }
}
