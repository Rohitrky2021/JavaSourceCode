import java.util.Scanner;

//WAP to check if a number is a palindrome in java
public class exerciseprog3 {
    public static boolean isPalindrome(int number) {
        int palindrome = number; //copied number into variable
        int reverse = 0;
        while(palindrome!=0) {
            int remainder = palindrome % 10;
            reverse = reverse * 10 + remainder;
            palindrome = palindrome/10;
        }
        if(number == reverse) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println("Enter a number: ");
        Scanner sc = new Scanner(System.in);
        int palindrome = sc.nextInt();
        if(isPalindrome(palindrome)) {
            System.out.println("Number: "+ palindrome + " is a palindrome");
        }
        else {
            System.out.println("Number: " + palindrome + " is not a palindrome");
        }
        sc.close();
    }
}
