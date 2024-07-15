package T09_LinkedList;

import java.util.LinkedList;

public class LL18_collection {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>();
        ll.add("b");
        ll.addFirst("a");
        ll.addFirst("a");
        ll.addLast("c");
        System.out.println(ll);
        ll.remove();
        ll.removeFirst();
        ll.removeLast();
        System.out.println(ll);
    }
}
