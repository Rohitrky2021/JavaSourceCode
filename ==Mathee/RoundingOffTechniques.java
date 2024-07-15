public class RoundingOffTechniques {
    
    // Math.ceil(double a):
double value = 7.3;
double ceilResult = Math.ceil(value);
long flagstonesNeeded = (long) Math.ceil((double) n / a) * (long) Math.ceil((double) m / a);
System.out.println("Ceil of " + value + " is: " + ceilResult); // Output: Ceil of 7.3 is: 8.0  // MAke sure rounding of Double if Int will give round not Ciel

    // Math.floor(value)
double value = 7.8;
double floorResult = Math.floor(value);
System.out.println("Floor of " + value + " is: " + floorResult); // Output: Floor of 7.8 is: 7.0

    // Math.round(value1)
double value1 = 7.2;
double value2 = 7.8;
long roundResult1 = Math.round(value1);
long roundResult2 = Math.round(value2);
System.out.println("Round of " + value1 + " is: " + roundResult1); // Output: Round of 7.2 is: 7
System.out.println("Round of " + value2 + " is: " + roundResult2); // Output: Round of 7.8 is: 8


}


// import java.math.BigDecimal;
// import java.math.RoundingMode;

public class RoundTo5DecimalPlaces {
    public static void main(String[] args) {
        double number = 12.3456789; // Replace this with your number

        // Create a BigDecimal with the number
        BigDecimal bd = new BigDecimal(number);

        // Round to 5 decimal places with RoundingMode.UP
        bd = bd.setScale(5, RoundingMode.UP);

        // Convert the result back to a double if needed
        double roundedNumber = bd.doubleValue();

        // Print the rounded number
        System.out.println("Rounded number: " + roundedNumber);
    }
}

class Solution {
    public double findMaxAverage(int[] arr, int k) {
     
        int n = arr.length;

        // int k = 3;
        int sum = 0;
        double msum=Integer.MIN_VALUE;

        // Calculate the sum of the first k elements
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        msum=sum;

        // Calculate the sum of all subarrays of size k
        for (int i = k; i < n; i++) {
           sum = sum + arr[i] - arr[i - k];
           msum= Math.max(msum,sum);

        }

        System.out.println(msum);
        String formattedFraction = String.format("%.5f", msum/k);

        return  Double.parseDouble(formattedFraction);

        
    }
} 