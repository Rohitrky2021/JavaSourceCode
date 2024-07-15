import java.util.Scanner;

//   https://codeforces.com/problemset/problem/1776/A

import java.util.Scanner;
import java.util.ArrayList;

public class A_Walking_Boy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = sc.nextInt(); // Number of messages
            ArrayList<Integer> messages = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                messages.add(sc.nextInt());
            }

            int p = 0;
            int cnt = 0;
            boolean ok = false;

            for (int i = 0; i < n; i++) {
                cnt += (messages.get(i) - p) / 120;
                p = messages.get(i);

                if (i == n - 1) { // IMp case --> After Last Mssg u havwe whole time till night -->Hook
                    cnt += (1440 - messages.get(i)) / 120;
                }
            }

            if (cnt >= 2) {
                ok = true;
            }

            yesno(ok);
        }
    }

    public static void yesno(boolean ok) {
        if (ok) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
