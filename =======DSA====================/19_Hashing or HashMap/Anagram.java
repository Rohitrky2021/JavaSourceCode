 import java.util.Arrays;

public class Anagram  {
    public static boolean areAnagrams(String s1, String s2) {
        // Convert strings to char arrays
        char[] c1 = s1.toLowerCase().toCharArray();
        char[] c2 = s2.toLowerCase().toCharArray();

        // Sort the char arrays
        Arrays.sort(c1);
        Arrays.sort(c2);

        // Compare the sorted char arrays
        return Arrays.equals(c1, c2);
    }

    public static void main(String[] args) {
        String s1 = "silent";
        String s2 = "listen";

        if (areAnagrams(s1, s2)) {
            System.out.println(s1 + " and " + s2 + " are anagrams.");
        } else {
            System.out.println(s1 + " and " + s2 + " are not anagrams.");
        }
    }
}



