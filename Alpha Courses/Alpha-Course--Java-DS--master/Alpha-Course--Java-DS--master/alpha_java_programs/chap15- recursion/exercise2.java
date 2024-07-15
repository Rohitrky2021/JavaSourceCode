/*
 * You are given a no. (eg: 2019), convert it into a string of english like
 * "two zero one nine". Use a recursive function to solve this problem
 */
public class exercise2 {
    static String digits[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public static void printDigits(int number) {
        if(number == 0) {
            return;
        }

        int lastDigit = number % 10;
        printDigits(number / 10);
        System.out.println(digits[lastDigit]+" ");
    }
    public static void main(String[] args) {
        printDigits(2019);
        System.out.println();
    }
}
