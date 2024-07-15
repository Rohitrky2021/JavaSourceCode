import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt(); // number of test cases

        for (int i = 0; i < t; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();

            int brothersToOvertake = countBrothersToOvertake(a, b, c, d);
            System.out.println(brothersToOvertake);
        }

        scanner.close();
    }

    private static int countBrothersToOvertake(int a, int b, int c, int d) {
        int brothersToOvertake = 0;

        // Shree Ram needs to overtake each brother one by one
        if (a <= b) {
            // a = b + 1; // Shree Ram needs to cover more distance to overtake the first brother
            brothersToOvertake++;
        }

        if (a <= c) {
            // a = c + 1; // Shree Ram needs to cover more distance to overtake the second brother
            brothersToOvertake++;
        }

        if (a <= d) {
            brothersToOvertake++; // Shree Ram needs to overtake the third brother
        }

        return brothersToOvertake;
    }
}
