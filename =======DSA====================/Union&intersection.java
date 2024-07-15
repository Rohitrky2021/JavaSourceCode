import java.util.HashSet;
import java.util.Set;

public class SetOperations {
    public static <T> Set<T> union(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }

    public static <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }

    public static <T> Set<T> difference(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.removeAll(set2);
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(3);
        set2.add(4);

        // Union
        Set<Integer> unionResult = union(set1, set2);
        System.out.println("Union: " + unionResult);

        // Intersection
        Set<Integer> intersectionResult = intersection(set1, set2);
        System.out.println("Intersection: " + intersectionResult);

        // Difference (elements in set1 but not in set2)
        Set<Integer> differenceResult = difference(set1, set2);
        System.out.println("Difference (set1 - set2): " + differenceResult);
    }
}



// For NON _ DISTINCT ==> Use List 

 

public class ListOperations {
    public static <T> List<T> union(List<T> list1, List<T> list2) {
        List<T> result = new ArrayList<>(list1);
        result.addAll(list2);
        return result;
    }

    public static <T> List<T> intersection(List<T> list1, List<T> list2) {
        List<T> result = new ArrayList<>(list1);
        result.retainAll(list2);
        return result;
    }

    public static <T> List<T> difference(List<T> list1, List<T> list2) {
        List<T> result = new ArrayList<>(list1);
        result.removeAll(list2);
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(2);
        list1.add(3);

        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(2);
        list2.add(3);
        list2.add(4);

        // Union
        List<Integer> unionResult = union(list1, list2);
        System.out.println("Union: " + unionResult);

        // Intersection
        List<Integer> intersectionResult = intersection(list1, list2);
        System.out.println("Intersection: " + intersectionResult);

        // Difference (elements in list1 but not in list2)
        List<Integer> differenceResult = difference(list1, list2);
        System.out.println("Difference (list1 - list2): " + differenceResult);
    }
}
