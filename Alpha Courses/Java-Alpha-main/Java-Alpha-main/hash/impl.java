import java.util.*;
public class impl {
    static class HashMap<K,V>{ //generic
        public class Node{
            K key;
            V value;
            public Node(K key,V value){
                this.key = key;
                this.value = value;
            }
        }

        private int n;//n
        private int N;
        private LinkedList<Node> buckets[];//N
        
        @SuppressWarnings("unckecked")
        public HashMap(){
        this.N = 4;
        this.buckets = new LinkedList[4];
        for(int i=0;i<N;i++){
            this.buckets[i] = new LinkedList<>();
            }
        }
        
        private int hashFunction(K key){
            int hc  = key.hashCode();
            return Math.abs(hc)%N;
        }

        private int searchinll(K key,int bi) {
            LinkedList<Node> ll = buckets[bi];
            int di=0;
            for(int i=0 ; i < ll.size();i++){
                Node node = ll.get(i);
                if(node.key == key){
                    return di;
                }
                di++;
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash(){
            LinkedList<Node> old[] = buckets;
            buckets =  new LinkedList[N*2];
            N = N*2;
            for(int i = 0 ; i < buckets.length ;i++){
                buckets[i] = new LinkedList<>();
            }
            for(int i = 0 ; i < old.length ; i++){
                LinkedList<Node> ll = old[i]; 
                for(int j = 0 ; j < ll.size() ;j++){
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        public void put (K key, V value){
            int bi = hashFunction(key);
            int di = searchinll(key,bi);
            if(di != -1){
                Node node = buckets[bi].get(di);
                node.value = value;
            }else{
                buckets[bi].add(new Node(key, value));
                n++;
            }
            double lamda = (double)n/N;
            if(lamda > 2.0){
                rehash();
            }
        } 

        public boolean containsKey(K key){
            int bi = hashFunction(key);
            LinkedList<Node> ll = buckets[bi];
            for(int i=0 ; i < ll.size() ;i++){
                Node node = ll.get(i);
                if(node.key == key){
                    return true;
                }
            }
            return false;
        } 

        public V get(K key){
            int bi = hashFunction(key);
            LinkedList<Node> ll = buckets[bi];
            for(int i=0 ; i < ll.size() ;i++){
                Node node = ll.get(i);
                if(node.key == key){
                    return node.value;
                }
            }
            return null;
        }

        public V remove(K key){
            int bi = hashFunction(key);
            LinkedList<Node> ll = buckets[bi];
            for(int i=0 ; i < ll.size() ;i++){
                Node node = ll.get(i);
                if(node.key == key){
                    Node node1 = ll.remove(i);
                    n--;
                    return node1.value;
                }
            }
            return null;
        }

        public ArrayList<K> keyset(){
            ArrayList<K> keys = new ArrayList<>();
            for(int i =0 ; i < buckets.length ;i++){
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty(){
            return n==0;
        }
    }
    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("Nepal", 6);
        hm.put("Bhutan", 88);
        hm.put("US", 80);

        ArrayList<String> aaa = hm.keyset();
        for (String val : aaa) {
            System.out.println(val);
        }
        System.out.println(hm.get("India"));
        System.out.println(hm.remove("India"));
        System.out.println(hm.get("India"));
        
    }
}
