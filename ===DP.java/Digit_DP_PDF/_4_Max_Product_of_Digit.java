
// JAVA program for the above approach
import java.util.*;
import java.io.*;
import java.math.*;

// https://www.geeksforgeeks.org/find-the-number-in-a-range-having-maximum-product-of-the-digits/

class _4_Max_Product_of_Digit {

    // pair of array to store product and number
    // dp[pos][tight1][tight2][start]
    static class pair {
        int first;
        String second;

        pair(int first, String second) {
            this.first = first;
            this.second = second;
        }
    }

    static pair dp[][][][];

    static pair recur(String l, String r, int pos, int ta,
            int tb, int st) {

        // Base case if pos is equal
        // to l or r size return
        // pair{1,""}
        if (pos == l.length()) {
            return new pair(1, "");
        }

        // look up condition
        if (dp[pos][ta][tb][st].first != -1)
            return dp[pos][ta][tb][st];

        // Lower bound condition
        int start = ta == 1 ? l.charAt(pos) - '0' : 0;

        // Upper bound condition
        int end = tb == 1 ? r.charAt(pos) - '0' : 9;

        // To store the maximum product
        // initially it is set to -1
        int ans = -1;

        // To store the corresponding
        // number as number is large
        // so store it as a string
        String s = "";

        for (int i = start; i <= end; i++) {

            // Multiply with this val
            int val = i;

            // check for leading zeroes as 00005
            if (st == 0 && i == 0) {

                val = 1;
            }

            // Recursive call for next
            // position and store it in
            // a pair first gives
            // maximum product pair
            // second gives number which
            // gave maximum product
            pair temp

                    = recur(l, r, pos + 1, ta == 1 ? (i == start ? 1 : 0) : 0,

                            tb == 1 ? (i == end ? 1 : 0) : 0, (st | i) > 0 ? 1 : 0);

            // check if calculated product is greater than
            // previous calculated ans
            if (temp.first * val > ans) {

                ans = temp.first * val;

                // update string only if no leading zeroes
                // becoz no use to append the leading zeroes
                if (i == 0 && st == 0) {

                    s = temp.second;
                }

                else {

                    s = temp.second;

                    s += (i);
                }
            }
        }

        // while returning memoize the ans
        return dp[pos][ta][tb][st] = new pair(ans, s);
    }

    static String reverse(String x) {
        StringBuilder sb = new StringBuilder("");
        sb.append(x);
        sb.reverse();
        return sb.toString();
    }

    static pair solve(int a, int b)

    {

        // convert int l to string L and int r to string R ,
        // as integer value should be large
        String L = Integer.toString(a);
        String R = Integer.toString(b);

        // to make the size of strings
        // equal append zeroes in
        // front of string L
        if (L.length() < R.length()) {

            L = reverse(L);

            while (L.length() < R.length()) {

                L += "0";
            }

            L = reverse(L);
        }

        // initialize dp
        // as it is pair of array so memset will not work
        for (int i = 0; i < 20; i++) {

            for (int j = 0; j < 2; j++) {

                for (int k = 0; k < 2; k++) {

                    for (int l = 0; l < 2; l++) {

                        dp[i][j][k][l] = new pair(-1, "");
                    }
                }
            }
        }

        // as we have to return pair second value
        // it's that number which gaves maximum product
        // initially pos=0,ta=1,tb=1,start=0(becoz number is not
        // started yet)

        pair ans = recur(L, R, 0, 1, 1, 0);

        // reverse it becoz we were appending from right to left
        // in recursive call
        ans.second = reverse(ans.second);
        pair result = new pair(ans.first, ans.second);
        return result;
    }

    public static void main(String args[]) {

        // take l and r as input
        int l = 52, r = 62;
        System.out.println("l= " + l);
        System.out.println("r= " + r);

        // creation of dp table
        dp = new pair[20][2][2][2];

        // call function
        pair ans = solve(l, r);
        System.out.println("Maximum Product: " + ans.first);
        System.out.println("Number which gave maximum product: " + ans.second);
    }
}

// This code is contributed by Debojyoti Mandal
