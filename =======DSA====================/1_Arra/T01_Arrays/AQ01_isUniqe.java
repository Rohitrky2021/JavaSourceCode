// Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

package T01_Arrays;
import java.util.*;
public class AQ01_isUniqe {
    
    static boolean containsDuplicate(int arr[]){ // brute force
        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                if(arr[i] == arr[j]){
                    return true;
                }
            }
        }
        return false;
    }
    
    static boolean containsDuplicate2(int arr[]) { // using extra space count frequency

        int freq[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            freq[arr[i]]++;
            if (freq[arr[i]] > 1) {
                return true;
            }
        }

        return false;
    }
    
    static boolean containsDuplicate3(int arr[]){ // using Sets 
        Set<Integer> hs = new HashSet<>();
        for(int i = 0; i < arr.length; i++){
            if(hs.contains(arr[i])){
                return true;
            }else{
                hs.add(arr[i]);
            }
        }
        return false;
    }
}
