package T16_Hashing;

import java.util.*;

public class HM03_implimentation {
    public class HashMap<k, v> {

        public class Node {
            k key;
            v value;

            public Node(k key, v value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n;
        private int N;
        // type name[]; int arr[];
        private LinkedList<Node> buckets[];

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(k key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        private int SearchInLL(k key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if (node.key == key) {
                    return i;
                }
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node> oldBuck[] = buckets;
            N = N * 2;
            buckets = new LinkedList[N];
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }

            // nodes -> add in bucket
            for (int i = 0; i < oldBuck.length; i++) {
                LinkedList<Node> ll = oldBuck[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        public void put(k key, v value) {
            int bi = hashFunction(key);
            int di = SearchInLL(key, bi); // valid : -1
            if (di != -1) {
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {
                buckets[bi].add(new Node(key, value));
                n++;
            }
            double lamd = (double) n / N;
            if (lamd > 2.0) {
                rehash();
            }
        }

        public boolean containKey(k key) {
            int bi = hashFunction(key);
            int di = SearchInLL(key, bi); // valid : -1
            if (di != -1) {
                return true;
            } else {
                return false;
            }
        }

        public v get(k key) {
            int bi = hashFunction(key);
            int di = SearchInLL(key, bi); // valid : -1
            if (di != -1) {
                Node node = buckets[bi].get(di);
                return node.value;
            } else {
                return null;
            }
        }

        public v remove(k key) {
            int bi = hashFunction(key);
            int di = SearchInLL(key, bi); // valid : -1
            if (di != -1) {
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            } else {
                return null;
            }
        }

        public ArrayList<k> keySet() {
            ArrayList<k> keys = new ArrayList<>();

            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            return n == 0;
        }

    }

    public static void main(String[] args) {
        // HashMap<String, Integer> hm = new HashMap<>();
        // hm.put("india", 150);
        // hm.put("china", 100);
        // hm.put("us", 50);
        // hm.put("Nepal", 5);

        // ArrayList<String> keys = hm.keySet();
        // for (String key : keys) {
        //     System.out.println(key);
        // }

    }
}
