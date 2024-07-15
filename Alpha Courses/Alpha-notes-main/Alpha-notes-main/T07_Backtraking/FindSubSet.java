package T07_Backtraking;

public class FindSubSet {

    public static void main(String[] args) {
        subSet("ab", "", 0);
    }

    public static void subSet(String str, String ans, int i) {
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.err.println("null");
            } else {

                System.out.println(ans);
            }
            return;
        }
        subSet(str, ans + str.charAt(i), i + 1);
        subSet(str, ans, i + 1);
    }
}
