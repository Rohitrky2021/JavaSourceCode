public class Template {

    static int SlidingWin(int arr[],int k){
        int tail=0,ans=0,sum=0,targetsum=k,head/*makeing it global */;
        for (head = 0; head < arr.length; head++) {
            sum=sum+arr[head];
            while(sum>targetsum){
                sum=sum-arr[tail];
                tail++;
            }
            ans=Math.max(ans, head-tail+1);
            
        }

        // return head-tail+1;
        return ans;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k =2 ;
        System.out.println(SlidingWin(nums, k));
    }
}

//  M2 Same usng array deque;
 

public class Template {

    static int SlidingWin(int arr[], int k) {
        int ans = 0, sum = 0, targetSum = k;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int head = 0; head < arr.length; head++) {
            sum += arr[head];

            // Remove elements from the front of the deque until the sum is less than or equal to the target sum.
            while (sum > targetSum) {
                sum -= deque.pollFirst();
            }

            // Add the current element to the deque.
            deque.offerLast(arr[head]);

            // Update the maximum length of the subarray using the size of the deque.
            ans = Math.max(ans, deque.size());
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 2;
        System.out.println(SlidingWin(nums, k));
    }
}
