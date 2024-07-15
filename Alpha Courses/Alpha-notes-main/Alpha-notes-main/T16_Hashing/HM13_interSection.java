package T16_Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class HM13_interSection {
    public static void main(String[] args) {
        int arr1[] = { 7, 2, 2, 2, 3, 9 ,9};
        int arr2[] = { 6, 3, 9, 2, 2, 9, 4 };
        System.out.println(interSection2(arr1, arr2));
    }

    public static int interSection(int arr1[], int arr2[]) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            hs.add(arr1[i]);
        }
        HashSet<Integer> list = new HashSet<>();
        for (int i = 0; i < arr2.length; i++) {
            if (hs.contains(arr2[i])) {
                list.add(arr2[i]);
            }
        }
        System.out.println(list);
        return list.size();
    }

    public static int interSection2(int arr1[], int arr2[]) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < arr1.length; i++) {
            hm.put(arr1[i], hm.getOrDefault(arr1[i], 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr2.length; i++) {
            int k = arr2[i];
            if (hm.containsKey(k)) {
                list.add(k);
                if (hm.get(k) > 1) {
                    hm.put(k, hm.get(k) - 1);
                } else {
                    hm.remove(k);
                }
            }
        }
        System.out.println(list);
        return list.size();
    }
}
