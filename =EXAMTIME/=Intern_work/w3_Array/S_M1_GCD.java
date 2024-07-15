
// https://codeforces.com/problemset/problem/1933/D
import java.util.HashMap;
import java.util.Scanner;

public class S_M1_GCD {
    

// public class Main {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int tes = sc.nextInt();
        Solution solution = new Solution();

        for (int t = 1; t <= tes; t++) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            
            String result = solution.checkArray(n, a);
            System.out.println(result);
        }

        sc.close();
    }
}

class Solution {
    public String checkArray(int n, int[] a) {
        long gcd = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            gcd = gcd(a[i], gcd);
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }

        if (map.getOrDefault((int) gcd, 0) > 1) {
            return "NO";
        }

        return "YES";
    }

    
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

     
}
