package Temp;

import java.util.Scanner;

public class Temp1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your Number : ");
        int n = sc.nextInt();
        int i;
        while (true) {
            System.out.print("Enter i : ");
            i = sc.nextInt();
            if (i == 0) {
                System.out.println("!! YOU WON !!");
                break;
            } else if (n % i == 0) {
                n /= i;
            }
            System.out.println("the number is : " + n);
            if (n == 1) {
                System.out.println("!! THE END !!");
                break;
            }
        }

        sc.close();
    }
}
