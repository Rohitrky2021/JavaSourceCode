 
import java.util.*;
 

public class B {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases
        
        while (t-- > 0) {
            int n = scanner.nextInt(); // Number of digits
            int[] digits = new int[n]; // Array to store digits
            
            for (int i = 0; i < n; i++) {
                digits[i] = scanner.nextInt(); // Read the digits into the array
            }
            
            int maxProduct = getMaxProduct(digits);
            System.out.println(maxProduct);
        }
        
        scanner.close();
    }

    public static int getMaxProduct(int[] digits) {
        int maxProduct = 1;
        int minDigit = 10;
        int countZeros = 0;

        Arrays.sort(digits);
        
        for (int digit : digits) {
            if (digit == 0) {
                countZeros++;
            }
        }
        
        // If there are zeros, we can change one of them to 1.
        if (countZeros > 1) {
           return 0;
        }
        // if (countZeros ==1) {
        //     digits[0]++;
        //  }else{
        //     digits[digits.length-1]++;
        //  }

        digits[0]++;
        
        for (int digit : digits) {
        
        maxProduct*=digit;
        }

        
        return maxProduct;
    }
}
