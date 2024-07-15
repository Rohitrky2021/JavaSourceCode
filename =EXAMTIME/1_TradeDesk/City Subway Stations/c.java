import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class c {

    // Function to calculate the cost based on the provided costs map
    public static String calculateCost(Map<String, Map<String, String>> costs, List<String> cityNames, String startCity, String destinationCity) {
        if (!cityNames.contains(startCity) || !cityNames.contains(destinationCity)) {
            // Return null if either the start or destination city is not in the cityNames list
            return null;
        }

        // Get the positions of start and destination cities in the cityNames list
        int startIdx = cityNames.indexOf(startCity);
        int destIdx = cityNames.indexOf(destinationCity);

        // Get the cost from the start city to the destination city
        String cost = costs.get(cityNames.get(startIdx)).get(cityNames.get(destIdx));

        return cost;
    }

    public static void main(String[] args) {
        // Example: List of city names (X, Y, Z) for each set of costs
        List<String> cityNamesA = Arrays.asList("X", "Y", "Z");
        List<String> cityNamesB = Arrays.asList("X", "Y", "Z");
        List<String> cityNamesC = Arrays.asList("X", "Y", "Z");

        // Example: List of city names (A, B, C) and their associated costs
        Map<String, Map<String, String>> costs = new HashMap<>();
        
        // Cost from A to A, B, C
        costs.put("A", Map.of("A", "AB", "B", "AB", "C", "ABC"));

        // Cost from B to A, B, C
        costs.put("B", Map.of("A", "AB", "B", "AB", "C", "BC"));

        // Cost from C to A, B, C
        costs.put("C", Map.of("A", "ABC", "B", "BC", "C", "BC"));

        // Example usage
        String startCity = "C";
        String destinationCity = "A";

        // Choose the appropriate cityNames list based on the cost set
        List<String> cityNames = cityNamesC;

        String cost = calculateCost(costs, cityNames, startCity, destinationCity);

        if (cost != null) {
            System.out.println("Cost from " + startCity + " to " + destinationCity + ": " + cost);
        } else {
            System.out.println("Invalid input cities.");
        }
    }
}
