package Heaps;

import java.util.ArrayList;

public class Heap {
    static class HeapImplementation {
        ArrayList<Integer> list = new ArrayList<>();

        public void add(int data) {
            list.add(data);

            int x = list.size() - 1;
            int parent = (x - 1) / 2;

            while (list.get(x) < list.get(parent)) {
                int temp = list.get(x);
                list.set(x, list.get(parent));
                list.set(parent, temp);

                x = parent;
                parent = (x - 1) / 2;
            }
        }

        public int peek() {
            return list.get(0);
        }

        public int remove() {
            int data = list.get(0);

            // swap first and last element
            int temp = list.get(list.size() - 1);
            list.set(list.size() - 1, list.get(0));
            list.set(0, temp);
            

            // remove last element from list
            list.remove(list.size() - 1);

            heapify(0);
            return data;
        }

        private void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIndex = i;

            if (left < list.size() && list.get(minIndex) > list.get(left)) {
                minIndex = left;
            }

            if (right < list.size() && list.get(minIndex) > list.get(right)) {
                minIndex = right;
            }

            if (minIndex != i) {
                // swap
                int temp = list.get(i);
                list.set(i, list.get(minIndex));
                list.set(minIndex, temp);

                heapify(minIndex);
            }
        }

        public boolean isEmpty() {
            return list.size() == 0;
        }
    }

    public static void main(String args[]) {
        HeapImplementation h = new HeapImplementation();
        h.add(3);
        h.add(4);
        h.add(2);
        h.add(1);

        while(!h.isEmpty()) {
            System.out.println(h.remove());
        }
    }
}
