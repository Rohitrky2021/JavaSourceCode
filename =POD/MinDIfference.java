import java.util.ArrayList;
import java.util.List;

public class MinDIfference {
    
}

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {

       ArrayList<Integer> a=new ArrayList<>();

       ArrayList<ArrayList<Integer>> ans=new ArrayList<>();

       int min =Integer.MAX_VALUE;



       for (int i = 1; i < arr.length; i++) {
        min=Math.min(Math.abs(arr[i-1]-arr[i] )  , min);
       }

       for (int i = 1; i < arr.length; i++) {
        if(Math.abs(arr[i-1]-arr[i] ) == min){
            a.add(Math.min(arr[i-1],arr[i-1]) );
              a.add(Math.max(arr[i-1],arr[i-1]));

        }
        ans.add(a);
        a.clear();
       }


        
    }
}