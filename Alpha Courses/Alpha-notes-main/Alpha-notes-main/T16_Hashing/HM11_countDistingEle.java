package T16_Hashing;

import java.util.*;

public class HM11_countDistingEle {
    public static void main(String[] args) {
        int arr[] = { 1, 4, 2, 5, 7, 4, 2, 6, 3, 4, 2 };
        System.out.println(brutfourse(arr));
    }

    public static int countDistingElement(int arr[]) {

        HashSet<Integer> hs = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            hs.add(arr[i]);
        }
        return hs.size();
    }

    public static int brutfourse(int arr[]) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] == arr[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans++;
            }
        }
        return ans;
    }
}
