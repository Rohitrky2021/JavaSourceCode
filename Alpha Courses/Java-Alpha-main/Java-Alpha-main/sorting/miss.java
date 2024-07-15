
public class miss {
    public static int missnumber(int[] nums){
        int sum = 0;
        for(int i = 0 ; i < nums.length ; i++){
            sum += nums[i];
        }
       

        int all = nums.length*(1 + nums.length)/2;

        return all-sum;
    }
    public static void main(String[] args) {
        int nums[] = {9,6,4,2,3,5,7,0,1};
        System.out.print(missnumber(nums));
    }
}
