

    import java.util.HashMap;
    import java.util.Map;
    
    public class Ms1 {
        private static Map<String, Integer> memo = new HashMap<>();
    
        public static int recurCost(int[] lst, int x, int y, int pos, int currCost, int count) {
            int minCost = Integer.MAX_VALUE;
            String key = pos + "|" + count;
    
            if (memo.containsKey(key)) {
                return memo.get(key);
            }
    
            if (pos >= lst.length && count == 0) {
                return currCost;
            }
    
            if (pos >= lst.length) {
                return minCost;
            }
    
            if (count == 0) {
                return currCost;
            }
    
            int curr = recurCost(lst, x, y, pos + y, lst[pos] + currCost, count - 1);
            int skipCurr = recurCost(lst, x, y, pos + 1, 0, x);
            minCost = Math.min(minCost, Math.min(curr, skipCurr));
            memo.put(key, minCost);
            return minCost;
        }
    
        public static int minRehabCost(int[] lst, int x, int y) {
            memo.clear();
            return recurCost(lst, x, y, 0, 0, x);
        }
    
        public static void main(String[] args) {
            int[] lst = {4,2,3,7};
            int x = 2;
            int y = 2;
    
            int result = minRehabCost(lst, x, y);
            System.out.println("Minimum rehab cost: " + result);
        }
    }
    