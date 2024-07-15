import java.util.*;


public class unique {
    public static void uniquesum(int arr[]) {
        Arrays.sort(arr);
        int x = arr[arr.length-1];
        
        int sum=0;
        int count [] = new int[x+1];
    
        for(int i = 0 ; i < arr.length ; i++){
             int temp = arr[i];
             count[temp]++;
        }
        for(int i  = 0 ; i < count.length ; i ++ ){
            if(count[i]==1){
                sum=sum+i;
            }
        }

        System.out.println(sum);
    }
    public static void main(String[] args) {
        int arr [] = {1,7,6,8,9,1};
        uniquesum(arr);
    }
}
