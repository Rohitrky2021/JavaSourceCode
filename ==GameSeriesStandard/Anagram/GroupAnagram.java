import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {
    public static void main(String[] args) {
        // String s="abcd";

    }
    public List<List<String>> groupAnagram(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
    
        // Iterate through the input strings and calculate their hash values
        HashMap<String, Integer> hs = new HashMap<>();
        for (String s : strs) {
            int sum = 0;
            for (char c : s.toCharArray()) {
                sum += (int) c;
            }
            hs.put(s, sum / s.length());
        }
    
        // Iterate through the hash map's keys and build the result
        for (String s : hs.keySet()) {
            int targetValue = hs.get(s);
            List<String> inner = new ArrayList<>(); // Create a new inner list for each key
            inner.add(s); // Add the current string to the inner list
    
            // Iterate through the remaining keys to find strings with the same hash value
            for (String other : hs.keySet()) {
                if (!other.equals(s) && hs.get(other) == targetValue) {
                    inner.add(other); // Add strings with the same hash value to the inner list
                }
            }
    
            ans.add(inner); // Add the inner list to the result
        }
    
        return ans;
    }
    

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans=new ArrayList<>();
        List<String> inner=new ArrayList<>();


        HashMap<String,Integer> hs=new HashMap<>();
        for(String s:strs){
            int sum=0;
            for(char i:s.toCharArray()){
                sum+=(int)i;
            }
            hs.put(s, sum/s.length());

        }
        // for(int i:hs.values()){

        // }
        for(String s:hs.keySet()){
            if(hs.containsValue(hs.get(s)));//excepts its values 
            inner.add(key of that string);
            delete it also for next search to get next exist 
            ans.add(inner);
        }


      return ans;
        
    }
}
