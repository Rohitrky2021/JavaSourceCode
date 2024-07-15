
package T14_Binary_Search_Tree;


public class BST06_vailidBST {
    static class Node {
        int data;
        Node left;
        Node right;
    
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    Node root;

    BST06_vailidBST() {
        root = null;
    }

    Node insertbts(Node root, int valu) {
        if (root == null) {
            root = new Node(valu);
            return root;
        }

        if (root.data > valu) {
            root.left = insertbts(root.left, valu);
        } else {
            root.right = insertbts(root.right, valu);
        }

        return root;
    }

    boolean isVailid(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.data <= min.data) {
            return false;
        }
        if (max != null && root.data >= max.data) {
            return false;
        }

        return isVailid(root.left, min, root) && isVailid(root.right, root, max);
    }

    public static void main(String[] args) {
        int values[] = { 5, 1, 3, 4, 2, 7 };
        Node root = null;

        BST06_vailidBST tree = new BST06_vailidBST();

        for (int i = 0; i < values.length; i++) {
            root = tree.insertbts(root, values[i]);
        }

        
        if(tree.isVailid(root, null, null)){
            System.out.println("Vailid bst");
        }else{
            System.out.println("Invalide bst");
        }

    }
}
