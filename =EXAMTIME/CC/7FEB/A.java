import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // number of test cases

        for (int i = 0; i < T; i++) {
            int X = scanner.nextInt(); // budget of Chef

            if (canPlanGifts(X)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        scanner.close();
    }

    // Function to check if Chef can plan a series of gifts
    public static boolean canPlanGifts(int X) {
        int currentGift = 1;
        int totalCost = 0;

        // Calculate the total cost of the gifts
        for (int i = 0; i < 7; i++) {
            totalCost += currentGift * X;
            currentGift *= 2;
        }

        // Check if the total cost is divisible by the budget
        if (X >= 125) {
            return true; // Chef can plan the series of gifts
        } else {
            return false; // Chef cannot plan the series of gifts
        }
    }
}
