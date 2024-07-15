import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class prac1 {

    // static class ValueComparator implements Comparator<Map.Entry<Integer,
    // Integer>>{
    // @Override
    // public int compare(Map<Integer,Integer>.Entry entry1,
    // Map<Integer,Integer>.Entry entry2) {
    // return this.entry1.getValue()-entry2.getValue();
    // }

    // }

    // static class ValueComparator implements Comparator<Map.Entry<Integer,
    // Integer>> {
    // @Override
    // public int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer,
    // Integer> entry2) {
    // // Compare values of the entries (change the logic as per your requirement)
    // return entry1.getValue().compareTo(entry2.getValue());
    // }
    // }
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

    public static void main(String[] args) {
        largestVariance();
    }

    public static int largestVariance() {

        var hs = new TreeMap<Integer, Integer>();
        String str="adff";
        
        for(char i:str.toCharArray()){
            hs.put(Character.toString(i), hs.getOrDefault(Character.toString(i),0)+1);

        }

        

        hs.put(2, 1);
        hs.put(3, 4);
        hs.put(4, 3);
        hs.put(5, 2);
        hs.put(6, 1);
        // for (int i : hs.values()) {
        //     System.out.println(i);
        // }

        // Sort the TreeMap based on its values using a custom comparator
        TreeMap<String, Integer> sortedByValue = new TreeMap<>(new ValueComparator(treeMap));
        sortedByValue.putAll(hs);

        // Print the sorted TreeMap
        for (Map.Entry<String, Integer> entry : sortedByValue.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        return 1;

    }

}
