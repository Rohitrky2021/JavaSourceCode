import java.util.*;
import java.util.List;

public class W1 {
    
    public static void main(String[] args) {
        Solution s=new Solution();
        List<String> wordDict = Arrays.asList("hello","world","hell");
      System.out.println( s.wordBreak("helloworld", wordDict)); 
      String[] dic={"leet","code"};
      Arrays.asList(dic);
        
    }
    
}
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Integer n = s.length();
      
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    System.out.println(j+" "+i);
                }
            }
        }
        // for (int i = 0; i < dp.length; i++) {
        //     System.out.println(dp[i]);
        // }

        return dp[n];
    }
}


// //  All below same 
// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         boolean[] dp = new boolean[s.length() + 1];
//         Set<String> words = new HashSet<>(wordDict);
//         dp[0] = true;
//         //dp[i] means the result to the problem s[0:i]
//         for(int end = 1; end <= s.length(); ++ end) {
//             for(int start = 0; start < end; ++ start) {
//                 if(dp[start] && words.contains(s.substring(start, end))) {
//                     dp[end] = true;
//                     break;
//                 }
//             }
//         }
//         return dp[s.length()];
//     }
// }

// class Solution {
//     public boolean wordBreak(String s, List<String> dict) {
//         boolean[] breakable = new boolean[s.length() + 1];
//         breakable[0] = true;

//         for (int i = 1; i <= s.length(); i++) {
//             for (int j = 0; j < i; j++) {
//                 if (breakable[j] && dict.contains(s.substring(j, i))) {
//                     breakable[i] = true;
//                 }
//             }
//         }
        
//         return breakable[s.length()];
//     }
// }

// // Same just decrease Some amount of 2nd  Loop 
// class Solution {
//     private final static int MAX_WORD_LENGTH = 20;

//     public boolean wordBreak(String s, List<String> dict) {
//         boolean[] breakable = new boolean[s.length() + 1];
//         breakable[0] = true;
//         Set<String> words = new HashSet<>(dict);

//         for (int i = 1; i <= s.length(); i++) {
//             for (int j = Math.max(0, i - MAX_WORD_LENGTH); j < i; j++) {
//                 if (breakable[j] && words.contains(s.substring(j, i))) {
//                     breakable[i] = true;
//                 }
//             }
//         }
        
//         return breakable[s.length()];
//     }
// }


// // Same decrease More 2nd Loop  With Condition 
// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         int n = s.length();
//         boolean[] isWordBreak = new boolean[n + 1];
//         isWordBreak[0] = true;

//         HashSet<String> wordSet = new HashSet<>(wordDict);

//         int maxLen = 0;
//         for (String word : wordDict) {
//             maxLen = Math.max(maxLen, word.length());
//         }

//         for (int i = 1; i <= n; i++) {
//             boolean foundBreak = false;
//             for (int j = i - 1; j >= 0 && j >= i - maxLen && !foundBreak; j--) {
//                 if (isWordBreak[j] && wordSet.contains(s.substring(j, i))) {
//                     isWordBreak[i] = true;
//                     foundBreak = true;
//                 }
//             }
//         }

//         return isWordBreak[n];
//     }
// }
