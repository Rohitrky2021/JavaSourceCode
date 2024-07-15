import java.util.Scanner;

public class E_Imple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dubstep = scanner.nextLine();

        // Split the dubstep remix into words by removing "WUB" and splitting by it
        String[] words = dubstep.split("WUB");

        // Concatenate the words together with a single space between each word
        StringBuilder originalSong = new StringBuilder();
        for (String word : words) {
            // Append non-empty words to the original song
            if (!word.isEmpty()) {
                originalSong.append(word).append(" ");
            }
        }

        // Remove trailing space, if any
        if (originalSong.length() > 0 && originalSong.charAt(originalSong.length() - 1) == ' ') {
            originalSong.deleteCharAt(originalSong.length() - 1);
        }

        // Print the original song
        System.out.println(originalSong.toString());

        scanner.close();
    }
}
