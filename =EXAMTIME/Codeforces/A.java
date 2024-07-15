import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = scanner.nextInt(); // Rows
            int m = scanner.nextInt(); // Columns
            scanner.nextLine(); // Consume the newline

            char[][] carpet = new char[n][m];
            for (int i = 0; i < n; i++) {
                String row = scanner.nextLine();
                carpet[i] = row.toCharArray();
            }

            boolean result = checkCarpet(carpet, n, m);
            System.out.println(result ? "YES" : "NO");
        }
    }

    static boolean checkCarpet(char[][] carpet, int n, int m) {
        String target = "vika";

        int found = 0;
        for (int c = 0; c < m; c++) {

            for (int r = 0; r < n; r++) {
                if (carpet[r][c] == target.charAt(found)) {
                    found++;

                    if (found == 4) {
                        return true; // Vika will like the carpet
                    }
                    break;
                }
            }
        }

        return false; // Vika will not like the carpet
    }
}
