// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.io.IOException;
// import java.util.Arrays;

// public class _2_ {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int t = Integer.parseInt(br.readLine().trim());
        
//         while (t-- > 0) {
//             String[] input = br.readLine().trim().split(" ");
//             int n = Integer.parseInt(input[0]);
//             int k = Integer.parseInt(input[1]);
//             int m = Integer.parseInt(input[2]);
//             String s = br.readLine().trim();
            
//             StringBuilder res = new StringBuilder();
//             boolean[] found = new boolean[k];
//             int count = 0;
            
//             for (char c : s.toCharArray()) {
//                 if (res.length() == n) {
//                     break;
//                 }
//                 if (!found[c - 'a']) {
//                     count++;
//                 }
//                 found[c - 'a'] = true;
                
//                 if (count == k) {
//                     Arrays.fill(found, false);
//                     count = 0;
//                     res.append(c);
//                 }
//             }
            
//             if (res.length() == n) {
//                 System.out.println("YES");
//             } else {
//                 System.out.println("NO");
//                 for (int i = 0; i < k; i++) {
//                     if (!found[i]) {
//                         while (res.length() < n) {
//                             res.append((char) ('a' + i));
//                         }
//                     }
//                 }
//                 System.out.println(res.toString());
//             }
//         }
//     }
// }


import java.util.*;

public class _2_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; ++t) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int m = scanner.nextInt();
            String s = scanner.next();
            System.out.println(solve(n, k, s));
        }
    }

    private static String solve(int n, int k, String s) {
        int round = 0;
        Set<Character> seen = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            seen.add(c);
            if (seen.size() == k) {
                sb.append(c);
                ++round;
                if (round == n) {
                    return "YES";
                }
                seen.clear();
            }
        }

        // Find the first missing character
        char missing = 'a';
        for (int i = 0; i < 26; ++i) {
            if (!seen.contains((char) ('a' + i))) {
                missing = (char) ('a' + i);
                break;
            }
        }

        // Prepare the result if the required length is not reached
        if (sb.length() < n) {
            StringBuilder result = new StringBuilder("NO\n");
            result.append(sb.toString());

            // Append the remaining characters  
            int remainingLength = n - sb.length();
            for (int i = 0; i < remainingLength; i++) {
                result.append(missing);
            }

            return result.toString();
        }

        return "YES";
    }
}

   
