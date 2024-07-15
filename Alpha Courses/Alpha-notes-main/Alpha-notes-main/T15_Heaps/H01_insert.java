package T15_Heaps;

import java.util.ArrayList;

public class H01_insert {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            arr.add(data);
            int child = arr.size() - 1;
            int par = (child - 1) / 2;

            while (arr.get(par) > arr.get(child)) {
                int temp = arr.get(par);
                arr.set(par, arr.get(child));
                arr.set(child, temp);
                child = par;
                par = (child - 1) / 2;
            }
        }
    }

    public static void main(String[] args) {

    }
}
