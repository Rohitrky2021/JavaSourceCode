package T12_Greedy_Algo;

import java.util.*;

public class G05_indianCoins {
    public static void main(String[] args) {
        Integer arr[] = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 1000, 2000 };
        Arrays.sort(arr, Comparator.reverseOrder());
        int amount = 590;
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] <= amount) {
                count++;
                amount -= arr[i];
                list.add(arr[i]);
            }
        }
        System.out.println(count);
        System.out.println(list);
    }
}
