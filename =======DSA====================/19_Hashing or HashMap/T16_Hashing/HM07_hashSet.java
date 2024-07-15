package T16_Hashing;

import java.util.*;

public class HM07_hashSet {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();
        hs.add(1);
        hs.add(2);
        hs.add(2);
        hs.add(1);
        hs.add(6);
        hs.add(4);
        hs.add(6);
        System.out.println(hs);
        System.out.println(hs.size());
        System.out.println(hs.contains(2));
        System.out.println(hs.contains(5));
        System.out.println(hs.isEmpty());
        hs.clear();
        System.out.println(hs.isEmpty());
    }
}
