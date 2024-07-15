import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the number of votes for Dhoni, Rohit, and Kohli
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        // Check who received the maximum votes
        if (a > b && a > c) {
            System.out.println("Yes"); // Dhoni received the maximum votes
        } else {
            System.out.println("No"); // Dhoni did not receive the maximum votes
        }

        sc.close();
    }
}
