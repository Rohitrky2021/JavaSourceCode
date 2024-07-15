public class MaxSum {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k =2 ;
        System.out.println(maxSum(nums, k)*1.5f);
        Double.parseDouble(s).
    }

    static int maxSum(int arr[],int k){
        int tail=0,ans=0,sum=0,targetsum=k,head/*makeing it global */;
        for (head = 0; head < arr.length; head++) {
            sum=sum+arr[head];
            while(sum>targetsum ){
                sum=sum-arr[tail];
                tail++;
            }
            System.out.println(sum);
            ans=Math.max(ans, head-tail);
            // System.out.println("Ans-->"+ans);
            
        }

            
        return ans;
    }

}
