import java.util.Scanner;

public class b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();
        Solution solution = new Solution();
        while (t-- > 0) {
            int n = scanner.nextInt();
            String str = scanner.next();
            int result = solution.calculateMaxFrequencyDifference(n, str);
            System.out.println(result);
        }
        
        scanner.close();
    }
}

class Solution {
    public int calculateMaxFrequencyDifference(int n, String str) {
        int[] cnt = new int[26];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < str.length(); i++) {
            cnt[str.charAt(i) - 'a']++;
            max = Math.max(max, cnt[str.charAt(i) - 'a']);
        }
        return Math.max(n % 2, max - (n - max));
    }
}



// import java.util.*;
// public class B {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int t = sc.nextInt();
//         while(t-- > 0){
//             int n = sc.nextInt();
//             String s = sc.next();
//             int map[] = new int[26];
//             int maxi = 0;
//             for(int i = 0; i < n; i++){
//                 maxi = Math.max(maxi,++map[s.charAt(i) - 'a']);
//             }
//             if(maxi <= n/2) System.out.println(n%2);
//             else System.out.println(maxi - (n - maxi));
//         }
//     }
// }