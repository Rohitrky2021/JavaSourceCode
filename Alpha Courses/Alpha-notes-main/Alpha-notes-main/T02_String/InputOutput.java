package T02_String;
import java.util.Scanner;

public class InputOutput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input only single world
        String str = sc.next();

        // input as a whole line
        String str2 = sc.nextLine();

        System.out.println(str + str2);
        sc.close();
    }
}
