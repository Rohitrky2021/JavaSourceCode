import java.sql.Array;
import java.util.Arrays;
import java.util.*;

public class max_min {
    public static void main (String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        int arr[]=new int[3];
        while(T-->0){
           for (int i = 0; i < arr.length; i++) {
               arr[i]=sc.nextInt();
                        }
                        Arrays.sort(arr);
                        System.out.println(Math.abs(arr[0]-arr[2]));
           }

        }
        
    }

