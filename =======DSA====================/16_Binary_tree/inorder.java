import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.naming.spi.DirStateFactory.Result;

// tree.inorder(root);

//    tree.preorder(root);
// tree.preorder(root);
// inorderTraversal
// levelOrder  <<<<<====
//   tree.height(root);
// (tree.count(root));
// (tree.sum(root));
// (tree.diameter(root));
// (tree.diam2(root).diam);

public abstract class inorder {
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

    static class binaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;// creating the null node***********************************************
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public static void preorder(Node root) {
            if (root == null) {
                return;
            }
            System.out.println(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        public static void inorder(Node root) {

            if (root == null) {
                return;
            }
            inorder(root.left);
            System.out.println(root.data + " ");
            inorder(root.right);

        }

        // public static void levelOrder(Node root) {
        // if (root == null) {
        // return;
        // }
        // Queue<Node> q = new LinkedList<>();
        // ArrayList<Integer> arr = new ArrayList<>();
        // q.add(root);
        // q.add(null);
        // while (!q.isEmpty()) {
        // Node currnode = q.poll();

        // if (currnode == null) {
        // System.out.println();
        // if (q.isEmpty()) {
        // break;
        // } else {
        // q.add(null);

        // }

        // } else {
        // System.out.print(currnode.data + " ");
        // if (currnode.left != null) {
        // q.add(currnode.left);
        // // System.out.print("L ");
        // }
        // if (currnode.right != null) {
        // q.add(currnode.right);
        // // System.out.print("R ");
        // }
        // }

        // }

        // }

        public static List<List<Integer>>  levelOrder(Node root) {
            Queue<Node> q = new LinkedList<>();
            ArrayList<List<Integer>> ans = new ArrayList<>();
            if (root == null) {
                return new ArrayList<>();
            }

            q.offer(root);
           
            while (!q.isEmpty()) {

                int levelSize=q.size();

                List<Integer> currentlevel=new ArrayList<>();

                for (int i = 0; i < levelSize; i++) {
                    Node curr=q.poll();
                    currentlevel.add(curr);
                    
                    if(curr.left!=null){
                       q.offer(curr.left);
                     }

                    if(curr.right!=null){
                        q.offer(curr.right);
                    }
                }

                ans.add(currentlevel);
            }
            return ans;
        }

        public static int height(Node root) {
            if (root == null) {
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);

            int maxh = Math.max(lh, rh) + 1;
            // System.out.println(maxh);
            return maxh;
        }

        public static int count(Node root) {
            if (root == null) {
                return 0;
            }
            int lc = count(root.left);
            int rc = count(root.right);
            return (lc * 1) + (rc * 1) + 1;
            // return 1;
        }

        public static int sum(Node root) {
            if (root == null) {
                return 0;
            }
            int ls = sum(root.left);
            int rs = sum(root.right);
            return ls + rs + root.data;
        }

        public static int diameter(Node root) {// return whenever recursion used
            if (root == null) {
                return 0;
            }
            int leftdiam = diameter(root.left);
            int lh = height(root.left);
            int rigthdiam = diameter(root.right);
            int rh = height(root.right);

            int selfdiam = lh + rh+1;

            return Math.max(leftdiam, Math.max(rigthdiam, selfdiam));

        }

        public static class Info {
            int diam;
            int ht;

            public Info(int diam, int ht) {
                this.diam = diam;
                this.ht = ht;
            }

        }

        public static Info diam2(Node root) {
            if (root == null) {
                return new Info(0, 0);
            }
            Info lInfo = diam2(root.left);
            Info rInfo = diam2(root.right);
            int diam = Math.max(Math.max(lInfo.diam, rInfo.diam), lInfo.ht + rInfo.ht);
            int ht = Math.max(lInfo.ht, rInfo.ht) + 1;

            return new Info(diam, ht);

        }

    }

    public static void main(String args[]) {
        int nodes[] = { 3, 9, 20, null, null, 15, 7 };
        binaryTree tree = new binaryTree();
        Node root = tree.buildTree(nodes);
        System.out.print(root.data);
        // tree.inorder(root);

        // tree.preorder(root);
        // tree.preorder(root);
        tree.levelOrder(root);
        // tree.height(root);
        // System.out.println(tree.height(root));
        // System.out.println(tree.count(root));
        // System.out.println(tree.sum(root));
        // System.out.println(tree.diameter(root));
        // System.out.println(tree.diam2(root).diam);

        // preo
        ArrayList<Integer> arr = new ArrayList<>();
        // arr.add()
        // arr.sort("0");
        // Collections.sort(arr);
        // System.out.println(arr);
    }

}
