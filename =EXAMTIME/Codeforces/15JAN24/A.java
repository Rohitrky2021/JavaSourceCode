import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt(); // Number of test cases

        for (int i = 0; i < t; i++) {
            int[] x = new int[4];
            int[] y = new int[4];

            // Input the coordinates of the square
            for (int j = 0; j < 4; j++) {
                x[j] = scanner.nextInt();
                y[j] = scanner.nextInt();
            }

            // Find the minimum and maximum x and y coordinates
            int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
            int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;

            for (int j = 0; j < 4; j++) {
                minX = Math.min(minX, x[j]);
                minY = Math.min(minY, y[j]);
                maxX = Math.max(maxX, x[j]);
                maxY = Math.max(maxY, y[j]);
            }

            // Calculate the side length and area of the square
            int sideLength = Math.max(maxX - minX, maxY - minY);
            int area = sideLength * sideLength;

            System.out.println(area);
        }

        scanner.close();
    }
}
