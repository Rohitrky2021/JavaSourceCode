package T16_Hashing;

import java.util.HashMap;

public class HM05_frequency {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 1, 2, 4, 3, 54, 5, 3 };
        HashMap<Integer, Integer> map = new HashMap<>();

        // for (int i = 0; i < arr.length; i++) {
        //     if (map.containsKey(arr[i])) {
        //         map.put(arr[i], map.get(arr[i]) + 1);
        //     } else {
        //         map.put(arr[i], 1);
        //     }
        // }

        for (int i = 0; i < arr.length; i++) {

            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // Set<Integer> keys = map.keySet();
        // for (Integer key : keys) {
        //     if (map.get(key) > 1) {
        //         System.out.println(key + " " + map.get(key));
        //     }
        // }
        
        for (Integer key : map.keySet()) {
            if (map.get(key) > 0) {
                System.out.println(key + " " + map.get(key));
            }
        }
    }
}
