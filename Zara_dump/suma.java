import javafx.util.Pair;

public class suma {
    public static void main(String args[]) {
        // Assuming you have some values for x and y
        int x = 1;
        String y = "One";

        // Creating a Pair
        Pair<Integer, String> pair = new Pair<>(x, y);

        // Accessing key and value
        Integer key = pair.getKey();
        String value = pair.getValue();

        // Printing the key
        System.out.println(key);
    }
}

