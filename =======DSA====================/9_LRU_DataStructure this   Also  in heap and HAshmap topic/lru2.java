import java.util.LinkedHashMap;
import java.util.Map;
public class lru2 {
    

public static class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

}
public static void main(String[] args) {
    LRUCache<Integer, String> cache = new LRUCache<>(3);

    cache.put(1, "One");
    cache.put(2, "Two");
    cache.put(3, "Three");

   

    System.out.println(cache);  // Output: {1=One, 2=Two, 3=Three}

    cache.get(2);  // Accessing key 2, making it the most recently used

    cache.put(4, "Four");  // Adding a new key-value pair, causing key 1 to be evicted

    System.out.println(cache);  // Output: {2=Two, 3=Three, 4=Four}
}

}