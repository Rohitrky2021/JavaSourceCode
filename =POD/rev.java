import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class rev {

    public static String normalizeRotation(String str) {
        String doubleStr = str + str;
        String smallestRotation = str;

        for (int i = 1; i < str.length(); ++i) {
            String rotation = doubleStr.substring(i, i + str.length());
            if (rotation.compareTo(smallestRotation) < 0) {
                smallestRotation = rotation;
            }
        }
        return smallestRotation;
    }

    public static int countCyclicPairs(Vector<Integer> nums) {
        int n = nums.size();
        int count = 0;

        Map<String, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String strNum = Integer.toString(nums.get(i));
            String normalizedRotation = normalizeRotation(strNum);
            frequencyMap.put(normalizedRotation, frequencyMap.getOrDefault(normalizedRotation, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            int freq = entry.getValue();
            count += (freq * (freq - 1)) / 2;
        }

        return count;
    }

    public static void main(String[] args) {
        Vector<Integer> nums = new Vector<>(java.util.Arrays.asList(13, 5604, 31, 2, 13, 4560, 546, 654, 456));
        System.out.println(countCyclicPairs(nums));
    }
}
