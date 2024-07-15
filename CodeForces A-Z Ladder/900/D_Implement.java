import java.util.Scanner;

public class D_Implement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String program = scanner.nextLine();

        // Check if the program contains any of the output-producing instructions
        if (containsOutputInstruction(program)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        scanner.close();
    }

    // Function to check if the program contains any output-producing instructions
    private static boolean containsOutputInstruction(String program) {
        for (char c : program.toCharArray()) {
            if (c == 'H' || c == 'Q' || c == '9') {
                return true;
            }
        }
        return false;
    }
}
