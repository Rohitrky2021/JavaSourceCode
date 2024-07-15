import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        int negativeCount = 0;
        int positiveCount = 0;
        int zeroCount = 0;

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
            if (array[i] < 0) {
                negativeCount++;
            } else if (array[i] > 0) {
                positiveCount++;
            } else {
                zeroCount++;
            }
        }

        int minAbsoluteValue = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int absValue = Math.abs(array[i]);
            minAbsoluteValue = Math.min(minAbsoluteValue, absValue);
        }

      

        if (zeroCount > 0 ) {
            // If there are zero elements or an even number of negative elements, the product can be made zero without any operations.
            System.out.println(0);
        } else {
            // If there are odd number of negative elements and no zero elements, you need to make one of the negative numbers positive.
            System.out.println(minAbsoluteValue);
        }
    }
}
