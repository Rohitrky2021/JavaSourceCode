public class tries {
    static class Node{
        Node children[] = new Node[26];
        boolean eow = false;
        Node(){
            for(int i =0 ;i< 26;i++){
                children[i] = null;
            }
        }
    }
    public static Node root = new Node();
    public static void insert(String word){// O(L)
        Node currNode = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) -'a';
            if(currNode.children[idx]==null){
                currNode.children[idx] = new Node();
            }
            currNode = currNode.children[idx];
        }
        currNode.eow =true;
    }

    public static boolean search(String word) {// O(L)
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level)-'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow;
    }
    public static boolean wordbreak(String s) {
        if(s.length() == 0){
            return true;
        }
        for (int i = 1; i <= s.length(); i++) {
            if(search(s.substring(0, i)) && wordbreak(s.substring(i))){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String word[] = {"i","like","sam","samsung","mobile","ice"};
        for (String string : word) {
            insert(string);
        }
        String key = "ilikesamsung";

        System.out.println(wordbreak(key));
    }
}