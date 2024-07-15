import java.util.ArrayList;
import java.util.HashMap;

public class c1 {

    public static void main(String[] args) {
        // Example usage
        String[] queries = {"+4", "+5", "+6", "+4","+3","-4"};
        int difference = 1;
        c1 codeInstance = new c1();
        codeInstance.helper(queries, difference);
    
    }

    static int calc1(HashMap<Integer, Integer> hm, int val, int diff) {
        int ans = 0;

        if (hm.containsKey(val + diff) && hm.containsKey(val - diff)) {
            ans += hm.get(val + diff) * hm.get(val - diff);
        }
        if (hm.containsKey(val + diff) && hm.containsKey(val + 2 * diff)) {
            ans += hm.get(val + diff) * hm.get(val + 2 * diff);
        }
        if (hm.containsKey(val - diff) && hm.containsKey(val - 2 * diff)) {
            ans += hm.get(val - diff) * hm.get(val - 2 * diff);
        }

        return ans;
    }

    void helper(String[] q, int diff) {
        HashMap<Integer, Integer> hm = new HashMap<>();
       ArrayList<Integer> a=new ArrayList<>();

        int n = q.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            char op = q[i].charAt(0);
            int val = Integer.parseInt(q[i].substring(1));
            if (op == '+') {
                ans += calc1(hm, val, diff);
                hm.put(val, hm.getOrDefault(val, 0) + 1);
            } else {
                ans -= calc1(hm, val, diff) * hm.get(val);
                hm.remove(val);
            }
            
            a.add(ans);
        }

         System.out.println(a);
        // Print or use the result as needed
    }
}
