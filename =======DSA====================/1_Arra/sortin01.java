import java.util.*;


public class sortin01 {
    public static void main(String[] args) {
        
        int arr[]={1,1,0,1,0,0};
       int ans= change(arr);
       System.out.println(ans);
        
    }
    /**
     * @param arr
     */
    public static int change(int arr[]) {
 

        int start=0,end=arr.length-1;
        int i=0;
        int count=0;

        while(i<=end){
            if(arr[i]==0 ){
                // swap(arr,start,i);
                start++;
                // System.err.println(arr[i]);

                i++;
                
            }else  if(arr[end]==1) {
                end--;
            }
            else{
                swap(arr,end,i);
                count+=end-i+1;
                // System.err.println(arr[end]);

                end--;
            }
        }

        for (int j = 0; j < arr.length; j++) {
            System.err.println(arr[j]);
        }
        System.out.println(count);
        return count;
        // System.out.println(String.valueOf(arr));
        
    }
    
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
