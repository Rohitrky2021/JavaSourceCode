import java.util.*;
import java.util.List;

public class stream01 {
    // public static void main(String[] args) {
    // List<Integer> l=Arrays.asList(1,2,3,4,5);
    // int max=l.stream().max(a,b->a-b);
    // System.out.println(max);
    // }

    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(1,1, 2, 3, 4, 5,5);
        Optional<Integer> max = l.stream().max(Comparator.comparingInt(Integer::intValue));
        Optional<Integer> min = l.stream().min(Comparator.comparingInt(Integer::intValue));
        var minn =l.stream().mapToInt(e->e).average();
        var ans=l.stream().mapToInt(e->e).filter(e->e>2);
        System.out.println(max);
        System.out.println(min.equals(1));
        System.out.println(max.orElse(0)); // Print the maximum value or a default value (0) if the list is empty
    }
}
