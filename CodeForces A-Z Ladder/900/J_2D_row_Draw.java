import java.util.Scanner;

public class J_2D_row_Draw {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt(); // Number of test cases
        scanner.nextLine(); // Consume the newline character after t

        for (int i = 0; i < t; i++) {
            // Read and process each test case
            processTestCase(scanner);
        }

        scanner.close();
    }

    // Function to process each test case
    private static void processTestCase(Scanner scanner) {
        // Read the 8x8 grid
        char[][] grid = new char[8][8];
        for (int i = 0; i < 8; i++) {
            String row = scanner.nextLine();
            for (int j = 0; j < 8; j++) {
                grid[i][j] = row.charAt(j);
            }
        }

        // Check the last row
        for (int j = 0; j < 8; j++) {
            if (grid[7][j] == 'R') {
                System.out.println("R");
                return;
            } else if (grid[7][j] == 'B') {
                System.out.println("B");
                return;
            }
        }

        // Check the last column
        for (int i = 0; i < 8; i++) {
            if (grid[i][7] == 'R') {
                System.out.println("R");
                return;
            } else if (grid[i][7] == 'B') {
                System.out.println("B");
                return;
            }
        }
    }
}
