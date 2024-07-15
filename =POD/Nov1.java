import java.util.*;
public class Nov1{
 
    public int[] solve(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        //    ArrayList<List<Integer>> ans = new ArrayList<>();
           if (root == null) {
               return ans;
           }

           q.offer(root);

           List<Integer> ans=new ArrayList<>();
          
           while (!q.isEmpty()) {

               int levelSize=q.size();


               for (int i = 0; i < levelSize; i++) {
                   TreeNode curr=q.poll();
                   ans.add(curr.val);
                   

                   if(curr.left!=null){
                       q.offer(curr.left); // Adding the left part of Node 
                   }
                   if(curr.right!=null){  // Adding the Right part of Node 
                       q.offer(curr.right);
                   }

               }
               


               
            //    Collections.reverse(currentlevel);
            //    ans.add(currentlevel);
           }
           return new int[]{largestVariance(ans)} ;
    }
 

   public int largestVariance(int[] ans) {
    TreeMap<Integer, Integer> hs = new TreeMap<>();
    for (int i : ans) {
        hs.put(i, hs.getOrDefault(i, 0) + 1);
    }

    TreeMap<Integer, Integer> sortedByValue = new TreeMap<>(new ValueComparator(hs));
    sortedByValue.putAll(hs);

   
    return  hs.lastKey();
}

static class ValueComparator implements Comparator<Integer> {
    Map<Integer, Integer> map;

    public ValueComparator(Map<Integer, Integer> map) {
        this.map = map;
    }

    @Override
    public int compare(Integer key1, Integer key2) {
        Integer value1 = map.get(key1);
        Integer value2 = map.get(key2);
        return value1.compareTo(value2);
    }
}

}