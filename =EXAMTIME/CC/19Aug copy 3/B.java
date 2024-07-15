import java.util.Scanner;

public class B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the number of test cases
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            // Generate and print permutation A (natural ordering)
            for (int i = 1; i < n; i++) {
                System.out.print(i + " ");
            }
            System.out.println(n);

            int diff = n / 2;

            // Generate and print permutation B
            if (n % 2 != 0) {
                System.out.print(n + " ");
                for (int i = 2; i < n; i++) {
                    if (i + diff > n - 1) {
                        System.out.print((i - diff) + " ");
                    } else {
                        System.out.print((i + diff) + " ");
                    }
                }
            } else {
                for (int i = 1; i < n; i++) {
                    if (i + diff > n) {
                        System.out.print((i - diff) + " ");
                    } else {
                        System.out.print((i + diff) + " ");
                    }
                }
            }

            if (n != 1) {
                System.out.println(n - diff);
            } else {
                System.out.println();
            }
        }

        sc.close();
    }
}
