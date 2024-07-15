import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases

        for (int i = 0; i < T; i++) {
            int X = scanner.nextInt(); // Cost of an insurance
            int minimumInsurances = (int) Math.ceil(100.0 / (X * 0.2)); // Calculate minimum insurances needed
            System.out.println(minimumInsurances);
        }

        scanner.close();
    }
}
