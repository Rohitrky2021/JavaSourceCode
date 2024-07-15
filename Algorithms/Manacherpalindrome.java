import java.util.Arrays;

class Manacher {
    String t;
    int[] p;
    int lpsStart, lpsLength;

    public Manacher(String s) {
        for (char c : s.toCharArray()) {
            t += "#" + c;
        }
        t += "#";

        build();
    }

    void build() {
        int n = t.length();
        p = new int[n];
        Arrays.fill(p, 1);

        int l = 1, r = 1;

        for (int i = 1; i < n; i++) {
            if (l + r - i >= 0)
                p[i] = Math.max(1, Math.min(r - i, p[l + r - i]));

            while (i - p[i] >= 0 && i + p[i] < n && t.charAt(i - p[i]) == t.charAt(i + p[i]))
                p[i]++;

            if (i + p[i] > r) {
                l = i - p[i];
                r = i + p[i];

                if (lpsLength < p[i]) {
                    lpsStart = l + 2;
                    lpsLength = p[i] - 1;
                }
            }
        }
    }

    int getLongest(int center, boolean odd) {
        int position = 2 * center + 1 + (odd ? 1 : 0);
        return p[position] - 1;
    }

    boolean checkPalindrome(int l, int r) {
        if ((r - l + 1) <= getLongest((l + r) / 2, (r - l + 1) == 1))
            return true;
        return false;
    }

    String longestPalindromeSubstring() {
        int n = t.length();
        StringBuilder ans = new StringBuilder();
        for (int i = lpsStart; i < n && lpsLength-- > 0; i += 2) {
            ans.append(t.charAt(i));
        }
        return ans.toString();
    }
}

class Solution {
    public String longestPalindrome(String s) {
        Manacher m = new Manacher(s);
        return m.longestPalindromeSubstring();
    }
}
