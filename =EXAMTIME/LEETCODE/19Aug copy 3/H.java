public class H {
    public static int getAnagram(String s) {
        int n = s.length() / 2;
        int count = 0;
        int[] al = new int[10]; // Corrected the array initialization
        int[] a2 = new int[10]; // Corrected the array initialization

        for (int i = 0; i < n; i++) {
            al[s.charAt(i) - '0']++; // Updated to correctly count occurrences of digits
        }

        for (int i = n; i < 2 * n; i++) {
            a2[s.charAt(i) - '0']++; // Updated to correctly count occurrences of digits
        }

        for (int i = 0; i < 10; i++) { // Loop through digits 0-9
            count += Math.abs(al[i] - a2[i]); // Count the difference in occurrences
        }

        return count / 2; // Since we only need to modify the first half, divide count by 2
    }

    public static void main(String[] args) {
        String input = "123456";
        int result = getAnagram(input);
        System.out.println("Minimum number of replacements needed to make anagram: " + result);
    }
}
