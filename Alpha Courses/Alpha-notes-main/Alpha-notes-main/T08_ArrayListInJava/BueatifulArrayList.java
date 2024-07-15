package T08_ArrayListInJava;

import java.util.ArrayList;

public class BueatifulArrayList {
    public static void main(String[] args) {
        bueatifulArrayList(11);
    }

    public static void bueatifulArrayList(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n / 2; i++) {
            list.add((2 * i) + 2);
            list.add((2 * i) + 1);
        }
        if ((n & 1) == 1) {
            list.add(n);
        }
        System.out.println(list);
    }
}
