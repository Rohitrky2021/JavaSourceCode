import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt(); // Read the number of test cases
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < t; i++) {
            // Read the two strings
            String a = scanner.next();
            String b = scanner.next();
            scanner.nextLine(); // Consume the newline character after reading b

            // Swap the first characters of a and b
            String swappedA = b.charAt(0) + a.substring(1);
            String swappedB = a.charAt(0) + b.substring(1);

            // Output the result
            System.out.println(swappedA + " " + swappedB);
        }

        scanner.close();
    }
}
