package T05_Recursion;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(factorialOfNum(n));
        sc.close();
    }

    public static int factorialOfNum(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorialOfNum(n - 1);
    }
}
