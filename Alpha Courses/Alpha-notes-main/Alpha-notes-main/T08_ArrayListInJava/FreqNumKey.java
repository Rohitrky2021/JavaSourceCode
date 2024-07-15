package T08_ArrayListInJava;

import java.util.*;

public class FreqNumKey {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int e = sc.nextInt();
            list.add(e);
        }
        int k = sc.nextInt();
        System.out.println(solve(list, k));
        sc.close();
    }

    public static int solve(ArrayList<Integer> list, int k) {
        int arr[] = new int[100];
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == k) {
                arr[list.get(i + 1) - 1]++;
            }
        }
        int ans = -1;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > count) {
                ans = i;
            }
        }
        return ans;
    }
}
