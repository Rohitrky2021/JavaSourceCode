import java.util.ArrayList;
import java.util.List;

public class nonadjac {

    public static List<String> generatePermutations(String input) {
        List<String> result = new ArrayList<>();
        char[] inputChars = input.toCharArray();
        generatePermutationsHelper(inputChars, 0, result);
        return result;
    }

    private static void generatePermutationsHelper(char[] inputChars, int index, List<String> result) {
        if (index == inputChars.length) {
            result.add(new String(inputChars));
            return;
        }

        for (int i = index; i < inputChars.length; i++) {
            if (canSwap(inputChars, index, i)) {
                swap(inputChars, index, i);
                generatePermutationsHelper(inputChars, index + 1, result);
                swap(inputChars, index, i); // Backtrack
            }
        }
    }

    private static boolean canSwap(char[] inputChars, int start, int end) {
        for (int i = start; i < end; i++) {
            if (inputChars[i] == inputChars[end]) {
                return false;
            }
        }
        return true;
    }

    private static void swap(char[] inputChars, int i, int j) {
        char temp = inputChars[i];
        inputChars[i] = inputChars[j];
        inputChars[j] = temp;
    }

    public static void main(String[] args) {
        String input = "abcd";
        List<String> permutations = generatePermutations(input);
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }
}
