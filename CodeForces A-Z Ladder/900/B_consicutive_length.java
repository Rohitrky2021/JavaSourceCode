import java.util.Scanner;

public class B_consicutive_length {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String positions = scanner.nextLine();

        // Initialize variables to count consecutive players of the same team
        int count = 1;
        char currentTeam = positions.charAt(0);

        // Iterate through the positions starting from index 1
        for (int i = 1; i < positions.length(); i++) {
            if (positions.charAt(i) == currentTeam) {
                // Increment count if the current player belongs to the same team
                count++;
                // If count reaches 7 or more, output "YES" and exit
                if (count >= 7) {
                    System.out.println("YES");
                    scanner.close();
                    return;
                }
            } else {
                // Reset count and update current team if the player belongs to a different team
                currentTeam = positions.charAt(i);
                count = 1;
            }
        }

        // If the loop completes without encountering a dangerous situation, output "NO"
        System.out.println("NO");
        
        scanner.close();
    }
}
