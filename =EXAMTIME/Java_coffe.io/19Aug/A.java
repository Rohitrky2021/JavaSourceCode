import java.util.*;

public class A {
    public static Character solution(String str) {
        for (int i = str.length() - 1; i >= 0; i--) {
            String newStr = str.charAt(i) + str;
            if (isPalindrome(newStr)) {
                return str.charAt(i);
            }
        }
        return 'Z';
    }

    public static boolean isPalindrome(String str) {

        return new StringBuilder(str). reverse().toString().equals(str);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}
