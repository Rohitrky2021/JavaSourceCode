import java.util.HashSet;

class Solution {

    static HashSet<String> s;

    public String findDifferentBinaryString(String[] nums) {
        String str = nums[0], ans = "";

        s = new HashSet<>();
        for (String c : nums)
            s.add(c);

        return perm(str, ans);

    }

    public static String perm(String str, String ans) {
        if (str.length() == 0 && !s.contains(ans)) {
            System.out.println(ans);
            return ans;

        }
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            String newstr = str.substring(0, i) + str.substring(i + 1); // all word string without the Curr one
            // System.out.println( newstr);

            perm(newstr, ans + curr);
        }
        return ans;
    }
}