import java.util.*;
// this is the same question like Q5 just a small change that houses are arrange in circular and
// we want non adjacent element so last element nabour is first element
// so either we can pick the first element or the last element
// so we can create two arrays arr1 will store all element except first one
// arr2 will store all elements except last one
// now call the functin for both array and the max result will be our ans
public class Q6_House_Robber_II {
    public static int rob(int[] nums){
        int prev1 = nums[0];
        int prev2 = 0;
        for(int i = 1; i < nums.length; i++){
            int take = nums[i];
            if(i > 1) take += prev2;
            int notake = 0 + prev1;
            int curr = Math.max(take, notake);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // size of array
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) arr[i] = scn.nextInt();
        scn.close();

        // if (n == 1) return 0; if their is only one element then that will be our ans only 
        int[] arr1 = new int[n - 1];
        int[] arr2 = new int[n - 1];

        for(int i = 0; i < n; i++){
            // we used i-1 bcoz arrays 1st index element will be the 0th element of arr1
            // and we put the conditons also so it'll not give any exception
            if(i != 0) arr1[i-1] = arr[i];
            if(i != n - 1) arr2[i] = arr[i];
        }

        System.out.println(Math.max(rob(arr1), rob(arr2)));
    }
}
