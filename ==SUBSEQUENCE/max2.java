
    import java.util.Arrays;
    import java.util.Scanner;
    

    public class max2 {

            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
        
                // Read N and K from input
                int N = scanner.nextInt();
                int K = scanner.nextInt();
        
                // Read the array of N numbers
                int[] numbers = new int[N];
                for (int i = 0; i < N; i++) {
                    numbers[i] = scanner.nextInt();
                }
        
                // Process each number and find the greatest K-digit number
                for (int i = 0; i < N; i++) {
                    int number = numbers[i];
        
                    // Use the findLargestKDigits method to find the greatest K-digit number
                    String result = findLargestKDigits(number, K);
        
                    // Print the result
                    System.out.print(result + " ");
                }
        
                // Close the scanner
                scanner.close();
            }
        
            public static String findLargestKDigits(int number, int k) {
                // Convert the number to a string
                String numberStr = Integer.toString(number);
                
                // If K is greater than or equal to the length of the number, return the number itself
                if (k >= numberStr.length()) {
                    return numberStr;
                }
        
                // Create a StringBuilder to store the result
                StringBuilder result = new StringBuilder();
        
                // Initialize variables to keep track of the maximum digit and its index
                char maxDigit = '0';
                int maxIndex = -1;
        
                // Iterate through the number to find the largest K digits
                for (int i = 0; i < k; i++) {
                    for (int j = maxIndex + 1; j < numberStr.length(); j++) {
                        char digit = numberStr.charAt(j);
                        if (digit > maxDigit) {
                            maxDigit = digit;
                            maxIndex = j;
                        }
                    }
        
                    // Append the maximum digit to the result
                    result.append(maxDigit);
        
                    // Reset maxDigit to '0' for the next iteration
                    maxDigit = '0';
                }
        
                return result.toString();
            }
        }
        



// 5 2 
// 432 567 890 657 34