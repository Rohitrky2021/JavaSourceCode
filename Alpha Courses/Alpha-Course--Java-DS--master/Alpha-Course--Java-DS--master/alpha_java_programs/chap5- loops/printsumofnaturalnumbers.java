import java.util.Scanner;

//WAP to print the sum of n natural numbers using while loop in java
public class printsumofnaturalnumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int sum = 0;
        int i = 1;
        while(i <= n) {
            sum += i;
            i++;
        }
        System.out.println("The sum of n natural no.s is: "+sum);
    }
}
/*
 * Explanation-
 * in this we print the value of n in the output and then the counter calculates the sum from 1 to the value of n and gives the output
 */