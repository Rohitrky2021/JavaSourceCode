public class Calssyumber {
    // https://codeforces.com/problemset/problem/1036/C

}

public class C_Classy_Numbers {
    public static void main(String args[]) throws IOException {
        Input sc = new Input();
        int t = sc.nextInt();
        while (t-- > 0) {
            long l = sc.nextLong();
            long r = sc.nextLong();
            int[][][] dp = new int[20][2][20];
            for (int[][] a : dp) {
                for (int[] b : a) {
                    Arrays.fill(b, -1);
                }
            }
            long leftCount = solve(l - 1 + "", 0, true, 0, dp);
            for (int[][] a : dp) {
                for (int[] b : a) {
                    Arrays.fill(b, -1);
                }
            }
            long rightCount = solve(r + "", 0, true, 0, dp);
            System.out.println(rightCount - leftCount);
        }

        sc.close();
    }

    static int solve(String s, int idx, boolean flag, int nonZeroDigit, int[][][] dp) {
        int t = flag ? 1 : 0;
        if (dp[idx][t][nonZeroDigit] != -1)
            return dp[idx][t][nonZeroDigit];
        if (idx == s.length())
            return 1;
        int ans = 0;
        long limit = flag ? (s.charAt(idx) - '0') : 9L;
        for (int digit = 0; digit <= limit; digit++) {
            int temp = digit != 0 ? nonZeroDigit + 1 : nonZeroDigit;
            if (temp <= 3) {
                ans += solve(s, idx + 1, flag & (digit == limit), temp, dp);
            }
        }
        dp[idx][t][nonZeroDigit] = ans;
        return ans;
    }


// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>
// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>


    public class Main {

        static int mod = (int) (1e9) + 7;

        public static void main(String[] args) {

            FastReader s = new FastReader();
            PrintWriter out = new PrintWriter(System.out);

            int T = s.nextInt();

            while (T > 0) {
                T--;

                long l = s.nextLong();
                long r = s.nextLong();

                l = l - 1;
                String L = String.valueOf(l);
                String R = String.valueOf(r);

                long dp1[][][] = new long[R.length() + 1][R.length() + 1][2];
                long dp2[][][] = new long[L.length() + 1][L.length() + 1][2];

                for (long row[][] : dp1) {
                    for (long col[] : row) {
                        Arrays.fill(col, -1);
                    }
                }
                for (long row[][] : dp2) {
                    for (long col[] : row) {
                        Arrays.fill(col, -1);
                    }
                }

                long a = solve(R.length(), R, 0, 1, dp1);
                long b = solve(L.length(), L, 0, 1, dp2);

                System.out.println(a - b);

                // end of while loop
            }
        }

        private static long solve(int n, String num, int count, int tight, long dp[][][]) {

            if (n == 0) {

                if (count <= 3) {

                    return 1;
                }
                return 0;
            }
            if (dp[n][count][tight] != -1) {

                return dp[n][count][tight];
            }

            int ub = tight == 0 ? 9 : (int) (num.charAt(num.length() - n) - '0');

            long ans = 0;
            for (int dig = 0; dig <= ub; dig++) {

                ans = ans + solve(n - 1, num, dig > 0 ? count + 1 : count, ub == dig ? tight : 0, dp);
                // System.out.println(ans + " j" + " " +dig + " "+ tight + " " +n + " "+ ub);
            }

            // System.out.println(n + " " + ans + " ans");
            return dp[n][count][tight] = ans;

        }


// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>
// ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>


        public class Main {

            static int mod = (int) (1e9) + 7;

            public static void main(String[] args) {

                FastReader s = new FastReader();
                PrintWriter out = new PrintWriter(System.out);

                int T = s.nextInt();

                while (T > 0) {
                    T--;

                    long l = s.nextLong();
                    long r = s.nextLong();

                    l = l - 1;
                    String L = String.valueOf(l);
                    String R = String.valueOf(r);

                    long dp1[][][] = new long[R.length() + 1][R.length() + 1][2];
                    long dp2[][][] = new long[L.length() + 1][L.length() + 1][2];

                    for (long row[][] : dp1) {
                        for (long col[] : row) {
                            Arrays.fill(col, -1);
                        }
                    }

                    for (long row[][] : dp2) {
                        for (long col[] : row) {
                            Arrays.fill(col, -1);
                        }
                    }

                    long a = solve(R.length(), R, 0, 1, dp1);
                    long b = solve(L.length(), L, 0, 1, dp2);

                    System.out.println(a - b);

                    // end of while loop
                }
            }

    private static long solve(int n, String num , int count , int tight , long dp[][][]) {

        if(n == 0){

            if(count  <= 3){

                return 1;
            }
            return 0;
        }
        if(dp[n][count][tight] != -1){

            return dp[n][count][tight];
        }


        int ub = tight == 0 ? 9 : (int)(num.charAt(num.length() - n) - '0');

long  ans = 0;
        for(int dig = 0; dig<=ub; dig++){

           ans = ans + solve(n-1 ,num , dig > 0 ? count+1:count , ub == dig ? tight : 0,dp);
//            System.out.println(ans + " j" + " "  +dig + " "+ tight + " " +n + " "+ ub);
        }

//        System.out.println(n + " " + ans + " ans");
            return dp[n][count][tight] =  ans;

    }



    
    // ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>
    // ------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>
    