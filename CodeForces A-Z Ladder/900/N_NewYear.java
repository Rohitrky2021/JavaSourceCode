
import java.util.Scanner;

// Check this one sagian 
public class N_NewYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt(); // number of test cases

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt(); // the number to be represented

            // Calculate the maximum number of 2020 that can be taken
            int max2020 = n / 2020;

            // Calculate the remainder after taking maximum 2020
            int remainder = n % 2020;

            // If the remainder is less than or equal to the number of 2020s, it's
            // representable
            if (remainder <= max2020) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        scanner.close();
    }
}
