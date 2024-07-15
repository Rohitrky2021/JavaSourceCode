

package T16_Hashing;

import java.util.TreeSet;

public class HM10_TreeSet {
    public static void main(String[] args) {
        TreeSet<String> cities = new TreeSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Noida");
        cities.add("Bengaluru");

        System.out.println(cities);
        for (String city : cities) {
            System.out.println(city);
        }
    }
}
