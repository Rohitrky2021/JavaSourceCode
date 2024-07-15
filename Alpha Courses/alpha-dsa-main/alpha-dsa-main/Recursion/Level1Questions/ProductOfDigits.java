package Recursion.Level1Questions;

public class ProductOfDigits {
    public static void main(String args[]) {
        System.out.println(productOfDigits(500999));
    }

    static int productOfDigits(int n) {
        if (n == 0) {
            return 1;
        }
        return (n % 10) * productOfDigits(n / 10);
    }
}
