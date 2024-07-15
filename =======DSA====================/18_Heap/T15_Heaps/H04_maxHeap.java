
package T15_Heaps;

import java.util.ArrayList;

public class H04_maxHeap {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            arr.add(data);
            int child = arr.size() - 1;
            int par = (child - 1) / 2;

            while (arr.get(par) < arr.get(child)) { // #1
                int temp = arr.get(par);
                arr.set(par, arr.get(child));
                arr.set(child, temp);

                child = par;
                par = (child - 1) / 2;

            }
        }

        public int peek() {
            return arr.get(0);
        }

        public void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int maxIdx = i;
            if (left < arr.size() && arr.get(maxIdx) < arr.get(left)) { // #2
                maxIdx = left;
            }
            if (right < arr.size() && arr.get(maxIdx) < arr.get(right)) { // #3
                maxIdx = right;
            }

            if (i != maxIdx) {
                int temp = arr.get(maxIdx);
                arr.set(maxIdx, arr.get(i));
                arr.set(i, temp);
                heapify(maxIdx);
            }
        }

        public int remove() {
            int data = arr.get(0);

            int temp = arr.get(arr.size() - 1);
            arr.set(arr.size() - 1, data);
            arr.set(0, temp);

            arr.remove(arr.size() - 1);

            heapify(0);

            return data;
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(1);
        h.add(4);
        h.add(6);
        h.add(2);
        h.add(12);

        while (!h.isEmpty()) {
            System.out.println(h.peek());
            h.remove();
        }
    }
}
