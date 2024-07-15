import java.util.*;
public class iteration {
    public static void main(String[] args) {
        //create
        HashMap<String,Integer> hm = new HashMap<>();
        //add
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Nepal", 70);
        hm.put("Indonesia", 90);

        //iterate
        Set<String> key = hm.keySet();
        System.out.println(key);
        for (String k : key) {
            System.out.println("key="+k+",value"+hm.get(k));
        }
    }
}


