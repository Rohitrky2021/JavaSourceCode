import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        scanner.close();

        int group1Sum = 0;
        int group2Sum = 0;
        int i = 1;

        while (i <= N) {
            if ((double)group1Sum / (double)group2Sum == (double)A / (double)B) {
                System.out.println(group1Sum + " " + group2Sum);
                return;
            }

            if ((double)(group1Sum + i) / (double)group2Sum == (double)A / (double)B) {
                group1Sum += i;
            } else {
                group2Sum += i;
            }

            i++;
        }

        System.out.println("-1");
    }
}
