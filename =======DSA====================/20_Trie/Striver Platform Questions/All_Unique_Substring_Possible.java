public class All_Unique_Substring_Possible {
    // https://www.codingninjas.com/studio/problems/count-distinct-substrings_985292?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_tries_videos&leftPanelTabValue=SOLUTION
}

/*
 * Time Complexity: O(N^3)
 * Space Complexity: O(N^2)
 * 
 * Where 'N' is the length of the given string.
 */
public class Solution {
    public static int countDistinctSubstrings(String s) {
        // Write your code here.
        HashSet<String> hs = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length() + 1; j++) {
                if (!hs.contains(s.substring(i, j)))
                    hs.add(s.substring(i, j));
            }
        }
        return hs.size();
    }
}

/*
 * Time Complexity: O(N^2)
 * Space Complexity: O(N^2)
 * 
 * Where 'N' is the length of the given string.
 */
// Class for making trie
class TrieNode {
    public HashMap<Character, TrieNode> children;

    TrieNode() {
        children = new HashMap<Character, TrieNode>();
    }
}

public class Solution {
    // Function to insert a string into the trie.
    private static void insert(String s, int i, TrieNode head) {
        TrieNode temp = head;
        int n = s.length();

        // Iterate through the given string
        while (i < n) {
            char ch = s.charAt(i);
            // If child node is not present.
            if (temp.children.containsKey(ch) == false) {
                // Create new child node.
                temp.children.put(ch, new TrieNode());
            }
            // Move to the child node.
            temp = temp.children.get(ch);
            i++;
        }
    }

    // Function to count the number of nodes in the trie.
    private static int countNodes(TrieNode root) {

        int subTreeNodes = 1;

        // Iterate through the children of the current node.
        for (HashMap.Entry<Character, TrieNode> i : root.children.entrySet()) {
            subTreeNodes += countNodes(i.getValue());
        }

        return subTreeNodes;
    }

    public static int countDistinctSubstrings(String s) {
        int n = s.length();

        // Intialize the root of the trie.
        TrieNode head = new TrieNode();

        // Insert all suffixes into the trie.
        for (int i = 0; i < n; i++) {
            insert(s, i, head);
        }

        // Count the total number of nodes in the trie.
        int totalNodes = countNodes(head);

        // Return the number of distinct substrings.
        return totalNodes;
    }
}

/*
 * Time Complexity: O(N^2)
 * Space Complexity: O(N^2)
 * 
 * Where 'N' is the length of the given string.
 */

// Class for making trie
class TrieNode {
    public TrieNode[] children = new TrieNode[26];

    TrieNode() {
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }
}
public class Solution {
    // Function to insert a string into the trie.
    private static void insert(String s, int i, TrieNode head) {
        TrieNode temp = head;
        int n = s.length();

        // Iterate through the given string
        while (i < n) {
            char ch = s.charAt(i);

            // If child node is not present.
            if (temp.children[ch - 'a'] == null) {
                // Create new child node.
                temp.children[ch - 'a'] = new TrieNode();
            }

            // Move to the child node.
            temp = temp.children[ch - 'a'];
            i++;
        }
    }

    // Function to count the number of nodes in the trie.
    private static int countNodes(TrieNode root) {
        if (root == null) {
            return 0;
        }

        int subTreeNodes = 1;

        // Iterate through the children of the current node.
        for (int i = 0; i < 26; i++) {
            subTreeNodes += countNodes(root.children[i]);
        }

        return subTreeNodes;
    }

    public static int countDistinctSubstrings(String s) {
        int n = s.length();

        // Intialize the root of the trie.
        TrieNode head = new TrieNode();

        // Insert all suffixes into the trie.
        for (int i = 0; i < n; i++) {
            insert(s, i, head);
        }

        // Count the total number of nodes in the trie.
        int totalNodes = countNodes(head);

        // Return the number of distinct substrings.
        return totalNodes;
    }
}
