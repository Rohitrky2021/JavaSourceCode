import java.util.LinkedList;

public class start {//impplementation
    static class Hashmap<K,V>{
        private class Node{
            K key;
            V value;
            public Node(K key,V value){
                this.key=key;
                this.value=value;
            }
            
        }
        private int  n;
        private int N;
        private LinkedList<Node> bucket[];
        
            @SuppressWarnings("unchecked")
            public Hashmap(){
                // this. n=4;
                this.N=4;
                this.bucket=new LinkedList[4];
                for (int i = 0; i < 4; i++) {
                    this.bucket[i]=new LinkedList<>();
                }
            }
                public int hashfunction(K key){
                    int hc=key.hashCode();
                    return Math.abs(hc)% N; 
                  }

                private int searchLL(K key,int bi){
                    LinkedList<Node> ll=bucket[bi];
                    int di=0;
                    for (int i = 0; i < ll.size(); i++) {
                        Node node=ll.get(i);
                        if(node.key == key){
                            return di;
                        }
                        di++;
                    }
                    return -1;
                }    
                private void rehash()
                {
                    LinkedList<Node> oldbucket[]=bucket;
                    N=2*N;
                    bucket=new LinkedList[N];
                    for (int i = 0; i < bucket.length; i++) {
                        bucket[i]=new LinkedList<>();
                    }
                    for (int j = 0; j < bucket.length; j++) {
                        LinkedList<Node> ll=oldbucket[j];
                        for (int i = 0; i < ll.size(); i++) {
                            Node node=ll.remove();
                            put(node.key, node.value);
                        }
                    }


                }

                public void put(K key,V value){//O(lamda)--->O(1)pu
                    int bi/*bucket INdex */=hashfunction(key);//0 to 3 ->size-1;
                    int di/*data Index */=searchLL(key,bi);
                    if(di!=-1){
                        Node node=bucket[bi].get(di);
                        node.value=value;
                    }
                    else{
                        bucket[bi].add(new Node(key, value));
                         n++;
                    }
                    double lamda=(double)n/N;
                    if(lamda>2.0){
                        rehash();
                    }
                    

                }
                public Boolean containsKey(K key){
                    int bi/*bucket INdex */=hashfunction(key);//0 to 3 ->size-1;
                    int di/*data Index */=searchLL(key,bi);
                    if(di!=-1){
                       return true;
                    }
                    else{
                       return false;
                    }
                    
                }
                public V get(K key){
                    int bi/*bucket INdex */=hashfunction(key);//0 to 3 ->size-1;
                    int di/*data Index */=searchLL(key,bi);
                    if(di!=-1){
                        Node node=bucket[bi].get(di);
                       return node.value;
                    }
                    else{
                        return null;
                    }

                }
                public V remove(K key){
                    int bi/*bucket INdex */=hashfunction(key);//0 to 3 ->size-1;
                    int di/*data Index */=searchLL(key,bi);
                    if(di!=-1){
                        Node node=bucket[bi].remove(di);
                       return node.value;
                    }
                    else{
                        return null;
                    }
                }
            }
    public static void main(String args[]){
        Hashmap<String,Integer> hm=new Hashmap();
        hm.put("india", 150);
        hm.put("pak", 100);
        hm.put("0k", 200);

        hm.put("boka", 300);
        // System.out.println(hm.get);

        


            }
        }
    


