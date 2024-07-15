import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class sep24 {


    public  char findTheDifference(String s, String t) {
        char a1[]=s.toCharArray();
        char a2[]=t.toCharArray();

        Arrays.sort(a1);
        Arrays.sort(a2);
        for (int i = 0; i < a1.length; i++) {
            if(a1[i]!=a2[i])return a2[i];
        }


          return a2[s.length()];
    }

    class Solution_plusMinus {
        public char findTheDifference(String s, String t) {
            char res = 0;
            for (char c : s.toCharArray()) res -= c;
            System.out.println(res);
            for (char c : t.toCharArray()) res += c;
            System.out.println(res);

            return res;

        }
    }

    public  char findTheDifference(String s, String t) {
       
        Map<Character, Integer> hs = new HashMap<>();
        for (char c : t.toCharArray()) {
              hs.put(c, hs.getOrDefault(c, 0) + 1);
             
        }
        for(int i:t.toCharArray()){
            if(hs.containsKey(i)){
                if(hs.get(i)==0)return i;
                hs.put(c, hs.getOrDefault(c, 0) - 1);
  
            } 
        }
        

       
         

          return 'k';
    }
    
}

