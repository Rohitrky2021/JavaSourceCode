import java.util.Scanner;
import java.util.HashSet;

public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();
        
        for (int testCase = 0; testCase < t; testCase++) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            
            int goodPrefixCount = 0;
            long prefixSum = a[0];
            HashSet<Long> prefixSums = new HashSet<>();
            int max=a[0];

            if(a[0]==0)goodPrefixCount++;
            
            for (int i = 1; i < n; i++) {
                prefixSum += a[i];
                max=Math.max(max,a[i]);


                
                // If prefixSum is zero, it's a good prefix because all elements sum to zero
                if (prefixSum-max == max) {
                    goodPrefixCount++;
                }
                
                // // Check if there exists a prefix sum such that prefixSum - 2 * a[i] is in prefixSums
                // if (prefixSums.contains(prefixSum - 2 * a[i])) {
                //     goodPrefixCount++;
                // }
                
                // // Add the current prefix sum to the set
                // prefixSums.add(prefixSum);
            }
            
            System.out.println(goodPrefixCount);
        }
        
        scanner.close();
    }
}
