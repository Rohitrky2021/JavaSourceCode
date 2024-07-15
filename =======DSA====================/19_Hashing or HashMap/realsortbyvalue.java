public class realsortbyvalue {
    // https://leetcode.com/problems/substring-with-largest-variance/
    

    public int largestVariance(String s) {
        TreeMap<String, Integer> hs = new TreeMap<>();
        for (char i : s.toCharArray()) {
            hs.put(Character.toString(i), hs.getOrDefault(Character.toString(i), 0) + 1);
        }

        TreeMap<String, Integer> sortedByValue = new TreeMap<>(new ValueComparator(hs));
        sortedByValue.putAll(hs);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Print the sorted TreeMap
        for (Map.Entry<String, Integer> entry : sortedByValue.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
            min = Math.min(min,entry.getValue());
            max = Math.max(max,entry.getValue());
        }
        return max-min;
    }

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
 

public class RealSortByValue {

    public int largestVariance(String s) {
        Map<String, Integer> hs = new HashMap<>();
        for (char i : s.toCharArray()) {
            hs.put(Character.toString(i), hs.getOrDefault(Character.toString(i), 0) + 1);
        }

        Map<String, Integer> sortedByValue = new TreeMap<>(
                (k1, k2) -> map.get(k2).compareTo(map.get(k1))
        );
        sortedByValue.putAll(hs);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : sortedByValue.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
            min = Math.min(min, entry.getValue());
            max = Math.max(max, entry.getValue());
        }
        return max - min;
    }

    public static void main(String[] args) {
        RealSortByValue rsbv = new RealSortByValue();
        System.out.println(rsbv.largestVariance("aababbb"));
    }
}