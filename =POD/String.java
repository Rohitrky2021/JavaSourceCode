import java.util.*;
public class String {
    class Solution {
    public boolean closeStrings(String word1, String word2) {

       if(!isAnagram(word1, word2))return false; 
         int[] count = new int[26];
         int[] count2 = new int[26];
         int check=0;

       for (int i = 0; i < 26; i++) {
            if(count[i]!=0)check++;
        }
 
        for (char c: word1.toCharArray()) {
            count[c - 'a']++;
        }

       for (int i = 0; i < 26; i++) {
            if(count[i]!=0)check++;
        }

        if(check>word1.length())return false;

        Arrays.sort(count);

      for (char c: word2.toCharArray()) {
            count2[c - 'a']++;
        }
         Arrays.sort(count2);

         if(!Arrays.equals(count, count2))return false;

            return true;        
    }

        public boolean isAnagram(String s, String t) {
         if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (char c: s.toCharArray()) {
            count[c - 'a']++;
        }
        
        for (char c: t.toCharArray()) {
            count[c - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }
}
}


class Solution {
    public boolean isAnagram(String s, String t) {
         if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (char c: s.toCharArray()) {
            count[c - 'a']++;
        }
        
        for (char c: t.toCharArray()) {
            count[c - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }
}