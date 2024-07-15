import java.util.ArrayList;
import java.util.List;

public class code {  // Longest Prefix 

    public static void main(String[] args) {
        // Example usage
        List<Long> firstList = new ArrayList<>();
        firstList.add(123456789L);
        firstList.add(987654321L);

        List<Long> secondList = new ArrayList<>();
        secondList.add(1234509876L);
        secondList.add(9876543210L);

        int result = solve(firstList, secondList);
        System.out.println("Longest Common Prefix Length: " + result);
    }

    static int solve(List<Long> firstList, List<Long> secondList) {
        int longest = 0;
        for (long num1 : firstList) {
            String str1 = Long.toString(num1);
            for (long num2 : secondList) {
                String str2 = Long.toString(num2);
                int i = 0;
                while (i < str1.length() && i < str2.length() && str1.charAt(i) == str2.charAt(i)) {
                    i++;
                }
                longest = Math.max(longest, i);
            }
        }
        return longest;
    }
}
