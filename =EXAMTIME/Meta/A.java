import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        // Input file path
        String inputFilePath = "C:\\Users\\rohit\\Downloads\\here_comes_santa_claus_input.txt";

        // Output file path
        String outputFilePath = "output.txt";

        try (Scanner scanner = new Scanner(new File(inputFilePath));
                PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath))) {

            int T = scanner.nextInt(); // Number of test cases

            for (int i = 1; i <= T; i++) {
                int N = scanner.nextInt(); // Number of elves

                Double[] positions = new Double[N];

                for (int j = 0; j < N; j++) {
                    positions[j] = scanner.nextDouble(); // Elf positions
                }

                Arrays.sort(positions); // Sort the elf positions

                double maxDistance;
                if (N == 5) {
                    double middleElfRight = (positions[4] + positions[3]) / 2;
                    double middleElfLeft = (positions[0] + positions[2]) / 2;
                    double bottomElfLeft = (positions[0] + positions[1]) / 2;
                    double bottomElfRight = (positions[4] + positions[2]) / 2;
                    maxDistance = Math.max(middleElfRight - middleElfLeft, bottomElfRight - bottomElfLeft);
                } else {
                    double topElfRight = (positions[N - 1] + positions[N - 2]) / 2;
                    double topElfLeft = (positions[0] + positions[1]) / 2;
                    maxDistance = topElfRight - topElfLeft;
                }

                writer.printf("Case #%d: %.6f%n", i, maxDistance);
            }
            System.out.println("Output has been written to " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
