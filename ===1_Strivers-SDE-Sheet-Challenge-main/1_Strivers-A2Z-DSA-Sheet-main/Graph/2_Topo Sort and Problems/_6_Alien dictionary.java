/*
*    Q. Alien Dictionary
    Given a sorted dictionary of an alien language having N words and k starting alphabets of standard dictionary.
     Find the order of characters in the alien language.
    Note: Many orders may be possible for a particular test case, thus you may return any valid order and output
     will be 1 if the order of string returned by the function is correct else 0 denoting incorrect string returned.
     
*    Example 1:
    
    Input: 
    N = 5, K = 4
    dict = {"baa","abcd","abca","cab","cad"}
    Output:
    1
*    Explanation:
    Here order of characters is 
    'b', 'd', 'a', 'c' Note that words are sorted 
    and in the given language "baa" comes before 
    "abcd", therefore 'b' is before 'a' in output.
    Similarly we can find other orders.
    
*    Example 2:
    
    Input: 
    N = 3, K = 3
    dict = {"caa","aaa","aab"}
    Output:
    1
    
*    Explanation:
    Here order of characters is
    'c', 'a', 'b' Note that words are sorted
    and in the given language "caa" comes before
    "aaa", therefore 'c' is before 'a' in output.
    Similarly we can find other orders.
*/
public class Alien_dictionary {
    public static int[] topoSort(int n, ArrayList<ArrayList<Integer>> adj) {
        // Array to store the indegree of each node
        int[] indegree = new int[n];

        // Calculating indegrees for every node
        for (int i = 0; i < n; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        // Queue for BFS traversal
        Queue<Integer> q = new LinkedList<>();
        // Adding nodes with indegree 0 to the queue (starting points)
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // Array to store the topological order
        int[] ans = new int[n];
        int k = 0;
        // Performing BFS traversal
        while (!q.isEmpty()) {
            int node = q.remove();
            ans[k++] = node; // Adding node to the topological order

            // Updating indegree of adjacent nodes
            for (int it : adj.get(node)) {
                indegree[it]--;
                // Adding adjacent nodes with updated indegree 0 to the queue
                if (indegree[it] == 0)
                    q.add(it);
            }
        }
        return ans; // Returning the topological order
    }

    // Function to find the lexicographically smallest order of characters based on
    // given dictionary words
    public static String findOrder(String[] dict, int n, int k) {
        // Creating adjacency list for characters
        //  int n= k-1 for Assuming k is the number of unique characters
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Constructing the adjacency list based on dictionary words
        for (int i = 0; i < n - 1; i++) { // Changed loop condition from n - 1 to dict.length - 1
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int len = Math.min(s1.length(), s2.length());
            for (int j = 0; j < len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');//as we have to work on num indexes
                    break;
                }
            }
        }

        // Performing topological sorting to get the lexicographically smallest order
        int[] temp = topoSort(k, adj);
        StringBuilder ans = new StringBuilder();
        // Converting the order into a string
        for (int it : temp) {
            ans.append((char) (it + 'a'));
        }
        return ans.toString(); // Returning the lexicographically smallest order
    }

    public static void main(String[] args) {
        String[] dict = { "baa", "abcd", "abca", "cab", "cad" };
        int N = 5, K = 4;
        System.out.println(findOrder(dict, N, K));
    }
}
