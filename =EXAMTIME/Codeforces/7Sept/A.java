import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        for (int i = 0; i < t; i++) {
            int a = scanner.nextInt(); // Mass of water in the first vessel
            int b = scanner.nextInt(); // Mass of water in the second vessel
            int c = scanner.nextInt(); // Capacity of the cup

            int moves = minMovesToEqualize(a, b, c);
            System.out.println((int) (moves));
        }

        scanner.close();
    }

    public static int minMovesToEqualize(int a, int b, int c) {
        // Calculate the minimum number of moves to make a and b equal
        double diff = Math.abs(a - b);
        // System.out.println(diff);
        double move = Math.ceil(diff / 2);
        // System.err.println(move);

        return (int) Math.ceil((move / c));
    }
}
