// package T16_Hashing;

import java.util.*;

public class HM14_travelPath {

    public static String getStart(HashMap<String, String> tickets) {
        HashSet<String> fromSet = new HashSet<>();

        for (String key : tickets.keySet()) {
            fromSet.add(tickets.get(key));
        }

        for (String key : tickets.keySet()) {
            if (!fromSet.contains(key)) {
                return key;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String start = getStart(tickets);
        System.out.print(start);

        for (int i = 0; i < tickets.size(); i++) {
            System.out.print(" -> " + tickets.get(start));
            start = tickets.get(start);

        }
        System.out.println();
    }
}
