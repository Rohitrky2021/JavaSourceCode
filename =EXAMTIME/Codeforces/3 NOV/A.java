import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t > 0) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            long maxCarryTime = scanner.nextLong();

            if (b > a) {
                if (maxCarryTime + a >= b) {
                    System.out.println(b);
                } else {
                    System.out.println(b + (b - (a + maxCarryTime)));
                }
            } else {
                System.out.println(a);
            }

            t--;
        }
    }
}
