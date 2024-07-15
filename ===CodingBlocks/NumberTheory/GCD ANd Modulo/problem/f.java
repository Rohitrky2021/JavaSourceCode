import java.util.ArrayList;
import java.util.List;

public class f {
    public static void main(String[] args) {
        int[] array1 = {2, 4 ,7};
        int[] array2 = {2,4, 7};

        List<Pair> result = findPairs(array1, array2);

        for (Pair pair : result) {
            System.out.println("Pair: (" + pair.first + ", " + pair.second + ")");
        }
    }

    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    // Function to find pairs that meet the criteria
    static List<Pair> findPairs(int[] array1, int[] array2) {
        List<Pair> pairs = new ArrayList<>();

        for (int num1 : array1) {
            for (int num2 : array2) {
                int diff = Math.abs(num1 - num2);
                int gcd = findGCD(num1, num2);

                if (diff != 1 && gcd != 1) {
                    pairs.add(new Pair(num1, num2));
                }
            }
        }

        return pairs;
    }

    // Function to find the greatest common divisor (GCD) using Euclidean algorithm
    static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return findGCD(b, a % b);
        }
    }
}
