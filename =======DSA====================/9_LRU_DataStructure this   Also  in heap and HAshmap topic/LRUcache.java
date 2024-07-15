public class LRUcache {
    public class LRUCache<K, V>{

        // Define Node with pointers to the previous and next items and a key, value pair
        class Node<T, U> {
            Node<T, U> previous;
            Node<T, U> next;
            T key;
            U value;
    
            public Node(Node<T, U> previous, Node<T, U> next, T key, U value){
                this.previous = previous;
                this.next = next;
                this.key = key;
                this.value = value;
            }
        }
    
        private HashMap<K, Node<K, V>> cache;
        private Node<K, V> leastRecentlyUsed;
        private Node<K, V> mostRecentlyUsed;
        private int maxSize;
        private int currentSize;
    
        public LRUCache(int maxSize){
            this.maxSize = maxSize;
            this.currentSize = 0;
            leastRecentlyUsed = new Node<K, V>(null, null, null, null);
            mostRecentlyUsed = leastRecentlyUsed;
            cache = new HashMap<K, Node<K, V>>();
        }
            

        public V get(K key){
            Node<K, V> tempNode = cache.get(key);
            if (tempNode == null){
                return null;
            }
            // If MRU leave the list as it is
            else if (tempNode.key == mostRecentlyUsed.key){
                return mostRecentlyUsed.value;
            }
    
            // Get the next and previous nodes
            Node<K, V> nextNode = tempNode.next;
            Node<K, V> previousNode = tempNode.previous;
    
            // If at the left-most, we update LRU 
            if (tempNode.key == leastRecentlyUsed.key){
                nextNode.previous = null;
                leastRecentlyUsed = nextNode;
            }
    
            // If we are in the middle, we need to update the items before and after our item
            else if (tempNode.key != mostRecentlyUsed.key){
                previousNode.next = nextNode;
                nextNode.previous = previousNode;
            }
    
            // Finally move our item to the MRU
            tempNode.previous = mostRecentlyUsed;
            mostRecentlyUsed.next = tempNode;
            mostRecentlyUsed = tempNode;
            mostRecentlyUsed.next = null;
    
            return tempNode.value;
    
        }
    
        public void put(K key, V value){
            if (cache.containsKey(key)){
                return;
            }
    
            // Put the new node at the right-most end of the linked-list
            Node<K, V> myNode = new Node<K, V>(mostRecentlyUsed, null, key, value);
            mostRecentlyUsed.next = myNode;
            cache.put(key, myNode);
            mostRecentlyUsed = myNode;
    
            // Delete the left-most entry and update the LRU pointer
            if (currentSize == maxSize){
                cache.remove(leastRecentlyUsed.key);
                leastRecentlyUsed = leastRecentlyUsed.next;
                leastRecentlyUsed.previous = null;
            }
    
            // Update cache size, for the first added entry update the LRU pointer
            else if (currentSize < maxSize){
                if (currentSize == 0){
                    leastRecentlyUsed = myNode;
                }
                currentSize++;
            }
        }
    }
}
