
import java.util.*;
// import java.lang.*;
// import java.io.*;

class Codechef {

    public static void solve(){
        
    }
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String str = sc.next();
            int temp = 1;
            char ch = str.charAt(0);
            StringBuilder strb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (ch == str.charAt(i)) {
                    temp++;
                } else {
                    if (temp % 2 == 0) {
                        strb.append(ch);
                        strb.append(ch);

                    } else {
                        strb.append(ch);

                    }
                    ch = str.charAt(i);
                    temp = 1;
                }
            }
            if (temp % 2 == 0) {
                strb.append(ch);
                strb.append(ch);
            } else {
                strb.append(ch);
                System.out.println(strb);

            }
        }
        sc.close();
    }
}
