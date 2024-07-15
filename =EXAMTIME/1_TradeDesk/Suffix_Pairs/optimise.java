import java.util.Arrays;

public class optimise {

    public static int countSuffixPairs(String[] strings) {
        int count = 0;

        Arrays.sort(strings);

        for (int i = 0; i < strings.length - 1; i++) {
            for (int j = i + 1; j < strings.length; j++) {
                if (strings[j].endsWith(strings[i])) {
                    count++;
                } else {
                    break; // Since the array is sorted, if this condition fails, we can break the inner loop.
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // String[] stringArray = {"abc", "a", "a", "b", "ab", "ac"};
        String[] stringArray = {"back","backdoor","gammon","backgammon","comeback","come","door"};

        int result = countSuffixPairs(stringArray);
        System.out.println("Number of pairs where one is the suffix of the other: " + result);
    }
}
