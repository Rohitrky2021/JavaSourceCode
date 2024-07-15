import java.util.*;
public class A_Lucky_Division_Regex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        int[] luckyNumbers = {4, 7, 47, 74, 477};
        boolean isAlmostLucky = false;

        for (int d : luckyNumbers) {
            if (n % d == 0) {
                isAlmostLucky = true;
                break;
            }
        }

        if (isAlmostLucky) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
