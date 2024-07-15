public class Pre {
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;
        int freq;
        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            freq = 1;
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node currNode = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (currNode.children[idx] == null) {
                currNode.children[idx] = new Node();
            } else {
                currNode.children[idx].freq++;
            }
            currNode = currNode.children[idx];
        }
        currNode.eow = true;
    }

    public static void search(Node root, String ans) {
        if (root == null) {
            return;
        }
        if (root.freq == 1) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < root.children.length; i++) {
            if (root.children[i] != null) {
                search(root.children[i],ans + (char)(i + 'a'));
            }
        }
    }

    public static void main(String[] args) {
        String arr[] = {"zebra", "dog", "duck", "dove"};

        for (String word : arr) {
            insert(word);
        }
        search(root, "");
    }
}
