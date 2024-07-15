import java.util.*;
public class Nextele{
    private static int[] Nextgreaterelement(int[] arr) {
       Stack<Integer> s = new Stack<>();
       int greter[] = new int[arr.length];

       for(int i = arr.length-1 ; i >= 0 ; i--){
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
                s.pop();
            } 
            if(s.isEmpty()){
                greter[i] = -1;
            }else{
                greter[i] = arr[s.peek()];
            }
            s.push(i);
       }
        return greter;
    }

    public static void main(String[] args) {
        int arr[] = {6,8,0,1,3};
        int ans[] = new int[arr.length];
        ans=Nextgreaterelement(arr);

        for(int i = 0; i < ans.length ; i++){
            System.out.print(ans[i] + " ");
        }
    } 
}