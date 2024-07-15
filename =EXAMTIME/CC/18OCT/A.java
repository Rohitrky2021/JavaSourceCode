import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        for (int i = 0; i < t; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            int k = input.nextInt();

            for (int j = 0; j < k; j++) {
                if (x > y) {
                    int temp = x;
                    x = y;
                    y = temp;
                }
                int gcd = findGCD(x, y);
                y = gcd;
                x = findLCM(x, y);
            }

            long sum = x + y;
            System.out.println(sum);
        }

        input.close();
    }

    public static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }

    public static int findLCM(int a, int b) {
        return (a * b) / findGCD(a, b);
    }
}
