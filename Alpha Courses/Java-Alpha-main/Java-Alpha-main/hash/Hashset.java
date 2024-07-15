import java.util.*;
public class Hashset {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();
        hs.add("India");
        hs.add("USA");
        hs.add("Australia");
        hs.add("Germany");
        hs.add("Rassia");
        // iterator
        Iterator it = hs.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
        // for each
        for (String integer : hs) {
            System.out.println(integer);
        }
    }
}
