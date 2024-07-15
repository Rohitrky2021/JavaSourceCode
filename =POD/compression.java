import java.util.*;

public class compress {
    public static void main(String[] args) {

    }
}

class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        String ans = new String("");
        int length=0;
        char[] as = s.toCharArray();
        int[] count = new int[26];
        for (char c : as) {
            count[c - 'a']++;
        }
        Arrays.sort(count);

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0);
                 
        }
        length=ans.length();
        return length;
    }
}

 