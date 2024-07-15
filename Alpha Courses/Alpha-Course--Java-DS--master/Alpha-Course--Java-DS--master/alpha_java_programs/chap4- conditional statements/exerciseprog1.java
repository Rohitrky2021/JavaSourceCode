import java.util.Scanner;

//WAP to get a number from the user and print whether it is positive or negative
public class exerciseprog1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if(a>0) {
            System.out.println("a is greater than 0");
        }
        else {
            System.out.println("a is less than or equal to 0");
        }
        sc.close();
    }
}