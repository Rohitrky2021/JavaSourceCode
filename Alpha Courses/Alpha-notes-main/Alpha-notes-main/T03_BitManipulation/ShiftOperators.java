package T03_BitManipulation;

import java.util.Scanner;

public class ShiftOperators {

    public static int leftShift(int n, int i) {
        
        // n * 2^(power)i;
        return (n << i);
    }
    
    public static int rightShift(int n, int i) {

        // n / 2^(power)i;
        return (n >> i);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = sc.nextInt();
        System.out.println(leftShift(n, i));
        System.out.println(rightShift(n, i));
        sc.close();
    }
}
