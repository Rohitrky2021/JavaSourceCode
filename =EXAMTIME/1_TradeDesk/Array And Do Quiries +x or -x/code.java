import java.util.HashMap;
import java.util.Map;

public class code {

    public static void main(String[] args) {
        // Example usage
        String[] queries = {"+4", "+5", "+6", "+4", "+3", "-4"};
        int difference = 1;
        code codeInstance = new code();
        codeInstance.helper(queries, difference);
    }

    static int calc1(Map<Integer, Integer> hm, int val, int diff) {
        return hm.getOrDefault(val + diff, 0) * hm.getOrDefault(val - diff, 0) +
               hm.getOrDefault(val + diff, 0) * hm.getOrDefault(val + 2 * diff, 0) +
               hm.getOrDefault(val - diff, 0) * hm.getOrDefault(val - 2 * diff, 0);
    }

    void helper(String[] q, int diff) {
        Map<Integer, Integer> hm = new HashMap<>();

        int ans = 0;

        for (String query : q) {
            char op = query.charAt(0);
            int val = Integer.parseInt(query.substring(1));
            ans += (op == '+' ? 1 : -1) * calc1(hm, val, diff);
            hm.merge(val, 1, (existing, one) -> existing + (op == '+' ? 1 : -1));
            System.out.println("Result: " + ans);
        }

        // Print or use the result as needed
    }
}
