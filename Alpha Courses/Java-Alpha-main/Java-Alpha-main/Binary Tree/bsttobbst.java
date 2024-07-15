import java.util.ArrayList;
public class bsttobbst {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node( int data){
            this.data = data;
            this.left =  this.right = null;
        }
    }
    public static  void preorder (Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data +" s");
        preorder(root.left);
        preorder(root.right);
    }
    public static void getinorder(Node root, ArrayList<Integer> inorder){
        if(root == null){
            return;
        }
        getinorder(root.left, inorder);
        inorder.add(root.data);
        getinorder(root.right, inorder);
    }
    public static Node convert(ArrayList<Integer> inorder , int si , int en ){
        if(si > en ){
            return null;
        }
        int mid = (si+en)/2;
        Node root = new Node(inorder.get(mid));
        root.left = convert(inorder, si , mid-1);
        root.right = convert(inorder, mid+1 ,en);
        return root;
    }
    public static Node createbbst(Node root){
        // inorder get
        ArrayList<Integer> inorder = new ArrayList<>();
        getinorder(root, inorder);
        // covert
        return convert(inorder, 0, inorder.size()-1);
    }
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left =new Node(5);
        root.left.left.left = new Node(3);
        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);
        root = createbbst(root);
        preorder(root);
    }
}
