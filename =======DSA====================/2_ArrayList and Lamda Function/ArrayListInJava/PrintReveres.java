package T08_ArrayListInJava;

import java.util.ArrayList;

public class PrintReveres {

    public static void main(String[] args) {
        ArrayList<Integer> foo = new ArrayList<Integer>();
        foo.add(1);
        foo.add(1);
        foo.add(3);
        foo.add(35);
        foo.add(45);
        System.out.println(foo);
        System.out.println("reveres List is : ");
        for (int i = 0; i < foo.size(); i++) {
            System.out.print(foo.get(i) + " ");
        }
        System.out.println();
    }
}