import java.util.HashMap;
import java.util.*;

public class hashmap {
    public static void main(String args[]) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("rohit", 10);
        hm.put("india", 20);
        hm.put("china", 30);
        int pop = hm.get("rohit");
        System.out.println(hm);
        System.out.println(pop);
        Set<String> key = hm.keySet();
        System.out.println(key);
        for (String k : key) {
            System.out.println("key=" + k + " value is" + hm.get(k));
        }
        System.out.println(hm.entrySet());

    }

    // Hashmaps are best used when you need to map keys to values, and you need to
    // be able to quickly retrieve the value associated with a given key. They are
    // particularly useful when you have a large collection of data and need to
    // perform frequent lookups or updates.

    /*
     * Some examples of situations where hashmaps are commonly used include:
     * 
     * Storing and retrieving configuration settings: A hashmap can be used to store
     * configuration settings for an application, with each key representing a
     * setting name and each value representing the corresponding value for that
     * setting.
     * 
     * Caching frequently accessed data: A hashmap can be used to cache data that is
     * frequently accessed, such as database records or results of computationally
     * expensive operations. This can help improve performance by reducing the
     * number of times the data needs to be looked up or computed.
     * 
     * Counting occurrences of items: A hashmap can be used to count the number of
     * occurrences of each item in a collection. Each key represents an item, and
     * the corresponding value represents the number of times that item appears in
     * the collection.
     * 
     * Implementing lookup tables: A hashmap can be used to implement a lookup
     * table, where each key represents a lookup value and the corresponding value
     * represents the result of the lookup.
     * 
     * While hashmaps can be very useful in many situations, they are not always the
     * best choice. In some cases, a simple list or array may be sufficient, or a
     * more specialized data structure may be more appropriate. It's important to
     * choose the right data structure for the task at hand in order to ensure
     * optimal performance and maintainability
     */
}
