import java.util.ArrayList;
import java.util.List;

public class phoneKeypad {
// class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return new  ArrayList<String>();
        }
        String comb = "";
        return printcomb(digits, 0, comb);
    }

    public List<String> printcomb(String digi, int idx, String comb) {
        List<String> ans = new ArrayList<String>();
        

        // Base case: add the current combination to the result list
        if (comb.length() == digi.length()) {
            ans.add(comb);
            return ans; // Return the result at this point
        }

        String[] keypad = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        char curr = digi.charAt(idx);

        // --->converting char to int ;
        String map = keypad[curr - '0'-2];

        for (int i = 0; i < map.length(); i++) {
            ans.addAll(printcomb(digi, idx + 1, comb + map.charAt(i))); // Combine the lists
        }
        return ans;
    }
}

// }

class Solution {
    
    String[] dir = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> ans =  new ArrayList<>();


    public List<String> letterCombinations(String digits) {
        // Deque<Character> cur = new LinkedList<>();
        if(digits == null || digits.length() == 0) return ans;
        backtracking(digits,new StringBuffer());
        return ans;

        
        
    }
    private void backtracking(String s,StringBuffer cur){
        if(s == null || s.length() == 0) {
            ans.add(cur.toString());
            return;
        }
        int len = s.length();
        int curDigit = s.charAt(0) - '0';
        char[] options = dir[curDigit].toCharArray();
        for(char c:options){
            cur.append(c);
            backtracking(s.substring(1,len),cur);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}


class Solution {
    private static final Map<Character, char[]> map = Map.of(
            '2', "abc".toCharArray(),
            '3', "def".toCharArray(),
            '4', "ghi".toCharArray(),
            '5', "jkl".toCharArray(),
            '6', "mno".toCharArray(),
            '7', "pqrs".toCharArray(),
            '8', "tuv".toCharArray(),
            '9', "wxyz".toCharArray());

    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        if(digits.length() == 0) return result;
        
        helper(digits, 0, new StringBuilder(), result);
        return result;
    }

    private static void helper(String digits, int index, StringBuilder builder, List<String> result){
        if(index == digits.length()){
            result.add(builder.toString());
            return;
        }
        
        for(char ch : map.get(digits.charAt(index))){
            builder.append(ch);
            helper(digits, index + 1, builder, result);
            builder.deleteCharAt(index);
        }
    }
}