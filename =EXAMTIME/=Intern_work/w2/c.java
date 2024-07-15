import java.util.*;
import java.io.*;

public class c {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        Solution solution = new Solution();
        StringBuilder out = new StringBuilder();

        for (int ig = 0; ig < t; ++ig) {
            int n = scanner.nextInt();
            String s = scanner.next();
            String result = solution.processString(n, s);
            out.append(result).append("\n");
        }
        
        System.out.println(out.toString());
        scanner.close();
    }
}

class Solution {
    public String processString(int n, String s) {
        int[] cnts = new int[26];
        for (int i = 0; i < n; ++i) cnts[s.charAt(i) - 'a']++;
        char[] vals = new char[n + 1];
        vals[0] = (char) ('a' - 1);
        int ind = 1;
        for (int i = 0; i < 26; ++i) {
            while (cnts[i]-- > 0) vals[ind++] = (char) ('a' + i);
        }
        if (vals[n] != vals[n - 1]) {
            return String.valueOf(vals[n]);
        }
        int[] nexts = new int[n + 1];
        Arrays.fill(nexts, -1);
        int start = 0;
        int[] lasts = new int[n + 1];
        for (int i = 0; i <= n; ++i) lasts[i] = i;
        boolean[] changes = new boolean[n + 1];
        for (int i = 1; i <= n; ++i) {
            changes[i] = vals[i] != vals[i - 1];
            if (changes[i]) start = i;
        }
        int nextStart = start;
        for (int i = 0, j = start; i < n; ) {
            if (j > n) {
                start = nextStart;
                j = start;
            } else if (i >= start) {
                start = j;
                nextStart = start;
            } else {
                nexts[lasts[j]] = i;
                lasts[j] = lasts[i];
                changes[j] = j == start || changes[i];
                if (changes[j]) nextStart = j;
                ++i;
                ++j;
            }
        }
        StringBuilder result = new StringBuilder();
        int v = n;
        while (v > 0) {
            result.append(vals[v]);
            v = nexts[v];
        }
        return result.toString();
    }
}
