
import java.util.*;

public class ok {
    // Function to calculate the GCD of two numbers using Euclidean algorithm
    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int[] arr1 = { 2, 4 , 7};
        int[] arr2 = { 4, 2 };

        Set<Integer> set = new HashSet<>();
  

        for (int num : arr1) {
            set.add(num);
        }
        int c = arr1.length * arr2.length;
        int r=0;

        for (int num : arr2) {
            for (int i = 1; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    if (set.contains(i) && gcd(num, i) == 1) {
                        r++;
                    }
                    int otherDivisor = num / i;
                    if (i != otherDivisor && set.contains(otherDivisor) && gcd(num, otherDivisor) == 1) {
                        r++;
                    }
                }

            }
        }
 
        System.out.println("ans-> " + (c -r));
    }

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
