import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class c {
    public static void main(String[] args) {
        int number = 20;
        int x=2;
        List<Integer> factors = findFactors(number);

        System.out.println("Factors of " + number + ":");
        for (int factor : factors) {
            System.out.print(factor + " ");
        }
        Collections.sort(factors);

        for(int factor : factors) {

        }

    }

    public static List<Integer> findFactors(int number) {
        List<Integer> factors = new ArrayList<>();
        int count=0;

        for (int i = 1; i * i <= number; i++) {
            if (number % i == 0) {
                // factors.add(i);
                System.out.println(i);
                count++;
                
                // System.out.println(number / i);

                // Check if the factor is not the square root of the number
                if (i != number / i) {
                    factors.add(number / i);
                    factors.add( i);

                    // System.out.println(number / i);
                    count++;

                }
            }
        }
        System.out.println("ans "+count);
        return factors;
    }
}
