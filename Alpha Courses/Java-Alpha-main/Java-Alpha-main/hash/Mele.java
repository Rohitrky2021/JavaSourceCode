import java.util.*;;

public class Mele {
    public static void main(String[] args) {
        int arr[] = {1,3,2,5,1,3,1,5,1};
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i =0 ; i <arr.length ; i++){
            int nums = arr[i];
            //
            if(hm.containsKey(nums)){
                hm.put(nums, hm.get(nums)+1);
            }else{
                hm.put(nums, 1);
            }
            //    or
           //   hm.put(nums, hm.getOrDefault(nums, 0)+1);
        }
       // Set<Integer> key = hm.keySet();
        for (Integer i : hm.keySet()) {
            if(hm.get((int)i) >= (arr.length/3)){
                System.out.println(i);
            }
        }
    }
}
