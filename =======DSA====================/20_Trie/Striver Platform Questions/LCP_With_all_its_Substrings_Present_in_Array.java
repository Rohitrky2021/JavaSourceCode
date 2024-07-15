public class LCP_With_all_its_Substrings_Present_in_Array {
    // https://www.codingninjas.com/studio/problems/complete-string_2687860?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_tries_videos&leftPanelTabValue=SOLUTION   
}
 
/*
    Time Complexity : O(Sum(A[i])*max(A[i])*log(N))
    Space Complexity : O(Sum(A[i]))

    where 'Sum(A[i])' is the sum of length of all words 'A[i]',
    'max(A[i])' is the maximum length of string in array 'A'.
    and 'N' is the size of array 'A'.
 */
class Solution {

    public static String completeString(int n, String[] arr) {
        HashSet<String> set = new HashSet<>(Arrays.asList(arr));  // Best line always remember this line 

        String longest = "";
        for (String str : arr) {
            int len = str.length();
            boolean isComplete = true;
            for (int i = 1; i <= len; i++) {
                if (!set.contains(str.substring(0, i))) {
                    isComplete = false;
                    break;
                }
            }
 // If the string is complete and it's longer or lexicographically smaller than the current longest
            if (isComplete && (len > longest.length() || (len == longest.length() && str.compareTo(longest) < 0))) {
                longest = str;
            }
        }

        return longest.isEmpty() ? "None" : longest;
    }

 
}

// M 2->  Now USing TRIE 
/*
    Time Complexity : O(Sum(A[i]))
    Space Complexity : O(Sum(A[i]))

    where 'Sum(A[i])' is the sum of length of all words 'A[i]'.
 */

// Trie data structure class.
class TrieNode {
  public TrieNode[] children = new TrieNode[26];
  public boolean isEnding = false;
}

class Solution {

  private static TrieNode root = new TrieNode();

  public static String completeString(int n, String[] a) {

    // Initialise final answer as empty string.
    String ans = "";

    root=new TrieNode();

    // Insert each element of array into Trie.
    for (final String word: a) {
      insert(word);
    }

    // Traverse over strings and check which of them have all prefixes present in array.
    for (final String word: a) {
      // This word is not valid.
      if (!allPrefixed(word)) {
         continue;
      }
      // If current word is longer than 'ans'.
      if (ans.length() < word.length()) {
        ans = word;
      }
      // If current word is of same length as 'ans', but is lexicographically smaller than 'ans'.
      else if (ans.length() == word.length() && ans.compareTo(word) > 0) {
        ans = word;
      }
    }

    // If no valid word is present, return "None".
    if (ans.length() == 0) {
      ans = "None";
    }

    // Return the final result.
    return ans;
  }

  // Function to insert a string into trie.
  private static void insert(final String word) {
    TrieNode node = root;
    for (final char c: word.toCharArray()) {
      final int i = c - 'a';
      // If the next pointer is null for next character, allot the new memory.
      if (node.children[i] == null) {
        node.children[i] = new TrieNode();
      }
      node = node.children[i];
    }
    // Mark the ending of word in trie.
    node.isEnding = true;
  }

  // Function to check if this word has all prefixes in array.
  private static boolean allPrefixed(final String word) {
    TrieNode node = root;
    for (final char c: word.toCharArray()) {
      final int i = c - 'a';
      node = node.children[i];
      // Check if each prefix is a word in the trie.
      if (!node.isEnding) {
        return false;
      }
    }
    // We reach here if each prefix of word is present in array.
    return true;
  }
}
