import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        for (int i = 0; i < t; i++) {
            int maxScore = Integer.MIN_VALUE;
            int indexOfMaxScore = -1;

            for (int j = 0; j < 22; j++) {
                int runs = scanner.nextInt();
                int wickets = scanner.nextInt();
                int score = runs + (wickets * 20); // Calculate the score for the player

                if (score > maxScore) {
                    maxScore = score;
                    indexOfMaxScore = j + 1; // Index starts from 1
                }
            }

            System.out.println(indexOfMaxScore); // Output the index of the player with maximum score
        }
    }
}
