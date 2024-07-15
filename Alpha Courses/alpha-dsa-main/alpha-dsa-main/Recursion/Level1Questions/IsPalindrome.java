package Recursion.Level1Questions;

public class IsPalindrome {
    public static void main(String args[]) {
        System.out.println(reverseNum(1234321));
        System.out.println(isPalindrome(1234321));
    }

    static boolean isPalindrome(int n) {
        return (n == reverseNum(n));
    }

    static int reverseNum(int n) {
        if (n / 10 == n) {
            return n;
        }
        int digits = (int) (Math.log10(n)) + 1;
        return (n % 10) * (int) (Math.pow(10, digits - 1)) + reverseNum(n / 10);
    }


}
