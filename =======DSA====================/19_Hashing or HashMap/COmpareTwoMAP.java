import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class COmpareTwoMAP {
    // public class MapDifferenceExample {
        public static void main(String[] args) {
            Map<String, Integer> map1 = new HashMap<>();
            map1.put("A", 1);
            map1.put("B", 2);
            map1.put("C", 3);
    
            Map<String, Integer> map2 = new HashMap<>();
            map2.put("A", 1);
            map2.put("B", 4);
            map2.put("D", 5);
    
            // Find differing values
            Map<String, Integer> differingValues = new HashMap<>();
    
            for (Map.Entry<String, Integer> entry : map1.entrySet()) {
                String key = entry.getKey();
                Integer value1 = entry.getValue();
                Integer value2 = map2.get(key);
    
                if (value2 == null || !value1.equals(value2)) {
                    differingValues.put(key, value1);
                }
            }
    
            // for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            //     String key = entry.getKey();
            //     Integer value1 = map1.get(key);
            //     Integer value2 = entry.getValue();
    
            //     if (value1 == null || !value2.equals(value1)) {
            //         differingValues.put(key, value2);
            //     }
            // }
    
            System.out.println("Differing values: " + differingValues.entrySet().toString());
        }
    }
    