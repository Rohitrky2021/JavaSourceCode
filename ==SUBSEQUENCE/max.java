
    import java.util.Scanner;

    public class max {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
    
             int N = scanner.nextInt();
            int K = scanner.nextInt();
    
             int[] numbers = new int[N];
            for (int i = 0; i < N; i++) {
                numbers[i] = scanner.nextInt();
            }
    
             for (int i = 0; i < N; i++) {
                int number = numbers[i];
                String numberStr = Integer.toString(number);
    
                 String result = findLargestSubsequence(numberStr, K);
    
                 System.out.print(result + " ");
            }
    
             scanner.close();
        }
    
        public static String findLargestSubsequence(String input, int k) {
            if (k >= input.length()) {
                return input;
            }
    
            StringBuilder largestSubsequence = new StringBuilder();
    
            for (int i = 0; i < input.length(); i++) {
                char currentChar = input.charAt(i);
    
                while (largestSubsequence.length() > 0 && currentChar > largestSubsequence.charAt(largestSubsequence.length() - 1)
                        && input.length() - i + largestSubsequence.length() > k) {
                     largestSubsequence.deleteCharAt(largestSubsequence.length() - 1);
                }
    
                if (largestSubsequence.length() < k) {
                     largestSubsequence.append(currentChar);
                }
            }
    
            return largestSubsequence.toString();
        }
    }
    