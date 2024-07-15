package T05_Recursion;

public class Power {
    public static void main(String[] args) {
        int a = 2;
        int b = 10;
        // System.out.println(power(a, b));
        System.out.println(powerOptimized(a, b));
    }

    public static int power(int a, int n) {
        if (n == 0) {
            return 1;
        }
        return a * power(a, n - 1);
    }

    public static int powerOptimized(int x, int n) {

        if (n == 0) {
            return 1;
        }
        int temp = powerOptimized(x, n / 2);

        temp *= temp;
        
        if ((n & 1) == 1) {
            temp *= x;
        }

        return temp;

    }
}
