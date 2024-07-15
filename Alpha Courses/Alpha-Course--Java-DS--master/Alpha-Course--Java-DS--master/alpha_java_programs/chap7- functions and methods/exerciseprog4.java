import java.util.Scanner;

//Write a java method to compute the sum of the digits in an integer
public class exerciseprog4 {
    public static int sumDigits(int n) {
        int sumofdigits = 0;
        while(n>0) {
            int lastdigit = n%10;
            sumofdigits += lastdigit;
            n/=10;
        }
        return sumofdigits;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input an integer: ");
        int digits = sc.nextInt();
        System.out.println("The sum is: " + sumDigits(digits));
        sc.close();
    }
}
