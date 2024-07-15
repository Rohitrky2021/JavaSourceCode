import java.util.Scanner;

//WAP to input the side of a square. 
//you have to output the area of the square
public class exerciseprog2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int side = sc.nextInt();
        int area = side*side;
        System.out.println("Area of the square is: " + area);
        sc.close();
    }
}
