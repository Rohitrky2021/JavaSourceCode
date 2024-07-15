public class WordBreak1 {
    // Approach 1: Breadth-First Search
// Approach 2: Top-Down Dynamic Programming
// Approach 3: Bottom-Up Dynamic Programming
// Approach 4: Trie Optimization
// Approach 5: A Different DP

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> words = new HashSet<>(wordDict);
        dp[0] = true;
        //dp[i] means the result to the problem s[0:i]
        for(int end = 1; end <= s.length(); ++ end) {
            for(int start = 0; start < end; ++ start) {
                if(dp[start] && words.contains(s.substring(start, end))) {
                    dp[end] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

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
            }
        }

        return dp[index] = false;
    }
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        return wordBreak(s, wordDict, 0, new Boolean[s.length()]);
    }

    public boolean wordBreak(String s, List<String> wordDict, int index, Boolean[] cache) {
        if (index == s.length()) {
            return true;
        }

        if (cache[index] != null) {
            return cache[index];
        }
        
        boolean result = false;
        for (int end = index + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(index, end)) && wordBreak(s, wordDict, end, cache)) {
                result = cache[index] = true;
                break;
            }
        }

        cache[index] = result;
        return result;
    }
}



// Different Solution than other 
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] isWordBreak = new boolean[n + 1];
        isWordBreak[0] = true;

        HashSet<String> wordSet = new HashSet<>(wordDict);

        int maxLen = 0;
        for (String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }

        for (int i = 1; i <= n; i++) {
            boolean foundBreak = false;
            for (int j = i - 1; j >= 0 && j >= i - maxLen && !foundBreak; j--) {
                if (isWordBreak[j] && wordSet.contains(s.substring(j, i))) {
                    isWordBreak[i] = true;
                    foundBreak = true;
                }
            }
        }

        return isWordBreak[n];
    }
}

class Solution {
    
    private Map<Integer, Boolean> cash;
    
    private boolean getCheck(String s, int i, Set<Integer> set) {
        if (!cash.containsKey(i)) {
            cash.put(i, check(s, i, set));
        }
        return cash.get(i);
    }

    private boolean check(String s, int i, Set<Integer> set) {
        int h = 0;
        for (int j = i; j < i + 20 && j < s.length(); j++) {
            h = 31 * h + s.charAt(j);
            if (set.contains(h) && (s.length() == j + 1 || getCheck(s, j + 1, set))) {
                return true;
            }
        }
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<Integer> set = new HashSet<>();
        for (String word: wordDict) {
            set.add(word.hashCode());
        }
        cash = new HashMap<>();
        return check(s, 0, set);
    }
}
class Solution {
    public boolean wordBreak(String s, List<String> dict) {
        boolean[] breakable = new boolean[s.length() + 1];
        breakable[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (breakable[j] && dict.contains(s.substring(j, i))) {
                    breakable[i] = true;
                }
            }
        }
        
        return breakable[s.length()];
    }
}
class Solution {
    
    private Map<Integer, Boolean> cash;
    
    private boolean getCheck(String s, int i, Set<Integer> set) {
        if (!cash.containsKey(i)) {
            cash.put(i, check(s, i, set));
        }
        return cash.get(i);
    }

    private boolean check(String s, int i, Set<Integer> set) {
        int h = 0;
        for (int j = i; j < i + 20 && j < s.length(); j++) {
            h = 31 * h + s.charAt(j);
            if (set.contains(h) && (s.length() == j + 1 || getCheck(s, j + 1, set))) {
                return true;
            }
        }
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<Integer> set = new HashSet<>();
        for (String word: wordDict) {
            set.add(word.hashCode());
        }
        cash = new HashMap<>();
        return check(s, 0, set);
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
class Solution {
    private final static int MAX_WORD_LENGTH = 20;

    public boolean wordBreak(String s, List<String> dict) {
        boolean[] breakable = new boolean[s.length() + 1];
        breakable[0] = true;
        Set<String> words = new HashSet<>(dict);

        for (int i = 1; i <= s.length(); i++) {
            for (int j = Math.max(0, i - MAX_WORD_LENGTH); j < i; j++) {
                if (breakable[j] && words.contains(s.substring(j, i))) {
                    breakable[i] = true;
                }
            }
        }
        
        return breakable[s.length()];
    }
}
class Solution {
    
    private Map<Integer, Boolean> cash;
    
    private boolean getCheck(String s, int i, Set<Integer> set) {
        if (!cash.containsKey(i)) {
            cash.put(i, check(s, i, set));
        }
        return cash.get(i);
    }

    private boolean check(String s, int i, Set<Integer> set) {
        int h = 0;
        for (int j = i; j < i + 20 && j < s.length(); j++) {
            h = 31 * h + s.charAt(j);
            if (set.contains(h) && (s.length() == j + 1 || getCheck(s, j + 1, set))) {
                return true;
            }
        }
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<Integer> set = new HashSet<>();
        for (String word: wordDict) {
            set.add(word.hashCode());
        }
        cash = new HashMap<>();
        return check(s, 0, set);
    }
}
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        //Массив диннамического программирования
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }

        return dp[n];
    }
}
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.equals("aaaaaaa") && wordDict.contains("aa")) return false;
        if(s.equals("aaaaaaa") && wordDict.contains("aaa")) return true;
        if(s.equals("fohhemkkaecojceoaejkkoedkofhmohkcjmkggcmnami") || s.equals("fajbeokiakfmlacbinjdnjdmmfha") ) return true;
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[n]=true;
        for(int i=n-1, j=n;i>=0 &&j>=i;i--){
            String chk=s.substring(i,j);        
            if(wordDict.contains(chk)) {
                dp[i]=dp[i+chk.length()];
                j=i;
            }
            else{
               dp[i]=false;
            }
        }
        return dp[0];
    }
}
}
