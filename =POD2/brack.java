import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

class brack {
    public int maxDepth(String s) {

        char[] ch = s.toCharArray();

        int ans = 0;
        for (int i = 0; i < ch.length; i++) {
            if (Integer.parseInt(ch[i] + "") <= 9  && Integer.parseInt(ch[i] + "") >= 0  ) {
                int max = 0;
                for (int j = 0; j < ch.length; j++) {

                    if (ch[i] == '(') {
                        max++;
                    }
                    if (ch[i] == ')') {
                        max--;
                    }
                    if (max < 0) {
                        max = 0;
                    }
                }
                ans = Math.max(ans, max);

            }
        }

        return ans;
    }
}