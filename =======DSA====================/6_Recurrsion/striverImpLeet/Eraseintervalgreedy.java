
import java.util.*;
public class subetsum1 {
    public static void main(String[] args) {
        
    }
}
class Solution {
    public int eraseOverlapIntervals(int[][] inter) {
        int n=inter.length;
        int m=inter[0].length;
        int count=0,diff=0;
        // int c=Integer.MAX_VALUE;
        // Collections.sort(inter);
         Deque<Integer> stack = new ArrayDeque<>();
         stack.toArray();
         
        Arrays.sort(inter,Comparator.comparing(o->o[1]));

        Arrays.sort(inter,Comparator.comparing(o->o[0]));

        for(int i=0;i<inter.length-1;i++){
           
            if(inter[i][0]==inter[i+1][0] )   
            {   

                count++;
                continue;
            }
            int end=inter[i][0];
            if(inter[i][0]!=inter[i+1][0] && end>inter[i][0] ){
                count++;
                end=Math.min(inter[0][i], end);
            }
        }
        return count;
    }
    
}