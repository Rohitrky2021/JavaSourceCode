// https://codeforces.com/problemset/problem/546/A


// public class A_E2_banana {
    
// }


import java.util.Scanner;

public class A_E2_banana {
 
    // public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
    
            int k = scanner.nextInt();
            int n = scanner.nextInt();
            int w = scanner.nextInt();
    
            Solution solution = new Solution();
            int amountToBorrow = solution.calculateAmountToBorrow(k, n, w);
            
            System.out.println(amountToBorrow);
            
            scanner.close();
        }
    }
    
    class Solution {
        public int calculateAmountToBorrow(int k, int n, int w) {
            int[] costArray = new int[w];
            int totalCost = 0;
    
            for (int i = 0; i < w; i++) {
                costArray[i] = (i + 1) * k;
                totalCost += costArray[i];
            }
    
            int amountToBorrow = totalCost - n;
    
            if (amountToBorrow < 0) {
                amountToBorrow = 0;
            }
    
            return amountToBorrow;
        }
    }
    