public class ValidAnagram {
    // M1 -->Only till 26 loop Needed Plus Point 
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

// M2 -->On--->Expensive for By Sorting 
// class Solution {

//     public boolean isAnagram(String s1, String s2) {
//         // Convert strings to char arrays
//         char[] c1 = s1.toLowerCase().toCharArray();
//         char[] c2 = s2.toLowerCase().toCharArray();

//         // Sort the char arrays
//         Arrays.sort(c1);
//         Arrays.sort(c2);

//         // Compare the sorted char arrays
//         return Arrays.equals(c1, c2);
//     }
// }


// M3 -->On
// class Solution {

//     public boolean isAnagram(String s, String s2) {
//         if (s.length() != s2.length()) {
//             return false;
//         }
//         HashMap<Character, Integer> map = new HashMap<>();

//         for (int i = 0; i < s.length(); i++) {
//             if (map.containsKey(s.charAt(i))) {
//                 map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
//             } else {
//                 map.put(s.charAt(i), 1);
//             }
//         }

//         for (int i = 0; i < s2.length(); i++) {
//             if (map.containsKey(s2.charAt(i))) {
//                 map.put(s2.charAt(i), map.get(s2.charAt(i)) - 1);
//             if (map.get(s2.charAt(i)) == 0) {
//                 map.remove(s2.charAt(i));
//             }
//             } else {
//                 return false;
//             }
//         }

//         return map.isEmpty();
//     }
// }
// import java.util.HashMap;


// M4 -->On

// class Solution {

//     public boolean isAnagram(String s, String t) {
//         if (s.length() != t.length()) {
//             return false;
//         }
        
//         HashMap<Character, Integer> frequencyMap = new HashMap<>();
        
//         // Count characters in string s
//         for (char c : s.toCharArray()) {
//             frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
//         }
        
//         // Compare character frequencies with string t
//         for (char c : t.toCharArray()) {
//             if (!frequencyMap.containsKey(c)) {
//                 return false;
//             }
//             frequencyMap.put(c, frequencyMap.get(c) - 1);
//             if (frequencyMap.get(c) == 0) {
//                 frequencyMap.remove(c);
//             }
//         }
        
//         return frequencyMap.isEmpty();
//     }
// }

}
