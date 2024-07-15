 
import java.util.Arrays;
import java.util.Scanner;
 
// https://codeforces.com/problemset/problem/1891/C   
   
public class S_H1_Rocky {
        public static void main(String[] args) {
            Scanner inputScanner = new Scanner(System.in);
            int numTestCases = inputScanner.nextInt();
            Solution solution = new Solution();
    
            while (numTestCases-- > 0) {
                int numHordes = inputScanner.nextInt();
                long[] monsterCounts = new long[numHordes];
    
                for (int i = 0; i < numHordes; i++) {
                    monsterCounts[i] = inputScanner.nextLong();
                }
    
                long minResult = solution.calculateMinimum(numHordes, monsterCounts);
                System.out.println(minResult);
            }
    
            inputScanner.close();
        }
    }
    
    class Solution {
        public long calculateMinimum(int numHordes, long[] monsterCounts) {
            Arrays.sort(monsterCounts);
    
            for (int j = 0; j < numHordes / 2; j++) {
                long temp = monsterCounts[j];
                monsterCounts[j] = monsterCounts[numHordes - 1 - j];
                monsterCounts[numHordes - 1 - j] = temp;
            }
    
            long totalSum = 0;
            for (long count : monsterCounts) {
                totalSum += count;
            }
    
            long sumSoFar = 0;
            long minResult = totalSum;
    
            for (int k = 0; k < numHordes; k++) {
                sumSoFar += monsterCounts[k];
                totalSum -= monsterCounts[k];
    
                long difference = 0;
                if (sumSoFar > totalSum) {
                    difference = sumSoFar - totalSum;
                    difference = (difference + 1) / 2;
                }
    
                minResult = Math.min(minResult, k + 1 + totalSum + difference);
            }
    
            return minResult;
        }
    }
    