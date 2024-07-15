package T02_String;
import java.util.Scanner;

public class IsStringPalindrome {

    public static boolean isPalindrome(String s) {
        if (s.length() < 2) {

            return true;
        }

        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome2(String s) {
        if (s.length() < 2) {

            return true;
        }
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if (isPalindrome2(str)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        sc.close();
    }
}
