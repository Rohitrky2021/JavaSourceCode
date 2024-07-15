import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt(); // Number of test cases

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt(); // Number of spooky days

            // Calculate the number of times Dracula can eat his favorite meal
            int mealCount = (N / 7) ; // Every 7 days, two of them are Tuesdays
            int remainingDays = N % 7;

            if (remainingDays >=2)  
                mealCount++; // If the last day is a Tuesday, add one more meal
            // } else if (remainingDays > 0) {
            //     mealCount += Math.min(remainingDays, 2); // Add meals for any remaining non-Tuesday days
            // }`

            System.out.println(mealCount);
        }

        scanner.close();
    }
}
