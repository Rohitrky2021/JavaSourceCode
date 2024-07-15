public class GCD_Except_MySelf_i {
    // https://leetcode.com/discuss/interview-question/309080/LCM-GCD-of-array-except-current-element(self)    
}
public class Main {
    public static void main(String[] args) {
        int[] a = { /* Your array elements here */ };

        int[] left = new int[a.length];
        int[] right = new int[a.length];
        int[] gcdArray = new int[a.length];
        int[] lcmArray = new int[a.length];
        int[] product = new int[a.length];

        int g = a[0];
        for (int i = 0; i < a.length; i++) {
            g = gcd(g, a[i]);
            left[i] = g;
        }

        g = a[a.length - 1];
        for (int i = a.length - 1; i >= 0; i--) {
            g = gcd(g, a[i]);
            right[i] = g;
        }

        for (int i = 0; i < a.length; i++) {
            if (i == 0) {
                gcdArray[i] = right[i + 1];
            } else if (i == a.length - 1) {
                gcdArray[i] = left[i - 1];
            } else {
                gcdArray[i] = gcd(left[i - 1], right[i + 1]);
            }
        }

        int p = 1;
        for (int value : a) {
            p *= value;
        }

        for (int i = 0; i < product.length; i++) {
            product[i] = p / a[i];
        }

        for (int i = 0; i < lcmArray.length; i++) {
            lcmArray[i] = product[i] / gcdArray[i];
        }
    }

    // Method to calculate the Greatest Common Divisor (GCD)
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
