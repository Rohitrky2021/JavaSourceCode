import java.util.*;
public class set {
    class Solution {
        public int[] restoreArray(int[][] ap) {
            HashSet<Integer> s=new HashSet<>();
            int[] ans=new int[ap.length];
    
    
            for(int[] x:ap){
                s.add(x[0]);
                s.add(x[1]);
            }
int i=0;
            for(int m:s){
                ans[i]=m;
                i++;

            }
    
            return  ans;
    
            
        }
    }
}
