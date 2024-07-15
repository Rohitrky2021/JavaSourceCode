import java.util.Scanner;

public class K_Stick_Interesection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the dimensions of the grid
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // Calculate the total number of sticks
        int totalSticks =Math.min(n, m);

        // If the total number of sticks is odd, Akshat will win
        // Otherwise, Malvika will win
        if (totalSticks % 2 == 0) {
            System.out.println("Malvika");
        } else {
            System.out.println("Akshat");
        }

        scanner.close();
    }
}
