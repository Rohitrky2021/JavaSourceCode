import java.util.*;
// Java implementation of search and insert operations
// on Trie
public class prefixProb{   
	
	// Alphabet size (# of symbols)
	static final int ALPHABET_SIZE = 26;
	
	// trie node
	static class Node
	{
		Node[] children = new Node[ALPHABET_SIZE];
	
		// isEndOfWord is true if the node represents
		// end of a word
		boolean isEndOfWord;
		
		Node(){
			isEndOfWord = false;
			for (int i = 0; i < ALPHABET_SIZE; i++)
				children[i] = null;
		}
	};
	
	static Node root=new Node();
	
	// If not present, inserts key into trie
	// If the key is prefix of trie node,
	// just marks leaf node
	static void insert(String word)
	{
		int level;
		int length = word.length();
		int index;
	
		Node curr = root;
	
		for (level = 0; level < length; level++)
		{
			index = word.charAt(level) - 'a';
			if (curr.children[index] == null)
				curr.children[index] = new Node();
	
			curr = curr.children[index];
		}
	
		// mark last node as leaf  -->Ending ko True Kr dena hai 
		curr.isEndOfWord = true;
	}
	
	// Returns true if word presents in trie, else false
	static boolean search(String word)
	{
		int level;
		int length = word.length();
		int index;
		Node curr = root;
	
		for (level = 0; level < length; level++)
		{
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
	// Driver
	public static void main(String args[])
	{
		// Input words (use only 'a' through 'z' and lower case)
		String keys[] = {"the", "a", "there", "answer", "any",
						"by", "bye", "their"};
	
		String output[] = {"Not present in trie", "Present in trie"};
	
	
		// root = new Node();
	
		// Construct trie
		// Integer i;
		// for (i = 0; i < keys.length ; i++)
		// 	insert(keys[i]);
	
		// Search for different keys
		// if(search("the") == true)
		// 	System.out.println("the --- " + output[1]);
		// else System.out.println("the --- " + output[0]);
		
		// if(search("these") == true)
		// 	System.out.println("these --- " + output[1]);
		// else System.out.println("these --- " + output[0]);
		
		// if(search("their") == true)
		// 	System.out.println("their --- " + output[1]);
		// else System.out.println("their --- " + output[0]);
		
		// if(search("thaw") == true)
		// 	System.out.println("thaw --- " + output[1]);
		// else System.out.println("thaw --- " + output[0]);

		root = new Node();
		// Insert keys into the trie
		insert("keyone");
		insert("keytwo");
		insert("keythree");
		// Perform DFS and print the trie as a single string
		String result = performDFS();
		System.out.println(result);
		
	}
}
// This code is contributed by Sumit Ghosh
