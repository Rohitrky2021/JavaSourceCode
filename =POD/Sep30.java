import java.util.ArrayDeque;
import java.util.Deque;

public class Sep30 {
    public boolean find132pattern(int[] nums) {
        ArrayDeque<Integer> hs =new ArrayDeque<>();
        for (
             i = 0; i < 3; i++) {
            hs.add(nums[i]);        
        }
        while(i<nums.length && hs.size()>=3){
            
                int start=hs.pollFirst();
                System.out.println(start);
                int mid=hs.peek();
                System.out.println(mid);
                int last=hs.peekLast();

                if(start< last && mid>last){
                    return true;
                }
                hs.addLast(nums[i++]);
 
        }


        return false;
        
    }
}
