import java.util.*;
public class First {
    public static void main(String[] args) {
        //create
        HashMap<String,Integer> hm = new HashMap<>();
        //add
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        System.out.println(hm);
        // Get - O(1)
        int pol = hm.get("India");
        System.out.println(pol);
        System.out.println(hm.get("inida"));//null
        //Containkey - O(1)
        System.out.println(hm.containsKey("India"));//true
        System.out.println(hm.containsKey("india"));//false
        //Remove - O(1)
        System.out.println(hm.remove("US"));
        System.out.println(hm.remove("USA"));
        System.out.println(hm);
        //Size
        System.out.println(hm.size());
        //Isempty
        System.out.println(hm.isEmpty());
        //Clear
        hm.clear();
        System.out.println(hm.isEmpty());
    }
}
