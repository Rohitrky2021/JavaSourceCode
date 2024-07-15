import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class D2Dmatrix {
    public static void main(String[] args) {
        
    }
    
}
class Solution {
    public ArrayList<ArrayList<Integer>> findWinners(int[][] m) {
        ArrayList<Integer> a=new ArrayList<>();

        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();

        // hash <Integer> s=new HashSet<>();
        TreeMap<Integer,Integer> s=new TreeMap<>();

        for(int[] x:m){
            s.add(x[1] , frequency of x[i]);
        }

        for (int i = 0; i < m.length; i++) {
            if(s.contains(m[i][0])) continue;
            a.add(m[i][0]);
        }

        ans.add(a);
        a.clear();

            for(Integer k:s.keySet()){
                if(s.get(k)==1)a.add(k);

            }

            ans.add(a);

        








        

        return ans;
    }
}