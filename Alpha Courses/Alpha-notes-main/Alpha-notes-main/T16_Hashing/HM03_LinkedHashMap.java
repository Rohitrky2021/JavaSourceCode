package T16_Hashing;
import java.util.*;
public class HM03_LinkedHashMap {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 100);
        lhm.put("China", 150);
        lhm.put("UK", 50);

        System.out.println(lhm);
    }
}
