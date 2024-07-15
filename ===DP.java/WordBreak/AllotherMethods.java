public class AllotherMethods {
    
}
// Approach 1: Breadth-First Search
// Approach 2: Top-Down Dynamic Programming
// Approach 3: Bottom-Up Dynamic Programming
// Approach 4: Trie Optimization
// Approach 5: A Different DP




// Approach Top-Down Dynamic Programming  --> DP + MEmorisation 

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        return wordBreak(s, wordDict, 0, new Boolean[s.length()]);
    }

    public boolean wordBreak(String s, List<String> wordDict, int index, Boolean[] dp) {
        if (index == s.length()) {
            return true;
        }

        if (dp[index] != null) {
            return dp[index];
        }

        for (int end = index + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(index, end)) && wordBreak(s, wordDict, end, dp)) {
                return dp[index] = true;
                // wordDict.contains(s.substring(index, end)) --> starting ka word if exist nikal k rest check k liye bhej do 
                // wordBreak(s, wordDict, end, dp)) ----> rest length if true laayega tbhi kuch kaam hoga !! 
            }
        }

        return dp[index] = false;
    }
}


// similar travelling using i
class Solution {

    private boolean check(String inputString, int startIndex, Set<String> wordDict, Map<Integer, Boolean> cache) {
        if (startIndex == inputString.length()) {
            return true;
        }

        if (cache.containsKey(startIndex)) {
            return cache.get(startIndex);
        }

        for (int i = startIndex + 1; i <= inputString.length(); i++) {
            String prefix = inputString.substring(startIndex, i);
            if (wordDict.contains(prefix) && check(inputString, i, wordDict, cache)) {
                cache.put(startIndex, true);
                return true;
            }
        }

        cache.put(startIndex, false);
        return false;
    }

    public boolean wordBreak(String inputString, List<String> wordDict) {
        if (inputString == null || wordDict == null || wordDict.isEmpty()) {
            return false;
        }

        Set<String> wordSet = new HashSet<>(wordDict);
        Map<Integer, Boolean> cache = new HashMap<>();
        return check(inputString, 0, wordSet, cache);
    }
}




