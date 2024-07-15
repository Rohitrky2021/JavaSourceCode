import java.util.Scanner;

//Write a java method to compute the average of three numbers
public class exerciseprog1 {
    public static double average(double x, double y, double z) {
        return (x+y+z)/3;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the first number: ");
        double x = sc.nextDouble();
        System.out.println("Input the second number: ");
        double y = sc.nextDouble();
        System.out.println("Input the third number: ");
        double z = sc.nextDouble();
        System.out.println("The average value is: "+ average(x,y,z)+"\n");
        sc.close();
    }
}
