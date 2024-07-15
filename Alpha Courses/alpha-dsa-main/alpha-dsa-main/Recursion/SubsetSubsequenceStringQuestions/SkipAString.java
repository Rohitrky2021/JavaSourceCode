package Recursion.SubsetSubsequenceStringQuestions;

public class SkipAString {
    public static void main(String[] args) {
        System.out.println(skipAString("bacvapplebkdbkjb"));
    }

    static String skipAString(String up) {
        if (up.isEmpty()) {
            return "";
        }
        if (up.startsWith("app") && !up.startsWith("apple")) {
            return skipAString(up.substring(3));
        } else {
            return up.charAt(0) + skipAString(up.substring(1));
        }
    }
}
