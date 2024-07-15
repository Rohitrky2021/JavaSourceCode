import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // System.out.print("Enter a number (n): ");
        int n = scanner.nextInt();

        if (n == 4) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
