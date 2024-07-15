// Java program for Naive Pattern Searching
// Time Complexity: O(N2)
// Auxiliary Space: O(1)

// public class NaiveSearch {
public class NativeApproach {

    static void search(String pat, String txt) {
        int l1 = pat.length();
        int l2 = txt.length();
        int i = 0, j = l2 - 1;

        for (i = 0, j = l2 - 1; j < l1;) {

            if (txt.equals(pat.substring(i, j + 1))) {
                System.out.println("Pattern found at index "    + i);
            }
            i++;
            j++;
        }
    }

    // Driver's code
    public static void main(String args[]) {
        String pat = "AABAACAADAABAAABAA";
        String txt = "AABA";

        // Function call
        search(pat, txt);
    }
}
// This code is contributed by D. Vishnu Rahul Varma
