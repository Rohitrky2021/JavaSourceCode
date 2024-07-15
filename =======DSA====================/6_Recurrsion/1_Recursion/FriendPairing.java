package T05_Recursion;

public class FriendPairing {
    public static void main(String[] args) {
        System.out.println(pairing(4));
    }

    public static int pairing(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        return pairing(n - 1) + (n-1) * pairing(n - 2);
    }
}

public class FriendPairing {
    public static void main(String[] args) {
        System.out.println(pairing(4));
    }

    public static int pairing(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        // Array to store results of subproblems
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;

        // Fill dp array in bottom-up manner
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
        }

        return dp[n];
    }
}
