import java.util.HashMap;

public class code {
    public static String shift(String s) {
        String minStr = s;
        for (int i = 0; i < s.length(); i++) {
            s = s.substring(1) + s.charAt(0);
            if (s.compareTo(minStr) < 0) {
                minStr = s;
            }
        }
        return minStr;
    }

    public static int solve(int[] a) {
        HashMap<String, Integer> m = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            String s = Integer.toString(a[i]);
            String minStr = shift(s);
            m.put(minStr, m.getOrDefault(minStr, 0) + 1);
        }
        int count = 0;
        for (HashMap.Entry<String, Integer> entry : m.entrySet()) {
            int n = entry.getValue();
            count += (n * (n - 1)) / 2;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] array = {13, 5604, 31, 2, 13, 4560, 546, 654, 456}; //5
        int result = solve(array);
        System.out.println(result);
    }
}


// https://t.me/skill_sailor_discussion/22048