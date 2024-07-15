import java.util.Arrays;

public class Oct10{
  public static void main(String[] args) {
    
  }

  public int minOperations(int[] nums) {
    Arrays.sort(nums);
    int max= nums.length ,count=0;
    

    for (int i = 0; i < nums.length; i++) {
        if(nums[i]>max)count++;
    }

}
}