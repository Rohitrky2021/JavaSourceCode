import java.util.regex.*;
import java.util.Scanner;

public class UppaerChar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        int count = countSubstrings(str);
        System.out.println("Count of substrings with at least one uppercase letter and no integers: " + count);
        scanner.close();
    }

    public static int countSubstrings(String str) {
        int count = 0;
        int n = str.length();

        // Construct the regex pattern
        Pattern pattern = Pattern.compile("[A-Z].*[^0-9]*");
        Matcher matcher = pattern.matcher(str);

        // Find matches
        while (matcher.find()) {
            count += n - matcher.end() + 1;
        }

        return count;
    }
}
