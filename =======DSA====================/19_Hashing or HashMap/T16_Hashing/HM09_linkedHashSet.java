
package T16_Hashing;

import java.util.LinkedHashSet;

public class HM09_linkedHashSet {
    public static void main(String[] args) {
        LinkedHashSet<String> cities = new LinkedHashSet<>();
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
