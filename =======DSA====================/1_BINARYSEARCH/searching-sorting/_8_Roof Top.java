import java.util.*;

public class Main {

    public static int maximise(int[]arr) {
        //write your code here
        int o = 0;
        
        
        int curr=0,max=1;
        for(int i = 1; i < arr.length; i++){
            if(arr[i]>arr[i-1])curr++;
            else{
                max=Math.max(max,curr);
                curr=0;
            }
        }
        
        return o;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int ans = maximise(arr);
        System.out.println(ans);
    }
}