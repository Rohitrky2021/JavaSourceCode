package T12_Greedy_Algo;

public class G07_balencedStr {

    public static void main(String[] args) {
        int n = 12;
        String str = "LRRRRLLRLLRL";
        System.out.println(balencedStr(n, str));
    }

    public static int balencedStr(int n, String str) {
        int r = 0, l = 0, ans = 0;

        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'R') {
                r++;
            } else if (str.charAt(i) == 'L') {
                l++;
            }
            if (r == l) {
                ans++;
            }
        }
        return ans;
    }
}
