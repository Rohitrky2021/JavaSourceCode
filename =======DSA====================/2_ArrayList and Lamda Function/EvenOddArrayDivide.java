import java.util.*;

public class EvenOddArrayDivide {
        public static void main(String[] args) {
            // Create the original array
            int[] originalArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    
            // Calculate the sizes of the two new arrays
            int oddArraySize = (originalArray.length + 1) / 2;
            int evenArraySize = originalArray.length / 2;
    
            // Create arrays to hold the odd and even elements
            int[] oddArray = new int[oddArraySize];
            int[] evenArray = new int[evenArraySize];

         
    
            // Separate the elements into odd and even arrays
            for (int i = 0; i < originalArray.length; i++) {
                if (i % 2 == 0) {
                    evenArray[i / 2] = originalArray[i];
                } else {
                    oddArray[i / 2] = originalArray[i];
                }
            }
    
            // Print the original, odd, and even arrays
            System.out.println("Original Array: " + Arrays.toString(originalArray));
            System.out.println("Odd Elements Array: " + Arrays.toString(oddArray));
            System.out.println("Even Elements Array: " + Arrays.toString(evenArray));
        }
    }
    
