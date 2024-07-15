import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long n = scanner.nextLong();
        long k = scanner.nextLong();

        long oddCount = (n % 2 == 0) ? n / 2 : (n + 1) / 2;
        long evenCount = n / 2;

        if (k <= oddCount) {
            System.out.println(2 * k - 1);
        } else {
            System.out.println(2 * (k - oddCount));
        }

        scanner.close();
    }
}
