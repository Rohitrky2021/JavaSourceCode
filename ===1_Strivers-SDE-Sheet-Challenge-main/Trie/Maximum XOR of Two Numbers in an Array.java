import java.util.*;
import java.io.*;
// https://www.youtube.com/watch?v=JS48Hp2_Z4I
public class Solution {
    public static Trie insert(Trie root, int n) {
        Trie temp = root;
        int i = 0;

        while (i < 32) {
            int num = (n >> (31 - i)) & 1; // Right shift krke last 32 bit p kya hai we get easily 
            if (temp.children[num] != null) // Do index he hai 0 ya 1 unpar he jaake  nya bun jaayega 0>Left and 1->Right
                temp = temp.children[num];
            else {
                temp.children[num] = new Trie(); // 0 ya 1 index p new 2 array form ho jaayega for the Last 32 th but in  start
                temp = temp.children[num];
            }
            i++;
        }

        return root;
    }

    public static int maxxor(Trie root, int n) {
        int i = 0, ans = 0;
        Trie temp = root;// Hmm rooot k paas m hara 32th bit hai ryt now

        while (i < 32) {
            int num = (n >> (31 - i)) & 1;

            if (num == 0 && temp.children[1] != null) { // tera last bit 0 aaya tho next u find num jiska 1 ho 
                ans += (int) Math.pow(2, 31 - i); 
                temp = temp.children[1];
            } else if (num == 1 && temp.children[0] != null) {
                ans += (int) Math.pow(2, 31 - i);
                temp = temp.children[0];
            } else
                temp = temp.children[num]; // else jo aaya hai 0 or 1 me se uspe chle jaao 
            i++;
        }

        return ans;
    }

    public static int maximumXor(int[] A) {
        int ans = 0;
        Trie root = new Trie();

        for (int i = 0; i < A.length; i++)
            root = insert(root, A[i]);
        for (int i = 0; i < A.length; i++)
            ans = Math.max(ans, maxxor(root, A[i]));

        return ans;
    }

    static class Trie {
        Trie[] children;

        Trie() {
            children = new Trie[2];
            children[0] = null;
            children[1] = null;
        }
    }
}
