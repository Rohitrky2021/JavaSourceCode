import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class MidStartEnd {
    public static Map<String, Character> minMidMaxFrequencies(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        TreeMap<Character, Integer> frequencyMap = new TreeMap<>();

        for (char c : arr) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        Map<String, Character> result = new TreeMap<>();

        // Get the highest frequency entry (last entry)
        Map.Entry<Character, Integer> highestEntry = frequencyMap.lastEntry();
        result.put("highest", highestEntry.getKey());

        // Get the middle frequency entry (ceiling entry of size / 2)
        int size = frequencyMap.size();
        Map.Entry<Character, Integer> middleEntry = frequencyMap.ceilingEntry(size % 2 == 0 ? (char)(size / 2) : (char)((size / 2) + 1));
        result.put("middle", middleEntry.getKey());

        // Get the lowest frequency entry (first entry)
        Map.Entry<Character, Integer> lowestEntry = frequencyMap.firstEntry();
        result.put("lowest", lowestEntry.getKey());

        return result;
    }

    public static void main(String[] args) {
        String input = "aaabbbbccd";
        Map<String, Character> resultMap = minMidMaxFrequencies(input);
        System.out.println("Highest: " + resultMap.get("highest"));
        System.out.println("Middle: " + resultMap.get("middle"));
        System.out.println("Lowest: " + resultMap.get("lowest"));
    }
}
