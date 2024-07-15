package T07_Backtraking;

import java.util.Scanner;

public class GridWaysMath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(fanction(n, m));
        // System.out.println(fac(n));
        sc.close();
    }

    public static int fanction(int n, int m) {

        return fac(n + m - 2) / (fac(n - 1) * fac(m - 1));
    }

    public static int fac(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        int i = n, ans = 1;
        while (i > 1) {
            ans *= i;
            i--;
        }
        return ans;
    }
}