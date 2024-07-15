import java.math.BigInteger;

public class duplicate {
    public static void findDuplicates(String str) {
        int checker = 0;
        int length = str.length();
        

        for (int i = 0; i < length; i++) {
            int charValue = str.charAt(i) - 'a'; // Assuming the string only contains lowercase alphabets
            int mask = 1 << charValue;

            if ((checker & mask) > 0) {
                System.out.println("Duplicate character found: " + str.charAt(i));
            } else {
                checker |= mask;
            }
        }

        System.out.println("No duplicate characters found.");
    }

    public static void main(String[] args) {
        String input = "Hello World!";
        findDuplicates(input);
    }
}

