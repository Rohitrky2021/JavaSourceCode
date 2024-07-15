package T16_Hashing;

import java.util.HashSet;

public class HM12_union {
    public static void main(String[] args) {
        int arr1[] = { 7, 3, 9 };
        int arr2[] = { 6, 3, 9, 2, 9, 4 };
        System.out.println(union(arr1, arr2));

    }

    public static int union(int arr1[], int arr2[]) {
        HashSet<Integer> union = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            union.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            union.add(arr2[i]);
        }
        System.out.println(union);
        return union.size();
    }
}
