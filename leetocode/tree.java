public class tree {
    
}
class Solution {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inorderTraversal(root, values);
        Collections.sort(values);
        
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < values.size(); i++) {
            int diff = values.get(i) - values.get(i-1);
            minDiff = Math.min(minDiff, diff);
        }
        
        return minDiff;
    }
    
    private void inorderTraversal(TreeNode root, List<Integer> values) {
        if (root == null) {
            return;
        }
        
        inorderTraversal(root.left, values);
        values.add(root.val);
        inorderTraversal(root.right, values);
    }
}

{{Q2}}

class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> values = new ArrayList<>();
        inorderTraversal(root1, values);

        List<Integer> values2 = new ArrayList<>();
        inorderTraversal(root2, values2);
        // Collections.sort(values2);
        values.addAll(values2);
        Collections.sort(values);

    return values;

    }
    private void inorderTraversal(TreeNode root, List<Integer> values) {
        if (root == null) {
            return;
        }
        
        inorderTraversal(root.left, values);
        values.add(root.val);
        inorderTraversal(root.right, values);
    }
}

public static void levelOrder(Node root){
    if(root==null){return;}
    Queue<Node> q=new LinkedList<>();
    q.add(root);
    q.add(null);
    while(!q.isEmpty()){
    Node currnode=q.remove();
    if(currnode==null){
        System.out.println();
        if(q.isEmpty()){
            break;
        }
        else{
            q.add(null);

        }
        while(q.peek()!=null){
            arr.add(q.peek().data);
        }
        Collections.reverse(arr);
}
    else{
        System.out.print(currnode.data+" ");
        if(currnode.left!=null) {q.add(currnode.left);}
        if(currnode.right!=null){ q.add(currnode.right);}
    }

    }

}





List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
int sum = list.stream().filter(n -> n % 2 == 0).mapToInt(n -> n).sum(); // Calculates the sum of even numbers in the list
