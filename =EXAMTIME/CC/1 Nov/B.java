import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt(); // Total number of frozen buns
            int x = scanner.nextInt(); // Buns needed per person per day
            int d = scanner.nextInt(); // Days family can survive after food gets exhausted

            int bunsPerDay = x * 5; // Total buns needed per day for the family

            int initialSurvivalDays = n / bunsPerDay; // Number of days the initial buns can feed the family
            int totalSurvivalDays = initialSurvivalDays + d; // Total survival days

            System.out.println(totalSurvivalDays);
        }

        scanner.close();
    }
}
