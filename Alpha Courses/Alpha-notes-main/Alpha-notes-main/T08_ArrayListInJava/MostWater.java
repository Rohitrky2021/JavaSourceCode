package T08_ArrayListInJava;

import java.util.ArrayList;
import java.util.Scanner;

public class MostWater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int e = sc.nextInt();
            list.add(e);
        }

        System.out.println(bruteForce(list));
        System.out.println(twoPointerApproach(list));
        sc.close();
    }

    public static int bruteForce(ArrayList<Integer> ll) {
        int ans = 0;
        for (int i = 0; i < ll.size(); i++) {
            for (int j = i + 1; j < ll.size(); j++) {
                int temp = j - i;
                temp *= (ll.get(i) > ll.get(j)) ? ll.get(j) : ll.get(i);
                ans = (temp > ans) ? temp : ans;
            }
        }
        return ans;
    }

    public static int twoPointerApproach(ArrayList<Integer> ll) {
        int ans = 0;
        int i = 0;
        int j = ll.size() - 1;
        while (i < j) {
            int cur = (j - i) * Math.min(ll.get(i), ll.get(j));
            ans = Math.max(ans, cur);
            if (ll.get(i) < ll.get(j)) {
                i++;
            } else {
                j--;
            }
        }
        return ans;
    }
}
