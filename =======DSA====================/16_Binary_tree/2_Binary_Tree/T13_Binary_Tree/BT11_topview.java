package T13_Binary_Tree;

import java.util.*;


class BT11_topview {
    
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

    public BT11_topview() {
        root = null;
    }

    private void TopView(Node root) {
        class QueueObj {
            Node node;
            int hd;

            QueueObj(Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }
        Queue<QueueObj> q = new LinkedList<>();
        HashMap<Integer, Node> topViewMap = new HashMap<>();
        int min = 0;
        int max = 0;
        if (root == null) {
            return;
        } else {
            q.add(new QueueObj(root, 0));
        }

        while (!q.isEmpty()) {
            QueueObj tmpNode = q.poll();
            if (!topViewMap.containsKey(tmpNode.hd)) {
                topViewMap.put(tmpNode.hd, tmpNode.node);
            }

            if (tmpNode.node.left != null) {
                q.add(new QueueObj(tmpNode.node.left, tmpNode.hd - 1));
                min = Math.min(min, tmpNode.hd - 1);
            }
            if (tmpNode.node.right != null) {
                q.add(new QueueObj(tmpNode.node.right, tmpNode.hd + 1));
                max = Math.max(max, tmpNode.hd + 1);
            }
        }
        for(int i = min; i <= max; i++){
            System.out.print(topViewMap.get(i).data + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        /*
         * Create following Binary Tree
         *         1
         *        / \
         *       2   3
         *        \
         *         4
         *          \
         *           5
         *            \
         *             6
         *    
         */
        BT11_topview tree = new BT11_topview();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.left.right.right = new Node(5);
        tree.root.left.right.right.right = new Node(6);
        tree.TopView(tree.root);
    }
}
