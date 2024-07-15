import java.util.*;

    public class A_String_task {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            scanner.close();
    
            StringBuilder result = new StringBuilder();
    
            for (char c : input.toCharArray()) {
                // Check if the character is a vowel (uppercase or lowercase)
                if ("AEIOUYaeiouy".indexOf(c) == -1) {
                    // If it's not a vowel, add a '.' before it and convert to lowercase
                    result.append(".").append(Character.toLowerCase(c));
                }
            }
    
            System.out.println(result);
        }

        // public static void main(String[] args) {
        //     Scanner scanner = new Scanner(System.in);
        //     String input = scanner.nextLine();
        //     scanner.close();
    
        //     ArrayList<Character> s = new ArrayList<>();
        //     Iterator<Character> iterator = input.chars().mapToObj(c -> (char) c).iterator();
    
        //     while (iterator.hasNext()) {
        //         char c = iterator.next();
                
        //         if (!"AEIOUYaeiouy".contains(String.valueOf(c))) {
        //             s.add('.');
        //         }
    
        //         s.add(Character.toLowerCase(c));
        //     }
    
        //     // Convert the ArrayList to a string for printing
        //     StringBuilder result = new StringBuilder();
        //     for (Character character : s) {
        //         result.append(character);
        //     }
    
        //     System.out.println(result);
        // }
    }
    