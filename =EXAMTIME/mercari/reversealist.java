import java.util.ArrayList;
import java.util.List;

public class ReverseAList {
    public static void main(String[] args) {
        List<Integer> originalList = List.of(1, 2, 3, 4, 5);
        List<Integer> reversedList = reverseArray(new ArrayList<>(originalList));
        
        System.out.println("Original List: " + originalList);
        System.out.println("Reversed List: " + reversedList);
    }

    static List<Integer> reverseArray(List<Integer> arr) {
        int start = 0;
        int end = arr.size() - 1;
        while (start < end) {
            // Swap elements at start and end indices
            int temp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, temp);
            // Move indices towards the center
            start++;
            end--;
        }
        return arr;
    }
}



vector<int> reverseArray(vector<int> arr) {
    int start = 0;
    int end = arr.size() - 1;
    while (start < end) {
        // Swap elements at start and end indices
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        // Move indices towards the center
        start++;
        end--;
    }
    return arr;
}
// ercari QS 2
//Reverse a list edited 10:52 PM
