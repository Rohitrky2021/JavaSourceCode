import java.util.*;
public class bst{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }
    public static Node insert(Node root, int val) {
        if( root == null){
            root = new Node(val);
            return root;
        }

        if(root.data > val) {
            // left subtree
           root.left =  insert(root.left, val); 
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static boolean search(Node root , int key){
        if(root == null){
            return false;
        }

        if(root.data == key){
            return true;
        }

        if(root.data > key){
            return search(root.left, key);
        }else{
            return search(root.right, key);
        }
        
    }

    public static Node delete(Node root, int val){
        if(root.data < val){
            root.right = delete(root.right , val);
        }else if(root.data > val){
            root.left = delete(root.left, val);
        }      
        else{
            //case 1 - no chlid 
            if(root.left == null && root.right == null){
                return null;
            }
            // case 2 - 1 child
            if(root.left==null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }
            //case 3 - 2 child 
            Node is = inordersucceor(root.right);
            root.data =  is.data;
            root.right = delete(root.right, is.data);
        }
        return root;
    }
    public static Node inordersucceor(Node root){
         while(root.left != null ){
            root =root.left; 
         }
         return root;
    }

    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);

    }

    public static void printinrange(Node root,int k1,int k2){
        if(root == null){
            return;
        }
       
        if(root.data >= k1 && root.data <= k2){
            printinrange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printinrange(root.right, k1, k2);
        }else if(root.data < k1){
            printinrange(root.left, k1, k2);
        }else{
            printinrange(root.left, k1, k2);
        }
    }

    public static void root2leaf(Node root , ArrayList<Integer> path){
        if(root == null ){
            return; 
        }
        
        path.add(root.data);
        if(root.left==null && root.right == null){
            printPath(path);
        }
        root2leaf(root.left, path);
        root2leaf(root.right, path);
        path.remove(path.size()-1);
        return;
    }

    public static boolean Isvalid( Node root, Node min , Node max ){
        if(root==null){
            return true;
        }
        if(min!=null && root.data <= min.data){ // right side
            return false;
        }else if( max!=null && root.data >= max.data){ // left side
            return false;
        } 
        return Isvalid(root.left, min, root) && Isvalid(root.right, root, max);  
    }

    public static void printPath(ArrayList<Integer> path){
        for(int i =0 ; i < path.size(); i++){
            System.out.print(path.get(i)+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int val[] = {8,5,3,6,10,11,14};
        Node root = null;

        for(int i=0 ; i < val.length ; i++){
            root = insert(root,val[i]);
        }

        inorder(root);
        System.out.println();

        if(Isvalid(root, null, null)){
            System.out.println(" tree is valid");
        }else{
            System.out.println("tree is not valid");
        }


        // if(search(root, 8)){
        //     System.out.println("present");
        // }else{
        //     System.out.println("not present");
        // }
         // delete(root, 5);
       //  System.out.println();
       // inorder(root);
      // printinrange(root, 5, 12);

      delete(root, 1);
      delete(root, 4);

        root2leaf(root, new ArrayList<>() );

    }
}