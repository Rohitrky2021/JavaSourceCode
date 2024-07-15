import java.util.Scanner;

//WAP to find the factorial of any no.s entered by the user
public class exerciseprog3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        int factorial = 1;
        System.out.println("Enter any positive integer: ");
        num = sc.nextInt();
        sc.close();
        for(int i=1; i<=num; i++) {
            factorial *= i;
        }
        System.out.println("Factorial: "+factorial);
        sc.close();
    }
}
