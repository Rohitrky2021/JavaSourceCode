public class t {
    public static String betterCompression(String s) {
        StringBuilder result = new StringBuilder();
        int n = s.length();
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int count = 0;
            
            while (i + 1 < n && Character.isDigit(s.charAt(i + 1))) {
                count = count * 10 + Character.getNumericValue(s.charAt(i + 1));
                i++;
            }
            
            if (i + 1 < n && ch == s.charAt(i + 1)) {
                sum += count;
            } else {
                result.append(ch);
                result.append(count + sum);
                sum = 0;
            }
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        String input = "a3c9b2c1";
        String compressed = betterCompression(input);
        System.out.println(compressed);
    }
}
