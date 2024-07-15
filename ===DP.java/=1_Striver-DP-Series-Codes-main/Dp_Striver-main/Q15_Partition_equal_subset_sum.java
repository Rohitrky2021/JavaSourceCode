// we have given an arr of size n we have to partion array in two subset so their sum will be equal
// like arr : {2,3,3,3,4,5};
// we can partition this arr into two subsets {2,3,5} and {3,3,4} both sum are 10
// so to solve this we use same concept of subset sum equal to target
// first of all create a total sum variable and add all element of array
// if total sum is odd that means we cannot divide them into two subset so return false
// now create a new variable target as total sum / 2 and pass this target to find subset sum equal to target
// if it returns true then we can make partition of arry 
public class Q15_Partition_equal_subset_sum {

    public static boolean subsetsum(int n, int k, int[] arr){
        boolean[] prev = new boolean[k + 1];

        prev[0] = true;

        // arr[0] has to be less then or equal to k then only we can mark it true
        // suppose arr[0] is greater than target then it'll not give accurate result
        if (arr[0] <= k) 
            prev[arr[0]] = true;

        for (int idx = 1; idx < n; idx++) {
            boolean[] curr = new boolean[k + 1];
            curr[0] = true;
            for (int target = 1; target <= k; target++) {
                boolean nottake = prev[target];
                boolean take = false;
                if (arr[idx] <= target)
                    take = prev[target - arr[idx]];

                curr[target] = take || nottake;
            }
            prev = curr;
        }

        return prev[k];
    }
    public static void main(String[] args) {
        int arr[] = { 2, 3, 3, 3, 4, 5 };
        int n = arr.length;

        int totalsum = 0;
        for(int val : arr) totalsum += val;

        if(totalsum % 2 == 1) System.out.println(false);

        int target = totalsum / 2;
        System.out.println(subsetsum(n, target, arr));


    }
}
