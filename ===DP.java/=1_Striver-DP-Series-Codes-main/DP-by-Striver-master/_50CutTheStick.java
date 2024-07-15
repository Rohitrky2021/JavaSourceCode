//arr = [1, 3, 4, 5]
//0 1 | 1 2 3 4 5 6 7 = 7
//        0 1 | 1 2 3 | 3 4 5 6 7 = 6
//        0 1 | 1 2 3 | 3 4 | 4 5 6 7 = 4
//        0 1 | 1 2 3 | 3 4 | 4 5 | 5 6 7 = 3
//        total = 20;
// this one is not the optimal solution

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _50CutTheStick {
    public static void main(String[] args) {
        int[] cuts = {1,4,3,5};
        int n = 7;
        Arrays.sort(cuts);
        System.out.println("rec : "+ solve(cuts, 0, n, 0, cuts.length-1));
        System.out.println("memo : "+ memo(cuts, 0, n, new HashMap<>() ));
        System.out.println("second approach : "+ second(cuts, n));
    }

    // i, j are the boundaries for length of stick and c1, c2 are the boundaries for cut's array to get random access.
    public static int solve(int[]arr, int i, int j,int c1, int c2){
        if(i+1 == j) return 0;
        if(c1 > c2 ) return 0;
        int mini = Integer.MAX_VALUE;
        for(int k = c1; k<=c2; k++){
            int temp = j-i  + solve(arr, i, arr[k], c1, k-1 ) + solve(arr, arr[k], j, k+1, c2);
            mini = Math.min(mini, temp);
        }
        return mini;
    }

    // memoization is costly on this recursive solution
    // rather than using c1,c2 for in range indexes, we can use continue keyword whenever cut[i] is index out of bound

    public static int memo(int[] cuts, int i, int j, Map<String, Integer> dp){
        int res = Integer.MAX_VALUE;

        String key = i + "-" + j;
        if (dp.containsKey(key)) return dp.get(key);
        for (int c = 0; c < cuts.length; ++c) {
            if (cuts[c] <= i || cuts[c] >= j) continue;

            int cost = j - i;
            res = Math.min(
                    // min cost of left stick + cost + min cost of right stick
                    memo(cuts, i, cuts[c], dp) + cost + memo(cuts, cuts[c], j, dp), res);
        }
        res = res == Integer.MAX_VALUE ? 0 : res;
        dp.put(key, res);
        return res;
    }


    // one more solution is that :
//    suppose : arr = [3,5,6,7], n = 10
//    treat it as 0 3 5 6 7 10
//    because array is sorted, if we have to find length of stick, just do arr[j+1] - arr[i-1] where i and j initially
//    is 1th index and n-2th index because 0th and n-1th index is appended 0 and n values.

    static int second(int[] cuts, int n){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0,0);
        for(int i=1; i<=cuts.length; i++){
            list.add(i, cuts[i-1]);
        }
        list.add(list.size(),n);

        return f(list, 1, cuts.length);
    }
    static int f(ArrayList<Integer> list, int i, int j){
        if(i>j) return 0;

        int mini = Integer.MAX_VALUE;
        for(int c=i; c<=j; c++){
            int temp = list.get(j+1) - list.get(i-1) + f(list,i,c-1) + f(list, c+1, j);
            mini = Math.min(mini, temp);
        }
        return mini;
    }
}


