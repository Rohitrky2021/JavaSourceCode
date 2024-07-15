public class _53PalindromePartition {
    private static int dp[];
    private static Boolean dpIsPalindrome[][];

    public static void main(String[] args) {
        String s = "aabaacbdbcmoon";
        int n = s.length();
        dp = new int[n];
        dpIsPalindrome = new Boolean[n][n];
        System.out.println(minCutFrom(s, 0, n - 1));
        System.out.println("tabu : " + tabu(s, n));
    }

    private static int minCutFrom(String s, int start, int end) {
        if (start == end || isPalindrome(s, start, end)) {
            return 0;
        }

        if (dp[start] != 0) return dp[start];

        int minCut = s.length() - 1;
        for (int i = start; i <= end; i++) {
            if (isPalindrome(s, start, i)) {
                minCut = Math.min(minCut, 1 + minCutFrom(s, i + 1, end));
            }
        }
        return dp[start] = minCut;
    }

    private static int tabu(String s, int n) {
        int[] dp = new int[n + 1];
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            int minCut = s.length();
            for (int j = i; j < n; j++) {
                if (tabuPalin(i, j, s)) {
                    minCut = Math.min(minCut, 1 + dp[j + 1]);
                }
            }
            dp[i] = minCut;
        }
        return dp[0] - 1; //-1 is done because for str=ABC code will give 3 partitions as 3 Palindromic substring A,B,C be formed. A|B|C
    }

    public static boolean tabuPalin(int i, int j, String s) {
        while (i <= j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

    private static boolean isPalindrome(String s, int start, int end) {
        if (start >= end) return true;

        if (dpIsPalindrome[start][end] != null) return dpIsPalindrome[start][end];

        return dpIsPalindrome[start][end] = (s.charAt(start) == s.charAt(end)) && isPalindrome(s, start + 1, end - 1);
    }
}

