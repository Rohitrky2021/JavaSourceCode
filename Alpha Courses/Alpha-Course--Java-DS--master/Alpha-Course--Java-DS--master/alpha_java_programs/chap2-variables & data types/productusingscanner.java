//to find the product of 2 no.s using scanner
import java.util.Scanner;

public class productusingscanner {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int product = a*b;
        System.out.println(product);
        sc.close();
    }
}
