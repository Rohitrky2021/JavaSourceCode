import java.util.*;
public class majorityElements {
    public static void main(String args[]) {
        // elements appear more than thrice 3 times;
        int arr[]={1,3,2,5,1,3,1,5,1};
        HashMap<Integer,Integer> map=new HashMap<>();

        Set<Integer> keyset=map.keySet();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }
            else{
                map.put(arr[i], 1);
            }
            

        }

        
        for(Integer key:keyset){
            if(map.get(key)>=3){
                System.out.println(key.intValue());
            }
        }
    }
}

// https://leetcode.com/problems/majority-element/
public int majorityElement(int[] nums) {
        HashSet<Integer> hs=new HashSet<>();
        for(int i:nums){
            if(hs.contains(i)) return i;
            hs.add(i);
        }
        return -1;
}