import java.util.Scanner;

//WAP that reads a set if integers and then prints the sum of the even & odd integers
public class exerciseprog2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number;
        int choice;
        int evensum = 0;
        int oddsum = 0;
        do {
            System.out.println("Enter the number: ");
            number = sc.nextInt();
            if (number%2 == 0) {
                evensum += number;
            } else {
                oddsum += number;
            }
            System.out.println("do you want to continue? Press 1 for yes or 0 for no");
            choice = sc.nextInt();
            sc.close();
        }while(choice==1);
        System.out.println("Sum of even no.s: "+evensum);
        System.out.println("sum of odd no.s: "+oddsum);
        sc.close();
    }
}
