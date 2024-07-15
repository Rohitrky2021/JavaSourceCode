// import java.util.ArrayList;
// import java.util.List;
// import java.util.*;

// public class Allfactors {
//     public static void main(String[] args) {
//         int number = 2023;
//         List<Integer> factors = findFactors(number);

//         System.out.println("Factors of " + number + ":");
//         for (int factor : factors) {
//             System.out.print(factor + " ");
//         }

//     }

//     public static List<Integer> findFactors(int number) {
//         List<Integer> factors = new ArrayList<>();

//         for (int i = 1; i * i <= number; i++) {
//             if (number % i == 0) {
//                 factors.add(i);
//                 System.out.println(i);

//                 // Check if the factor is not the square root of the number
//                 if (i != number / i) {
//                     factors.add(number / i);
//                     System.out.println(number / i);

//                 }
//             }
//         }

//         return factors;
//     }
// }


import java.util.ArrayList;
import java.util.List;

public class Allfactors {
    public static void main(String[] args) {
        int number = 2023;
        List<Integer> factors = findFactors(number);

        System.out.println("Factors of " + number + ":");
        for (int factor : factors) {
            System.out.print(factor + " ");
        }

    }

    public static List<Integer> findFactors(int number) {
        List<Integer> factors = new ArrayList<>();

        for (int i = 1; i * i <= number; i++) {
            if (number % i == 0) {
                factors.add(i);

                // Check if the factor is not the square root of the number
                if (i != number / i) {
                    factors.add(number / i);
                }
            }
        }

        return factors;
    }
}
