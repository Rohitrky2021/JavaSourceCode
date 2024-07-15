public class arrtobbst {
    static class Node{
        int data ; 
        Node left ; 
        Node right ; 

        public Node ( int data ){
            this.data = data;
            this.left = null;
            this.right =null;
        }
    }

    public static Node createbbst(int arr[], int si ,int en  ){
        if(si > en){
            return null;
        }
        int mid  = (si+en)/2;
        Node root = new Node(arr[mid]);
        root.left = createbbst(arr, si, mid-1);
        root.right = createbbst(arr, mid+1, en);
        return root;
    }

    public static void preorder(Node root){
        if(root == null){
            return ; 
        }
        System.out.print(root.data+ " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String arg[]){
        int arr[] = {3,5,6,8,10,11,12};
        Node root =createbbst(arr, 0, arr.length-1);
        preorder(root);
    }
}
