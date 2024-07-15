package T05_Recursion;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {

            System.out.print(fib(i) + " ");
        }
        System.out.println();
        sc.close();
    }

    public static int fib(int n) {

        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 2) + fib(n - 1);
    }
}
