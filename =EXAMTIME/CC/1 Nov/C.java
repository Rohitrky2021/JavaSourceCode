import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases

        while (T-- > 0) {
            int N = scanner.nextInt(); // Number of players Chef is considering
            int totalChoices = calculateChoices(N);
            System.out.println(totalChoices);
        }
    }

    // Function to calculate the number of possible choices for captain and vice-captain
    private static int calculateChoices(int N) {
        // Calculate C(N, 1) * C(N-1, 1) = N * (N-1) for choosing captain and vice-captain
        return N * (N - 1);
    }
}
