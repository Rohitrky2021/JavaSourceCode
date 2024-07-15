import java.util.*;

public class sort {
    // Custom comparator to sort TreeMap based on values (Integer)
    static class ValueComparator implements Comparator<Character> {
        Map<Character, Integer> map;

        public ValueComparator(Map<Character, Integer> map) {
            this.map = map;
        }

        @Override
        public int compare(Character key1, Character key2) {
            Integer value1 = map.get(key1);
            Integer value2 = map.get(key2);
            return value2.compareTo(value1);
        }
    }

    // public  static int minDeletions(String s) {

    //     HashMap<Character, Integer> frequencyMap =highestLowestFrequencies(s);
    //     List<Integer> values=new ArrayList<>(frequencyMap.values());

    //     for (int i = 0; i < values.size(); i++) {
            
    //     

 


    //     return 1;
    // }

    public static Map<Character, Integer> highestLowestFrequencies(String s) {
        char[] arr = s.toCharArray();
        TreeMap<Character, Integer> frequencyMap = new TreeMap<>();

        for (char c : arr) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        


        Map<Character, Integer> result = new TreeMap<>(new ValueComparator(frequencyMap));
        result.putAll(frequencyMap);
        
        // List<Character> sortedKeys = new ArrayList<>(frequencyMap.keySet());
        // Collections.sort(sortedKeys, new ValueComparator(frequencyMap));

        
        return result;
    }

    public static void main(String[] args) {
        String input = "aaabbbbccccdd";
        Map<Character, Integer> resultMap = highestLowestFrequencies(input);
        System.out.println("Characters sorted by frequency:");
        List<Integer> values=new ArrayList<>(resultMap.values());
        System.out.println(values.toString());
        for (Map.Entry<Character, Integer> entry : resultMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
