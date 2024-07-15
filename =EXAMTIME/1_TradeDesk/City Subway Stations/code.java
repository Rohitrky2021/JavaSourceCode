import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class code {

    public static String calcCost(Map<String, Map<String, String>> costs, String s, String d) {
        if (!costs.containsKey(s) || !costs.containsKey(d)) {
            return null;
        }

        Map<String, String> sCosts = costs.get(s);
        return sCosts.get(d);
    }

    public static void main(String[] args) {
        Map<String, Map<String, String>> costs = new HashMap<>();
        
        costs.put("A", Map.of("A", "AB", "B", "AB", "C", "ABC"));
        costs.put("B", Map.of("A", "AB", "B", "AB", "C", "BC"));
        costs.put("C", Map.of("A", "ABC", "B", "BC", "C", "BC"));

        String s = "M";
        String d = "M";

        List<String> a = Arrays.asList("X");
        List<String> b = Arrays.asList("Z","M");
        List<String> c = Arrays.asList("Y");

        if (a.contains(s)) s = "A";
        else if (b.contains(s)) s = "B";
        else if (c.contains(s)) s = "C";

        if (a.contains(d)) d = "A";
        else if (b.contains(d)) d = "B";
        else if (c.contains(d)) d = "C";

        String cost = calcCost(costs, s, d);

        if (cost != null) {
            System.out.println("Cost from " + s + " to " + d + ": " + cost);
        } else {
            System.out.println("Invalid input cities.");
        }
    }
}
