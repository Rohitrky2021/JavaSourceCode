// public class Solution {
    
// }
import java.util.*;
class Solution {

    public int lengthOfLongestSubstring(String s) {
        // HashMap<Character,Integer>
        Set<Character> st = new HashSet<>();
        Set<Character> st2 = new HashSet<>();

        // Set<Character> map = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char m=s.charAt(i);
            if (!st.contains(m)) {
                // Set<Character> st = new HashSet<>();
                st.add(m);
                continue;
            }else{
                if(st2.size()<st.size()){
                st2.addAll(st);
            }
            System.out.println(st2);
                st.clear();
            s.concat(str)
            }
// integer.parselo
            
        }
        return st2.size();
    }
}
