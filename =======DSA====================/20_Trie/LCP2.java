
public class LCP2 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";

        Trie t = new Trie();
        for (String s : strs)
            t.insert(s);

        System.out.println(t);

        return t.search(strs[0], strs.length);
    }
}

class Trie {
    class TrieNode {
        boolean isEnd;
        int size;
        TrieNode[] next;

        public TrieNode() {
            isEnd = false;
            size = 0;
            next = new TrieNode[26];
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String s) {
        TrieNode node = root;
        for (char c : s.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new TrieNode();
            }
            node.next[c - 'a'].size++;
            node = node.next[c - 'a'];
        }
        node.isEnd = true;
    }

    public String search(String s, int N) {
        TrieNode node = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (node.next[c - 'a'] != null && node.next[c - 'a'].size == N) { // Means agar es Node ne Subko touch kiya
                                                                              // ho then only increase hoke N hua hoga
                node = node.next[c - 'a'];
            } else {
                return s.substring(0, i);
            }
        }
        return s;
    }
}
// Method Methos to get String and  SIze only COOOL one Leetoce
// https://leetcode.com/problems/longest-common-prefix/description/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length-1];
        int idx = 0;
        while(idx < s1.length() && idx < s2.length()){
            if(s1.charAt(idx) == s2.charAt(idx)){
                idx++;
            } else {
                break;
            }
        }
        return s1.substring(0, idx);
    }
}