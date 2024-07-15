public class Compression {
    public static String compressString(String s) {
        StringBuilder result = new StringBuilder();
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int count = 1;
            
            // Count consecutive occurrences of the current character
            while (i + 1 < n && s.charAt(i) == s.charAt(i + 1)) {
                count++;
                i++;
            }
            
            result.append(ch);
            result.append(count);
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        String input = "aaacccbbcc";
        String compressed = compressString(input);
        System.out.println(compressed);
    }
}
