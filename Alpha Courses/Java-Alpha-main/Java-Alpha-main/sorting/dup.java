public class dup {
    public static boolean check(int[] nums,int k){
        for(int i =0 ; i <nums.length-1; i++){
            for(int j=i+1 ; j<=k*(1+i); j++){
                if((nums[i]==nums[j]) &&(j-i <= k)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int nums[] = {1,2,3,1,2,3};
        int k=2;
        System.out.println(check(nums,k));
     }
}
