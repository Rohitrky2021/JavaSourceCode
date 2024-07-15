import java.util.Arrays;

class ok {
    static int minCost(String s, int K) {
        int n = s.length();
        int res = Integer.MAX_VALUE, c = 0, a, b;
        int[] cnt = new int[27];
        Arrays.fill(cnt, 0);

        for (int i = 0; i < n; i++)
            cnt[s.charAt(i) - 'a' + 1]++;

        for (int i = 1; i < (26 - K + 1); i++) {
            a = i;
            b = i + K;
            c = 0;
            for (int j = 1; j <= 26; j++) {
                if (cnt[j] > 0) {
                    if (j >= a && j >= b)
                        c += (Math.min(j - b, 25 - j + a + 1)) * cnt[j];
                    else if (j <= a && j <= b)
                        c += (Math.min(a - j, 25 + j - b + 1)) * cnt[j];
                }
            }
            res = Math.min(res, c);
        }

        for (int i = 26 - K + 1; i <= 26; i++) {
            a = i;
            b = (i + K) % 26;
            c = 0;
            for (int j = 1; j <= 26; j++) {
                if (cnt[j] > 0) {
                    if (j >= b && j <= a)
                        c += (Math.min(j - b, a - j)) * cnt[j];
                }
            }
            res = Math.min(res, c);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "adpgki";
        int K = 2;
        System.out.println(minCost(s, K));
    }
}
