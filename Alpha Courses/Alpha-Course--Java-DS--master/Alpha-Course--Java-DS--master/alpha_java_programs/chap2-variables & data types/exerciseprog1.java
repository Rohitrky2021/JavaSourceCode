//WAP to input 3 numbers a,b and c. You have to output the average of 3 numbers
import java.util.Scanner;

public class exerciseprog1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int average = (a+b+c)/3;
        System.out.println("The average of 3 no.s is: " + average);
        sc.close();
    }
}
