//WAP to print number from 1 to n using while loop in java
import java.util.Scanner;

public class printnumbers1ton {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int range = sc.nextInt();
        sc.close();
        int counter = 1; 
        while(counter <= range) {
            System.out.println(counter + " ");
            counter++;
        }
        System.out.println();
    }
}
/*
 * Explanation-
 * in this the output prints from 1 to n
 * we enter the n value in the output and then the range prints starting from 1 to the value of n
 */