package T08_ArrayListInJava;

import java.util.*;
// package ArrayList;

public class Oprations {

    public static void main(String[] args) {

        // ArrayList<Integer> list = new ArrayList<>(); // optional
        // it can be Boolean, String, charecter, Double, Float... (only Class)
        ArrayList<Integer> list = new ArrayList<Integer>();

        // Add element
        list.add(1); // O(1)
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);

        // Get Element
        int ele = list.get(2); // O(1)
        System.out.println(ele);

        // Remove Element

        list.remove(2);// O(n)
        System.out.println(list);

        // set Element At index

        list.set(2, 5);// O(n)
        System.out.println(list);

        // Contains Element 
        System.out.println(list.contains(2));//O(n)
        System.out.println(list.contains(12));
    }
}

