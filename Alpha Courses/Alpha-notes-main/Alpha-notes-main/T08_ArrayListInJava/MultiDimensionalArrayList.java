package T08_ArrayListInJava;

import java.util.ArrayList;

public class MultiDimensionalArrayList {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            list.add(i);
            list2.add(i * 2);
            list3.add(i * 3);
        }
        mainList.add(list);
        mainList.add(list2);
        mainList.add(list3);
        System.out.println(mainList);

        // for (int i = 0; i < mainList.size(); i++) {
        // ArrayList<Integer> temp = mainList.get(i);
        // for (int j = 0; j < temp.size(); j++) {
        // System.out.print(temp.get(j) + " ");
        // }
        // System.out.println();
        // }
        // System.out.println(mainList.get(2).get(3));

        for (int i = 0; i < mainList.size(); i++) {
            for (int j = 0; j < mainList.get(i).size(); j++) {
                System.out.print(mainList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}