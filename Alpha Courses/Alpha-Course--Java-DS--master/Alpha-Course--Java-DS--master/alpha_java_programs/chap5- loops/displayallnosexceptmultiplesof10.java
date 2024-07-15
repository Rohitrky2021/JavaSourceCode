import java.util.Scanner;

//WAP to display all numbers entered by user except mulitples of 10
public class displayallnosexceptmultiplesof10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Enter your number: ");
            int n = sc.nextInt();
            sc.close();

            if(n%10 == 0) {
                continue;
            }
            System.out.println("Number was: "+n);
        }while(true);
    }
}
/*
 * Explanation-
 * in this the number enters all the numbers as the output except the multiples of 10
 */