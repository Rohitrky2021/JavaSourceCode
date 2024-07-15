import java.util.*;
public class Maxhisto {
    private static int maxarea(int arr[]) {
        // sr
        Stack<Integer> srr = new Stack<>();
        int sr[] = new int[arr.length];
 
        for(int i = arr.length-1 ; i >= 0 ; i--){
             while(!srr.isEmpty() && arr[srr.peek()] >= arr[i]){
                 srr.pop();
             } 
             if(srr.isEmpty()){
                 sr[i] = arr.length;
             }else{
                 sr[i] = srr.peek();
             }
             srr.push(i);
        }

        //sl
        Stack<Integer> s = new Stack<>();
        int sl[] = new int[arr.length];
 
        for(int i = 0  ; i < arr.length; i++){
             while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                 s.pop();
             } 
             if(s.isEmpty()){
                 sl[i] = -1;
             }else{
                 sl[i] = s.peek();
             }
             s.push(i);
        }
        
        
        
        
        
        
        // max area
        int maxArea = 0;
        for(int i = 0 ; i < sl.length ; i++){
            int area = arr[i]*(sr[i] - sl[i]-1);
            if(area > maxArea){
                maxArea=area;
            }
        }

        return maxArea;
    }
    public static void main(String[] args) {
        int arr[] = {2,1,5,6,2,3};
       int ans = maxarea(arr);
        System.out.println(ans);
    }
}
