import java.util.ArrayList;
import java.util.List;

public class c {

    public static void main(String[] args) {
        // Sample list
        List<Integer> myList = new ArrayList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);

        // Number of elements in the combination
        int numElements = 3;

        // Get combinations with no adjacent elements
        List<List<Integer>> combinations = combNoAdj(myList, numElements, false);

        // Display the generated combinations
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }

    public static List<List<Integer>> combNoAdj(List<Integer> lst, int num, boolean last) {
        List<List<Integer>> result = new ArrayList<>();
        if (num == 0) {
            result.add(new ArrayList<>());
        } else if (num > 0 && num <= lst.size()) {
            int first = lst.get(0);
            List<Integer> rest = lst.subList(1, lst.size());

            if (!last) {
                for (List<Integer> c : combNoAdj(rest, num - 1, true)) {
                    List<Integer> combination = new ArrayList<>();
                    combination.add(first);
                    combination.addAll(c);
                    result.add(combination);
                }
            }

            result.addAll(combNoAdj(rest, num, false));
        }
        return result;
    }
}
