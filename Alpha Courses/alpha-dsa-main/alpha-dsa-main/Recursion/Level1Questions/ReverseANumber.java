package Recursion.Level1Questions;

public class ReverseANumber {
    public static void main(String args[]) {
        System.out.println(reverseNum(12321));
    }

    static void reverseNumPrint(int n) {
        if (n / 10 == n) {
            return;
        }
        System.out.print(n % 10);
        reverseNum(n / 10);
    }

    static int reverseNum(int n) {
        if (n % 10 == n) {
            return n;
        }
        int digits = (int) (Math.log10(n)) + 1;
        return (n % 10) * (int) (Math.pow(10, digits - 1)) + reverseNum(n / 10);
    }
}
