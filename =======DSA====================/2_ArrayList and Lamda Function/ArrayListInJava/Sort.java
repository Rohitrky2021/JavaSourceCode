package T08_ArrayListInJava;

import java.util.ArrayList;
import java.util.Collections;

public class Sort {
    public static void main(String[] args) {
        ArrayList<Integer> ll = new ArrayList<>();
        ll.add(4);
        ll.add(1);
        ll.add(2);
        ll.add(5);
        ll.add(3);
        System.out.println(ll);
        Collections.sort(ll);
        System.out.println(ll);
        Collections.sort(ll, Collections.reverseOrder());//comperiter function define logic
        System.out.println(ll);

    }
}
