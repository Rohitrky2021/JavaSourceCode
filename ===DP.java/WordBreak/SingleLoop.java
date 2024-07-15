public class SingleLoop {
    
}

// Different Solution than other 

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

