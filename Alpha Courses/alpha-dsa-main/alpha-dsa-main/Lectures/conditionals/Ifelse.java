import java.util.*;

public class Ifelse {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = sc.nextInt();
        if (n > 0) {
            System.out.println(n + " is positive");
        } 
        else if (n < 0) {
            System.out.println(n + " is negative");
        } else {
            System.out.println(n + " is neither positive nor negative");
        }
        sc.close();
    }
}