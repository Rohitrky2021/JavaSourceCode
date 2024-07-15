
import java.util.*;

// https://codeforces.com/problemset/problem/1978/A

// public class S_E1_A_reader {
public class Main {
  
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                
                int t = scanner.nextInt();
                Solution solution = new Solution();
                
                while (t-- > 0) {
                    int n = scanner.nextInt();
                    List<Long> lst = new ArrayList<>();
                    
                    for (int i = 0; i < n - 1; i++) {
                        lst.add(scanner.nextLong());
                    }
                    
                    long x = scanner.nextLong();
                    long result = solution.calculateResult(n, lst, x);
                    System.out.println(result);
                }
                
                scanner.close();
            }
        }
        
        class Solution {
            public long calculateResult(int n, List<Long> lst, long x) {
                Collections.sort(lst);
                x += lst.get(lst.size() - 1);
                return x;
            }
        }
    