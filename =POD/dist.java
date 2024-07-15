import java.util.HashSet;
import java.util.Set;

public class dist {
    public static void main(String[] args) {
        String str = "baabacaa";

        // Create a set to store unique characters
        Set<Character> set = new HashSet<>( );

        for (char ch : str.toCharArray()) {
            set.add(ch);
        }

        int len = set.size();
        int diff = str.length() - len;
        int result = diff / 2 + (diff % 2);
        System.out.println(result);
    }
}
