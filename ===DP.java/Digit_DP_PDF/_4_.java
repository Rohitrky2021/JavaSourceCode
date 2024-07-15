
//  also an O(LogN)^2 -->Approaaach 

// https://www.geeksforgeeks.org/find-the-number-in-a-range-having-maximum-product-of-the-digits/

class GFG {

    // Returns the product of digits of number x
    static int product(int x) {
        int prod = 1;
        while (x > 0) {
            prod *= (x % 10);
            x /= 10;
        }
        return prod;
    }

    // This function returns the number having
    // maximum product of the digits
    static int findNumber(int l, int r) {
        // Converting both integers to strings
        // string a = l.ToString();
        String b = Integer.toString(r);

        // Let the current answer be r
        int ans = r;
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) == '0')
                continue;

            // Stores the current number having
            // current digit one less than current
            // digit in b
            char[] curr = b.toCharArray();
            curr[i] = (char) (((int) (curr[i] -
                    (int) '0') - 1) + (int) ('0'));

            // Replace all following digits with 9
            // to maximise the product
            for (int j = i + 1; j < curr.length; j++)
                curr[j] = '9';

            // Convert string to number
            int num = 0;
            for (int j = 0; j < curr.length; j++)
                num = num * 10 + (curr[j] - '0');

            // Check if it lies in range and its product
            // is greater than max product
            if (num >= l && product(ans) < product(num))
                ans = num;
        }

        return ans;
    }

    // Driver Code
    public static void main(String[] args) {
        int l = 1, r = 10;
        System.out.println(findNumber(l, r));

        l = 51;
        r = 62;
        System.out.println(findNumber(l, r));
    }
}

// This code is contributed by chandan_jnu
