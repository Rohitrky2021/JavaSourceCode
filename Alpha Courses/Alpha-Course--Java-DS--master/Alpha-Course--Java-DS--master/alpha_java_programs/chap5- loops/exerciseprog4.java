import java.util.Scanner;

//WAP to print the multiplication table of a number n entered by the user
public class exerciseprog4 {
    public static void printMultiplicationTable(int number) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        sc.close();
        for(int i=1; i<=10; i++) {
            System.out.println(n + " * " + i + " = " + n*i);
        }
    }
    public static void main(String[] args) {
        printMultiplicationTable(5);
    }
}
