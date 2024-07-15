// we have given a string s, we have to return the min no of cut we can do to get pallindromes
// we know a single character string is also pallindrome so if s : "abc" so 'a', 'b', 'c' all are palliindrome
// so here we did 2 cuts
// if s : "aab" max cut 2 to get 'a', 'a', 'b'
// we can do 1 cut also so we get 'aa' and 'b'
// so we have to find mincut
// so we run a loop and start doing cut from j = i to n
// after cut check the string
// if that string is pallindrome then add 1 for the cut and call the function afain for j+1 to n
// and using a min variable find out the mincut
public class Q51_Pallindrome_partioning_II {
    public static boolean isPallindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static int f(int i, int n, String s) {
        if (i == n)
            return 0;

        int min = Integer.MAX_VALUE;

        for (int j = i; j < n; j++) {
            if (isPallindrome(i, j, s)) {
                int cuts = 1 + f(j + 1, n, s);
                min = Math.min(min, cuts);
            }
        }

        return min;
    }

    public static void main(String[] args) {
        String str = "aab";
        int n = str.length() - 1;
        System.out.println(f(0, n - 1, str));
    }
}
