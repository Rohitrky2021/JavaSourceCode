package T08_ArrayListInJava;

import java.util.ArrayList;
import java.util.Scanner;

public class MonotonicArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int e = sc.nextInt();
            list.add(e);
        }
        System.out.println(bruteForce(list));
        sc.close();
    }

    public static boolean bruteForce(ArrayList<Integer> ll) {
        boolean ans1 = true;
        boolean ans2 = true;
        for (int i = 0; i < ll.size() - 1; i++) {
            if (ll.get(i) < ll.get(i + 1)) {
                ans1 = false;
            }
            if (ll.get(i) > ll.get(i + 1)) {
                ans2 = false;
            }

        }
        return ans1 || ans2;
    }

}
