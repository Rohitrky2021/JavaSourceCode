import java.util.Scanner;

//WAP to calculate sum by creating a seperate function & calling it in the main function
//and creating a paranthesis in the first function
public class syntaxwithparameters {
    public static int calculatesum(int a, int b) { //paramters or formal parameters
        int sum = a+b;
        return sum; //in this we returned the sum
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int sum = calculatesum(a,b); //arguments or actual parameters
        System.out.println("sum is: "+sum);
        sc.close();
    }
}