import java.util.TreeSet;

public class te {
    public static void main(String[] args) {
        String inputString = "babcbb";
        tii(inputString);
    }

    public static void tii(String s) {
        String ans = "";

        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (char i = 'a'; i <= 'z'; i++) {
            if (count[i - 'a'] > 0) {
                ans += i;
                count[i - 'a']--;
            }
        }
        for (char i = 'a'; i <= 'z'; i++) {
            while (count[i - 'a'] > 0) {
                ans += i;
                count[i - 'a']--;
            }
        }

        System.out.println(ans);
    }
}


public class tew {
    public static void main(String[] args) {
     
        String s = "babcbb";

        TreeSet<Character> tr=new TreeSet<>();

        for (char c : s.toCharArray()) {
            tr.add(c);
        }

        

        
        tii(inputString);

        
    }

    public static void tii(String s) {
        String ans = "";

        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (char i = 'a'; i <= 'z'; i++) {
            if (count[i - 'a'] >= 1) {
                ans += i;
                System.out.println(ans);
                count[i - 'a']--;
            }
        }

        for (char i = 'a'; i <= 'z'; i++) {
            while (count[i - 'a'] >= 0) ans += i;

            System.out.println(ans);
        }
        System.out.println(ans);
    }
 
}