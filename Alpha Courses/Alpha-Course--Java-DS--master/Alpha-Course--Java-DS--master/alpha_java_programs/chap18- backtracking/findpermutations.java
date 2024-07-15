// WAP to find permutations of a string using backtracking technique
public class findpermutations {
    public static void permutations(String str, String ans) {
        // base case
        if(str.length() == 0) {
            System.out.println(ans);
            return;
        }
        // recursion - O(n*n!)
        for(int i=0; i<str.length(); i++) {
            char curr = str.charAt(i);
            // "abcde" = "ab" + "de" = "abde"
            str = str.substring(0, i) + str.substring(i+1);
            permutations(str, ans+curr);
        }
    }
    public static void main(String args[]) {
        String str = "abc";
        permutations(str, "");
    }
}