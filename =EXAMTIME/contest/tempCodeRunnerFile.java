
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class maxele {
    public static void main (String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        while(T-->0){
            int n=sc.nextInt();
            int arr[]=new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i]=sc.nextInt();

            }
            Arrays.sort(arr);
           System.out.println(arr[n-1]);
        }
        
    }
}

