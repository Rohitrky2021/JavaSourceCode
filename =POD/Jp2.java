import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Jp2 {



public static List<Integer> kthOccurrence(int X, List<Integer> arr, List<Integer> query_values) {
    List<Integer> result = new ArrayList<>();
    Map<Integer, Integer> occurrenceMap = new HashMap<>();

    for (int i = 0; i < arr.size(); i++) {
        int current = arr.get(i);

        if (current == X) {
            int occurrence = occurrenceMap.getOrDefault(X, 0) + 1;
            occurrenceMap.put(X, occurrence);

            if (query_values.contains(occurrence)) {
                result.add(i + 1); // Add 1 to convert to 1-based index
            }
        }
    }

    // Handle queries where X doesn't occur the required number of times
    for (int query : query_values) {
        if (!occurrenceMap.containsKey(X) || query > occurrenceMap.get(X)) {
            result.add(-1);
        }
    }

    return result;
}


public static void main(String[] args) {
    int X = 8;
    List<Integer> arr = List.of(1, 2, 20, 8, 8, 1, 2, 5, 8, 0);
    List<Integer> query_values = List.of(100, 2, 1, 3, 4);

    List<Integer> result = kthOccurrence(X, arr, query_values);

    for (int r : result) {
        System.out.println(r);
    }
}

}
