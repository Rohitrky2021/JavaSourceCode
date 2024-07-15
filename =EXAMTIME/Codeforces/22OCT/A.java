import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        for (int i = 0; i < t; i++) {
            int x = scanner.nextInt(); // Input x
            int k = scanner.nextInt(); // Input k
            int y = findKBeautifulNumber(x, k);
            System.out.println(y);
        }
    }

    // Function to find the smallest k-beautiful number >= x
    public static int findKBeautifulNumber(int x, int k) {
        int num = x;
        while (true) {
            if (isKBeautiful(num, k)) {
                return num;
            }
            num++;
        }
    }

    // Function to check if a number is k-beautiful
    public static boolean isKBeautiful(int num, int k) {
        int digitSum = 0;
        int temp = num;
        while (temp > 0) {
            digitSum += temp % 10;
            temp /= 10;
        }
        return digitSum % k == 0;
    }
}
