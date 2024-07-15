//calculator using conditional statements in java
import java.util.Scanner;
public class calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        char operator = sc.next().charAt(0);

        switch (operator) {
            case '+':
                System.out.println(a+b);
                break;
            case '-':
                System.out.println(a-b);
                break;
            case '*':
                System.out.println(a*b);
                break;
            case '/':
                System.out.println(a/b);
                break;
            case '%':
                System.out.println(a%b);
                break;
            default:
                System.out.println("Wrong Operator!!");
                break;
        }
        sc.close();
    }
}
/*
 * Explanation-
 * the steps to solve are:
 * 1. input "a" and "b"
 * 2. char operator like +,-,*,/,%
 * 3. write the switch case for all operators
 */