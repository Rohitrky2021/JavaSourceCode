package T13_Binary_Tree;

import java.util.*;

public class BT09_diameter {
    static class Node {
        int data;
        Node rightNode;
        Node leftNode;

        Node(int data) {
            this.data = data;
            this.leftNode = null;
            this.rightNode = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1 || idx >= nodes.length) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.leftNode = buildTree(nodes);
            newNode.rightNode = buildTree(nodes);
            return newNode;
        }

        void levelOrder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.leftNode != null) {
                        q.add(currNode.leftNode);
                    }
                    if (currNode.rightNode != null) {
                        q.add(currNode.rightNode);
                    }
                }
            }
        }

        int heightOfTree(Node root) {
            if (root == null) {
                return 0;
            }
            return 1 + Math.max(heightOfTree(root.leftNode), heightOfTree(root.rightNode));
        }

        int diameter1(Node root) {
            if (root == null) {
                return 0;
            }
            int ld = diameter1(root.leftNode);
            int lh = heightOfTree(root.leftNode);
            int rd = diameter1(root.rightNode);
            int rh = heightOfTree(root.rightNode);
            return Math.max(lh + rh + 1, Math.max(ld, rd));

        }

        // class info {
        // int diameter;
        // int height;
        // }

        // info diameter2(Node root) {
        // info ans = new info();
        // if (root == null) {
        // ans.diameter = 0;
        // ans.height = 0;
        // return ans;
        // }
        // info templ = diameter2(root.leftNode);
        // info tempr = diameter2(root.rightNode);

        // int lh = templ.height;
        // int rh = tempr.height;
        // int ld = templ.diameter;
        // int rd = tempr.diameter;
        // ans.diameter = Math.max(lh + rh + 1, Math.max(ld, rd));
        // ans.height = Math.max(lh, rh) + 1;

        // return ans;
        // }

        class info {
            int diameter;
            int height;

            info(int diameter, int height) {
                this.diameter = diameter;
                this.height = height;
            }
        }

        info diameter2(Node root) {
            if (root == null) {
                return new info(0, 0);
            }
            info rightInfo = diameter2(root.rightNode);
            info leftInfo = diameter2(root.leftNode);
            int curdimeter = Math.max(Math.max(rightInfo.diameter, leftInfo.diameter),
                    rightInfo.height + leftInfo.height + 1);
            int curheight = Math.max(rightInfo.height, leftInfo.height) + 1;
            return new info(curdimeter, curheight);
        }

    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        tree.levelOrder(root);
        System.out.println(tree.diameter2(root).diameter);
        System.out.println(tree.diameter2(root).height);

    }

}