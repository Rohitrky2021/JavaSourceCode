package T08_ArrayListInJava;

import java.util.ArrayList;

public class SizeOfArrayList {
    public static void main(String[] args) {
        ArrayList<Character> ch = new ArrayList<>();
        ch.add('a');
        ch.add('b');
        ch.add('c');
        ch.add('d');
        // size of ArrayList
        System.out.println(ch.size());

        for (int i = 0; i < ch.size(); i++) {
            System.out.print(ch.get(i) + " ");
        }
        System.out.println();
    }
}
