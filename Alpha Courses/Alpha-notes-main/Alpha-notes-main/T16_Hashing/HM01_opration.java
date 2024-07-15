package T16_Hashing;

import java.util.*;

public class HM01_opration {
    public static void main(String[] args) {
        // creat O(1)
        HashMap<String, Integer> hm = new HashMap<>();

        // insert O(1)
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("USA", 50);
        System.out.println(hm);

        // get O(1)
        System.out.println(hm.get("India"));
        System.out.println(hm.get("Indonasia"));

        // containkey O(1)
        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("Indonasia"));

        // remove O(1)
        System.out.println(hm.remove("India"));
        System.out.println(hm.remove("Indonasia"));
        System.out.println(hm);
        
        // size O(1)
        System.out.println(hm.size());

        // clear O(1)
        // hm.clear();
        // System.out.println(hm);

        // keyset

      
    }
}
