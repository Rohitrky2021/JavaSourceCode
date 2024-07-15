import java.util.*;

public class BinaryTreeB{
    static class Node{
        int data ;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    
    static class BinaryTree{
        static int idx =-1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newnode = new Node(nodes[idx]);
            newnode.left = buildTree(nodes);
            newnode.right =buildTree(nodes);
            return newnode;
        }
        public static void preorder(Node root){
            if(root==null){
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
            return;
        }
        public static void Inorder(Node root){
            if(root==null){
                return;
            }
            Inorder(root.left);
            System.out.print(root.data+" ");
            Inorder(root.right);
            return;
        }
        public static void Postorder(Node root) {
            if(root==null){
                return;
            }
            Postorder(root.left);
            Postorder(root.right);
            System.out.print(root.data+" ");
        }

        public static void Levelorder(Node root){
            if(root == null){
                return;
            }
            Queue<Node> q =new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left!=null){
                        q.add(currNode.left);
                    }
                    if(currNode.right!=null){
                        q.add(currNode.right);
                    }
                    
                }
            }
        }

        public static int heightoftree(Node root){
            if(root==null){
                return 0;
            }
            int lh = heightoftree(root.left);
            int rh = heightoftree(root.right);

            if(lh >= rh){
                return lh+1;
            }else{
                return rh+1;
            }
        }

        public static int countofnode(Node root){
            if(root==null){
                return 0;
            }
            int cl = countofnode(root.left);
            int cr = countofnode(root.right);
            return cl+cr+1;
        }

        public static int sumofnode(Node root){
            if(root==null){
                return 0;
            }
            int sl = sumofnode(root.left);
            int sr = sumofnode(root.right);
            return sl+sr+root.data;
        }

        public static int diameter(Node root){
            //base
            if(root==null){
                return 0;
            }

            int lfdia = diameter(root.left);
            int lfhe = heightoftree(root.left);
            int ridia =diameter(root.right);
            int rihe =heightoftree(root.right);

            int curr= lfhe+rihe+1;
            
            return Math.max(curr,Math.max(lfdia,ridia));
        }
        static class Info{
            int dia ;
            int he ;
            public Info(int dia,int he){
                this.dia =dia;
                this.he = he;
            }
        }
        public static Info Diameterr(Node root){
            if(root==null){
                return new Info(0, 0);
            }
            Info leftInfo = Diameterr(root.left);
            Info rightInfo = Diameterr(root.right);

            int diam = Math.max(leftInfo.dia,Math.max(rightInfo.dia, leftInfo.he+rightInfo.he+1));
            int hei = Math.max(leftInfo.he,rightInfo.he)+1;
            return new Info(diam, hei);
        }

        public static boolean isIdentical(Node root , Node subroot){
            if(root==null && subroot==null){
                return true;
            }else if(root==null || subroot==null || root.data!=subroot.data){
                return false;
            }
            if(!isIdentical(root.left, subroot.left)){
                return false;
            }
            if(!isIdentical(root.right, subroot.right)){
                return false;
            }

            return true;
        }

        public static boolean isSubtree(Node root ,Node subroot){
            if(root==null){
               return false;
            }

            if(root.data == subroot.data){
                if(isIdentical(root,subroot)){
                    return true;
                }
            }
            return (isSubtree(root.left, subroot)||isSubtree(root.right, subroot));
        }

        static class infor{
            Node node;
            int hd;
            infor(Node node,int hd){
                this.node = node;
                this.hd=hd;
            }
        }
        
        public static void topview(Node root){
            Queue<infor> q =new LinkedList<>();
            HashMap<Integer,Node> map =new HashMap<>();

            int min=0,max=0;
            q.add(new infor(root, 0));
            q.add(null);

            while(!q.isEmpty()){
                infor curr = q.remove();
                if(curr==null){
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{

                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd,curr.node);
                }

                if(curr.node.left !=null){
                    q.add(new infor(curr.node.left, curr.hd-1));
                    min = Math.min(curr.hd-1, min);
                }

                if(curr.node.right !=null){
                    q.add(new infor(curr.node.right, curr.hd+1));
                    max =Math.max(curr.hd+1, max);
                }
            }
            }
            for( int i = min ; i <= max ;i++){
                System.out.print(map.get(i).data+" ");
            }

        }

        public static void KTHLEVEL(Node root , int lev,int k){
            if(root==null){
                return;
            }

            if( lev==k ){
                System.out.print(root.data+" ");
                return;
            }
            
            KTHLEVEL(root.left,lev+1,k);
            KTHLEVEL(root.right,lev+1,k);
            
        }

        public static boolean getpath(Node root , int n , ArrayList<Node> path){
            if(root==null){
                return false;
            }

            path.add(root);

            boolean foundleft = getpath(root.left, n, path);
            boolean foundright = getpath(root.right, n, path);


            if(foundleft || foundright){
                return true;
            }

            path.remove(path.size()-1);
            return false;
        }

        public static Node lcs(Node root, int n1 , int n2 ){
            ArrayList<Node> path1 = new ArrayList<>();
            ArrayList<Node> path2  = new ArrayList<>();
            
            getpath(root, n1 , path1);
            getpath( root,n2,path2 );

            // last common 

            int i = 0 ; 
            for( ; i < path1.size() && i < path2.size() ;i++){
                if(path1.get(i) != path2.get(i)){
                    break;
                }
            }

            Node lca  = path1.get(i-1);

            return lca;

        }


        public static Node lca2(Node root, int n1 , int n2){
           
            if(root == null ){
                return null;
            }

            if(root.data == n1 || root.data == n2 ){
                return root;
            }

            Node leftlca2 = lca2(root.left, n1, n2);
            Node rightlca2 = lca2(root.right, n1, n2);


            // left is valid and right is null

            if(rightlca2 == null){
                return leftlca2;
            }
            // right is valid and left is null
            if(leftlca2 == null){
                return rightlca2;
            }
            // right and left is valid
            return root;
        }

        public static int lcadis(Node root , int n ){
            if(root == null ){
                return -1;
            }

            if(root.data == n ){
                return 0 ;
            }
            int leftdis = lcadis(root.left, n);
            int rightdis = lcadis(root.right, n);

            if(leftdis == -1 && rightdis == -1 ){
                return -1;
            }else if(leftdis == -1){
                return rightdis+1;
            }else{
                return leftdis+1;
            }
        }

        public static int minDis( Node root , int n1 , int n2 ){
            Node lca = lca2(root, n1, n2);
            return lcadis(lca , n1)+lcadis(lca , n2);
        }

        public static int kan(Node root, int n , int k){
            if(root == null){
                return -1;
            }

            if(root.data == n) {
                 return 0; 
            }
             int  leftdis = kan(root.left, n, k);
             int rightdis = kan(root.right, n, k);


             if(leftdis == -1 && rightdis == -1){
                return -1;
             }

             int max = Math.max(leftdis, rightdis);

             if(max+1 == k ){
                System.out.println(root.data);
             }
             return max+1;
        }


        public static int transform(Node root){
            if(root == null){
                return 0;
            }

           int leftch = transform(root.left);
           int rightch = transform(root.right);
           int data = root.data;

           int newleft = root.left == null ? 0 : root.left.data ;
           int newright = root.right == null ? 0 : root.right.data ; 

           root.data = newleft + newright + leftch + rightch;
           return data;
        }

    }

    public static void main(String[] args) {


        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1}; 
        int subt[] = {3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        BinaryTree subtree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        BinaryTree.idx =-1;
        Node subroot = tree.buildTree(subt);

      //  tree.Levelorder(root);
       //  System.out.println(tree.heightoftree(root));
        // System.out.println(tree.countofnode(root));
         //System.out.println(tree.sumofnode(root));
         //System.out.println(tree.diameter(root));
        // System.out.println(tree.Diameterr(root).dia);
        // System.out.println(tree.isSubtree(root, subroot));
        // tree.topview(root);
       // tree.KTHLEVEL(root, 1, 3);
            
           // System.out.println(tree.lca2(root, 4, 6).data);

      //  System.out.println(tree.minDis(root, 4, 6));
      // tree.kan(root, 5, 2);

      System.out.println(tree.transform(root));
      tree.preorder(root);
    }
}