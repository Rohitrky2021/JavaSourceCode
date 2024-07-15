import java.util.*;

public class sortingINmap{
    // Custom comparator to sort map entries based on values
    static class ValueComparator implements Comparator<Map.Entry<Integer, Integer>> {
        @Override
        public int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2) {
            // Compare values of the entries (change the logic as per your requirement)
            return entry1.getValue().compareTo(entry2.getValue());
        }
    }

    public static void main(String[] args) {
        // Create a sample LinkedHashMap with integer keys and values
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, 30);
        linkedHashMap.put(2, 10);
        linkedHashMap.put(3, 50);
        linkedHashMap.put(4, 20);

        // Convert the LinkedHashMap entries to a list
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(linkedHashMap.entrySet());

        // Sort the list using the custom comparator
        Collections.sort(list, new ValueComparator());

        // Create a new LinkedHashMap to store the sorted entries
        LinkedHashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();

        // Put the sorted entries back into the new LinkedHashMap
        for (Map.Entry<Integer, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        // Print the sorted LinkedHashMap based on values
        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
 
public class SortHashMapByValue {
    public static void main(String[] args) {
        // Create a HashMap and populate it with some data
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Apple", 50);
        map.put("Banana", 20);
        map.put("Cherry", 30);
        map.put("Date", 10);

        // Create a list from the elements of the HashMap
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        // Sort the list using a comparator that compares the values
        list.sort(Map.Entry.comparingByValue());

        // Create a new LinkedHashMap to maintain the sorted order
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        // Print the sorted map
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
