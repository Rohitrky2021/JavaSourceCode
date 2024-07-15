import java.util.Scanner;

//WAP which keeps entering numbers till user enters a multiple of 10 using break statement
public class enteringmultipleof10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Enter your number: ");
            int n = sc.nextInt();
            if(n%10==0) {
                break;
            }
            System.out.println(n);
            sc.close();
        }while(true);
    }
}
/*
 * Explanation-
 * in this the prog keeps printing the number till the user enters multiple of 10
 */