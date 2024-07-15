// in the ques given an array which can be divided into 2 subsets whose sum are s1 and s2
// we have given a diff D also, s1 is greater or equal to s2 we have to find the count of subsets
// fo which s1 - s2 = D
// for s1 and s2 find total sum so we have two equations s1 + s2 = totalsum, s1 - s2 = D
// s1 + s2 = totalsum
// s1 = totalsum - s2 so put this in 2nd equation we got totalsum - s2 - s2 = D
// totalsum - 2s2 = D
// 2s2 = totalsum - D
// s2 = (totalsum - D)/2
// we have totalsum as well as D so we can simply pass this and count the subset
// totalsum - D has to be positive bcoz all no are positive and even also then only we got ans otherwise
// it'll be in decimal 

public class Q18_Count_partitions_with_given_difference {

    public static int countSubsetsWithSumK(int k, int[] arr){

        int n = arr.length;
        int[] prev = new int[k+1];

        if(arr[0] == 0) prev[0] = 2;
        else prev[0] = 1;

        if(arr[0] != 0 && arr[0] <= k) prev[arr[0]] = 1;

        for(int idx = 1; idx < n; idx++){

            int[] curr = new int[k+1];

            for(int sum = 0; sum <= k; sum++){

                int nottake = prev[sum];

                int take = 0;
                if(arr[idx] <= sum) take = prev[sum - arr[idx]];

                curr[sum] = take + nottake;

            }

            prev = curr;

        }

        return prev[k];

    }

    public static void main(String[] args) {

        int arr[] = { 5, 2, 6, 4 };
        int d = 3;
        
        int totalsum = 0;
        for(int val : arr) totalsum += val;

        if(totalsum - d < 0 || (totalsum - d) % 2 == 1) System.out.println(0);

        int s2 = (totalsum - d) / 2;
        System.out.println(countSubsetsWithSumK(s2, arr));

    }
}
