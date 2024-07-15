import java.util.*;

public class Main {
    // https://leetcode.com/problems/subarray-sums-divisible-by-k/description/
    public static int solution(int[] arr, int k) {
        // write your code here
        int a = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int rem = 0;
        
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            rem = sum % k;
            if(rem < 0){
                rem = rem + k;
            }
            
            if(map.containsKey(rem)){
                a = a + map.get(rem);
                map.put(rem, map.get(rem) + 1);
            } else {
                map.put(rem, 1);
            }
        }

        return a;
    }

    class Solutionnn {
        public int subarraysDivByK(int[] A, int K) {
            int[] map = new int[K];
            map[0] = 1;
            int count = 0, sum = 0;
            for(int a : A) {
                sum = (sum + a) % K;
                if(sum < 0) sum += K;  // Because -1 % 5 = -1, but we need the positive mod 4
                count += map[sum];
                map[sum]++;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        while (t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            long sum = 0;
            long[] pre = new long[n];
            Arrays.fill(pre, 0);
            
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                sum += a[i];
                sum %= n;
                sum = (sum + n) % n;
                pre[(int)sum]++;
            }
            
            long ans = (pre[0] * (pre[0] + 1)) / 2;
            
            for (int i = 1; i < n; i++) {
                ans += (pre[i] * (pre[i] - 1)) / 2;
            }
            
            System.out.println(ans);
        }
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.out.println(solution(arr, k));
    }

}