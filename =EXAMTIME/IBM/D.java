import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int n = s.nextInt();
        String str = s.next();
        
        int maxLen = findEvenLengthSubstring(str);
        System.out.println(maxLen);
        
        s.close();
    }

    private static int findEvenLengthSubstring(String str) {
        int maxLen = 0;

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 2; j <= str.length(); j += 2) {
                String sub = str.substring(i, j);

                if (getHalfSum(sub, 0, sub.length() / 2) == getHalfSum(sub, sub.length() / 2, sub.length())) {
                    maxLen = Math.max(maxLen, j - i);
                }
            }
        }

        return maxLen;
    }

    private static int getHalfSum(String str, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += Character.getNumericValue(str.charAt(i));
        }
        return sum;
    }
}
