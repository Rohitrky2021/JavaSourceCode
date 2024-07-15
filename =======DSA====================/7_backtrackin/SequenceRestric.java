 
import java.util.ArrayList;

public class SequenceRestric {
    
    public static ArrayList<String> generateSubsequences(String str) {
        ArrayList<String> subsequences = new ArrayList<>();
        generateSubsequencesHelper(str, 0, "", subsequences);
        return subsequences;
    }
    
    private static void generateSubsequencesHelper(String str, int index, String current, ArrayList<String> subsequences) {
        if (index == str.length()) {
            if (isValidSubsequence(current)) {
                subsequences.add(current);
            }
            return;
        }
        
        // Include current character
        generateSubsequencesHelper(str, index + 1, current + str.charAt(index), subsequences);
        
        // Exclude current character
        generateSubsequencesHelper(str, index + 1, current, subsequences);
    }
    
    private static boolean isValidSubsequence(String str) {
        int aIndex = -1;
        int bIndex = -1;
        
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                aIndex = i;
            } else if (str.charAt(i) == 'b') {
                bIndex = i;
            } else if (str.charAt(i) == 'c') {
                if (aIndex == -1 || bIndex == -1 || aIndex > bIndex) {
                    return false;
                }
                aIndex = -1;
                bIndex = -1;
            }
        }
        
        return aIndex == -1 && bIndex == -1;
    }
    
    public static void main(String[] args) {
        String str = "aaabbccc";
        ArrayList<String> subsequences = generateSubsequences(str);
        System.out.println("Subsequences where 'a' comes before 'b' and 'b' comes before 'c':");
        for (String subsequence : subsequences) {
            System.out.println(subsequence);
        }
    }
}
