import java.util.*;
public class SUM {
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        HashMap<Integer,Integer> hm = new HashMap<>();
        Integer sum = 0 ;
        int ans = 0 ;

        for(int i = 0 ; i < arr.length ; i++){
            sum += arr[i];
            if(!hm.containsKey(sum)){
                hm.put(sum, i);
            }else{
                if(ans < (i-hm.get(sum))){
                     ans = i-hm.get(sum);
                }
            }
        }
        System.out.println(ans);
    }
}
