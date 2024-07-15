import java.util.*;

public class extractnumber{
    public static void main(String[] args) {
        String input = "abc123def456ghi789";
        int extractedNumber = extractNumber(input);
        
        
        System.out.println("Extracted Number: " + extractedNumber);
    }

    public static int extractNumber(String input) {
        StringBuilder numbers = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            
            if (Character.isDigit(ch)) {
                
                
                
        
                numbers.append(ch);
            }
        }
        return Integer.parseInt(numbers.toString());
    }
}
