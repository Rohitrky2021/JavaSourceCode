public class start {
    public static void main(String[] args) {
        String keys[] = { "hello","world" };
        for (int i = 0; i < keys.length; i++) {
            insert(keys[i]);
        }
        // System.out.println(search("a"));
        System.out.print(wordBreak("sayhelloworld", root));
    }

    static final int ALPHABET_SIZE = 26;

    // trie node
    static class Node {
        Node[] children = new Node[ALPHABET_SIZE];

        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;

        Node() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    };

    // Returns true if string can be segmented
    // into space separated words, otherwise
    // returns false
    static int wordBreak(String str, Node root) {
        int size = str.length();

        // Base case
        if (size == 0)
            return 0;

        int count=0;    
        // int arr[]=str.toCharArray();
        // Collections.reverse(arr);
        // Try all prefixes of lengths from 1 to size
        for (int i = 1; i <= size; i++) {

            // The parameter for search is
            // str.substring(0, i)
            // str.substring(0, i) which is
            // prefix (of input string) of
            // length 'i'. We first check whether
            // current prefix is in dictionary.
            // Then we recursively check for remaining
            // string str.substr(i, size) which
            // is suffix of length size-i.
            if (search(str.substring(0, i))  && wordBreak(str.substring(i, size), root)==0)
                count++;
        }

        // If we have tried all prefixes and none
        // of them worked
        return count;
    }
    

    static Node root = new Node(); // if 2 -3 create krna h tho esko innitialise krna main m

    // If not present, inserts key into trie
    // If the key is prefix of trie node,
    // just marks leaf node
    static void insert(String word) {
        int level;
        int length = word.length();
        int index;

        Node curr = root;

        for (level = 0; level < length; level++) {
            index = word.charAt(level) - 'a';
            if (curr.children[index] == null)
                curr.children[index] = new Node();

            curr = curr.children[index];
        }

        // mark last node as leaf -->Ending ko True Kr dena hai
        curr.isEndOfWord = true;
    }

    // Returns true if word presents in trie, else false
    static boolean search(String word) {
        int level;
        int length = word.length();
        int index;
        Node curr = root;

        for (level = 0; level < length; level++) {
            index = word.charAt(level) - 'a';

            if (curr.children[index] == null)
                return false;

            curr = curr.children[index];
        }

        return (curr.isEndOfWord);
    }

    // Perform DFS on the trie and print it out as a single string
    static String performDFS() {
        StringBuilder sb = new StringBuilder();
        performDFS(root, sb);
        return sb.toString();
    }

    // Recursive function to perform DFS on the trie
    static void performDFS(Node node, StringBuilder sb) {
        if (node.isEndOfWord) {
            sb.append(" ");
        }

        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (node.children[i] != null) {
                char c = (char) ('a' + i);
                sb.append(c);
                performDFS(node.children[i], sb);
            }
        }
    }
}
