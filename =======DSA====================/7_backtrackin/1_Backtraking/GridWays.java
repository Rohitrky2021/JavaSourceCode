package T07_Backtraking;

import java.util.Scanner;

public class GridWays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(function(0, 0, n, m));
        sc.close();
    }

    public static int function(int x, int y, int n, int m) {
        if (x == n || y == m) {
            return 0;
        }
        if (x == n - 1 && y == m - 1) {
            return 1;
        }

        return function(x, y + 1, n, m) + function(x + 1, y, n, m);
    }
}
