public class preorder {
    static class Node{
        int data;
        Node left;
        Node right;


         Node(int data){
                this.data=data;
                this.left=null;
                this.right=null;

        } 

    }
    static class binaryTree{
        static int idx=-1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;//creating the null node
            }
            Node newNode=new Node(nodes[idx]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);

            return newNode;
        }

        // Recursion Type used 
        public static void preorder(Node root){
            if(root==null){
                return ;
            }
            System.out.println(root.data+" ");
            preorder(root.left);
            preorder(root.right);
            
        }
    } 
    
    public static void main (String args[]){
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        binaryTree tree=new binaryTree();
        Node root=tree.buildTree(nodes);
        // System.out.print(root.data);

    //    tree.preorder(root);
        tree.preorder(root);
      
        // preo

    }
   
}
 