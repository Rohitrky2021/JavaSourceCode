import java.util.*;

public class part2SORTING {
    public static void main(String[] args) {
        // Create a sample TreeMap with key-value pairs (String, Integer)
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Alice", 25);
        treeMap.put("Bob", 30);
        treeMap.put("Charlie", 20);
        treeMap.put("David", 35);
        treeMap.put("Eva", 28);

        // Sort the TreeMap based on its values using a custom comparator
        TreeMap<String, Integer> sortedByValue = new TreeMap<>(new ValueComparator(treeMap));
        sortedByValue.putAll(treeMap);

        // Print the sorted TreeMap
        for (Map.Entry<String, Integer> entry : sortedByValue.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Custom comparator to sort TreeMap based on values (Integer)
    static class ValueComparator implements Comparator<String> {
        Map<String, Integer> map;

        public ValueComparator(Map<String, Integer> map) {
            this.map = map;
        }

        @Override
        public int compare(String key1, String key2) {
            Integer value1 = map.get(key1);
            Integer value2 = map.get(key2);
            return value1.compareTo(value2);
        }
    }
}
