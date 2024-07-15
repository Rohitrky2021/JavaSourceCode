import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        while (testCases-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            int[] prefixCount = new int[n + 1];
            int[] suffixCount = new int[n + 1];
            long[] prefixSum = new long[n];
            long[] suffixSum = new long[n];

            for (int i = 0; i < n; i++) {
                prefixCount[i + 1] = prefixCount[i] + (s.charAt(i) == '>' ? 1 : 0);
            }

            for (int i = n - 1; i >= 0; i--) {
                suffixCount[i] = suffixCount[i + 1] + (s.charAt(i) == '<' ? 1 : 0);
            }

            List<Long> temp = new ArrayList<>(Arrays.asList(0L, 0L, 0L));

            for (int i = 0; i < n; i++) {
                int size = temp.size();
                long minCount = Math.min(prefixCount[i], suffixCount[i + 1] + (s.charAt(i) == '<' ? 1 : 0));
                prefixSum[i] = minCount * i + temp.get(size - 1) - temp.get(size - (int) minCount - 1);

                if (s.charAt(i) == '>') {
                    temp.add(temp.get(temp.size() - 1) - i);
                }
            }

            temp.clear();
            temp.addAll(Arrays.asList(0L, 0L, 0L));

            for (int i = n - 1; i >= 0; i--) {
                int size = temp.size();
                long minCount = Math.min(prefixCount[i] + (s.charAt(i) == '>' ? 1 : 0), suffixCount[i + 1]);
                suffixSum[i] = temp.get(temp.size() - 1) - temp.get(size - (int) minCount - 1) - minCount * i;

                if (s.charAt(i) == '<') {
                    temp.add(temp.get(temp.size() - 1) + i);
                }
            }

            for (int i = 0; i < n; i++) {
                prefixSum[i] *= 2;
                suffixSum[i] *= 2;
            }

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '>') {
                    if (prefixCount[i] + 1 > suffixCount[i + 1]) {
                        result.append(prefixSum[i] + suffixSum[i] + n - i).append(" ");
                    } else {
                        result.append(prefixSum[i] + suffixSum[i] + i + 1).append(" ");
                    }
                } else {
                    if (prefixCount[i] < suffixCount[i + 1] + 1) {
                        result.append(prefixSum[i] + suffixSum[i] + i + 1).append(" ");
                    } else {
                        result.append(prefixSum[i] + suffixSum[i] + n - i).append(" ");
                    }
                }
            }

            System.out.println(result.toString().trim());
        }
        sc.close();
    }
}

// Best top code sokn
 

  class D2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt(); // number of test cases

        while (testCases-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            List<Integer> greaterIndices = new ArrayList<>();
            List<Integer> lessIndices = new ArrayList<>();


            
            List<Integer> prefixSumGreater = new ArrayList<>();
            List<Integer> prefixSumLess = new ArrayList<>();
            prefixSumGreater.add(0);
            prefixSumLess.add(0);

            // Fill the lessIndices and prefixSumLess lists
            for (int i = n - 1; i >= 0; i--) {
                if (s.charAt(i) == '<') {
                    lessIndices.add(i);
                    prefixSumLess.add(prefixSumLess.get(prefixSumLess.size() - 1) + i);
                }
            }

            List<Integer> results = new ArrayList<>();

            // Iterate through the string and calculate results
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '>') {
                    greaterIndices.add(i);
                    prefixSumGreater.add(prefixSumGreater.get(prefixSumGreater.size() - 1) + i);

                    if (lessIndices.size() >= greaterIndices.size()) {
                        results.add((prefixSumLess.get(prefixSumLess.size() - 1) - prefixSumLess.get(prefixSumLess.size() - greaterIndices.size() - 1)
                                - prefixSumGreater.get(prefixSumGreater.size() - 1)) * 2 + i + 1);
                    } else {
                        results.add((prefixSumLess.get(prefixSumLess.size() - 1) - prefixSumGreater.get(prefixSumGreater.size() - 2)
                                + prefixSumGreater.get(prefixSumGreater.size() - 2 - lessIndices.size())) * 2 + n - i);
                    }
                } else {
                    lessIndices.remove(lessIndices.size() - 1);
                    prefixSumLess.remove(prefixSumLess.size() - 1);

                    if (lessIndices.size() >= greaterIndices.size()) {
                        results.add((prefixSumLess.get(prefixSumLess.size() - 1) - prefixSumLess.get(prefixSumLess.size() - greaterIndices.size() - 1)
                                - prefixSumGreater.get(prefixSumGreater.size() - 1)) * 2 + i + 1);
                    } else {
                        results.add((prefixSumLess.get(prefixSumLess.size() - 1) + i - prefixSumGreater.get(prefixSumGreater.size() - 1)
                                + prefixSumGreater.get(prefixSumGreater.size() - 2 - lessIndices.size())) * 2 + n - i);
                    }
                }
            }

            // Print the results
            for (int result : results) {
                System.out.print(result + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}

// Brute force Not Accepted
class D1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            int[] answer = calculatePinballTime(n, s);
            for (int i = 0; i < n; i++) {
                System.out.print(answer[i] + " ");
            }
            System.out.println();
        }
    }

    public static int[] calculatePinballTime(int n, String s) {
        int[] answer = new int[n];
    
        for (int i = 0; i < n; i++) {
            char[] grid = s.toCharArray();
            int seconds = 0;
            int pos = i;
    
            for (; pos >= 0 && pos < n; seconds++) {  // Worst case m N jaayega mtlb N he leke chlna hai TO calculate T.C
                if (grid[pos] == '>') {
                    grid[pos] = '<';
                    pos++;
                } else {
                    grid[pos] = '>';
                    pos--;
                }
            }
    
            answer[i] = seconds;
        }
    
        return answer;
    }
    
}
