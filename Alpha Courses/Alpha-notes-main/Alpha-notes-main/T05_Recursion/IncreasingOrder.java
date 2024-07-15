package T05_Recursion;

import java.util.Scanner;

public class IncreasingOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printIncrs(n);
        sc.close();
    }

    public static void printIncrs(int n) {

        if (n == 0) {
            return;
        }

        
        printIncrs(n - 1);
        System.out.println(n);
    }
}
