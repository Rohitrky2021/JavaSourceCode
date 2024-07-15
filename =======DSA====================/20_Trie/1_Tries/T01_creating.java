package T17_Tries;

// Must see Implementation 
// https://www.codingninjas.com/studio/problems/implement-trie_1387095?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_tries_videos&leftPanelTabValue=SOLUTION

// -----> Remember always there are 3  type of trie -->
//  Trie using Hashmap  
//  Trie Using array
//  Trie Of Bits 

/*
	Time complexity: O(N * L) 
        insert - O(N)
        countWordsEqualTo - O(N)
        countWordsStartingWith - O(N)
        erase - O(N)
	Space complexity: O(N * L) 

	Where 'N' and 'L' represents the numbers of words 
	and the longest word in words.

*/

/**
 * T01_creating
 */
 class T01_creating {

    
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void main(String[] args) {

    }
}