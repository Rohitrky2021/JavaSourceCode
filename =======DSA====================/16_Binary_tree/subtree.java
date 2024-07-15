import java.util.*;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// import DSA.binary_tree.subtree.Node.binaryTree;

// --------------->>>>
// buildTree
// isidentical
// issubtree
// lca2-->Lowest common ancestor 
// lcaDist
// lca
// minDist
// Topview
// ---------------->>

public class subtree {
    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
            // this.next=next;
        }

        public static class binaryTree{
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
            public static Boolean isidentical(Node root,Node subroot){
                if(root ==null && subroot ==null){
                    return true;
                }
                else if(root ==null || subroot ==null ||root.data!=subroot.data){
                    return false;
                }
                if(!isidentical(root.left, subroot.left)) return false;
                if(!isidentical(root.right, subroot.right)) return false;
                return true;
            }
            public static Boolean issubtree(Node root,Node subroot){
                if(root==null){
                    return true;
                }
                if(root.data==subroot.data){
                    if(isidentical(root, subroot)) return true;
                }

                return issubtree(root.left, subroot) || issubtree(root.right, subroot);
            }
            public static class Info{
                Node node;
                int hd;

                    public  Info(Node node,int hd){
                        this.node=node;
                        this.hd=hd;
                    }

            }

            // public static void topview(Node root){
            //     Queue<Info> q=new LinkedList<>();
            //     HashMap<Integer,Node> map=new HashMap<>();
            //     int min=0,max=0; 
            //     q.add(new Info(root, 0));
            //     q.add(null);
                
            //             }
    }    

    //to find the lca node
    public static Boolean isidentical(Node root,Node subroot){
        if(root ==null && subroot ==null){
            return true;
        }
        else if(root ==null || subroot ==null ||root.data!=subroot.data){
            return false;
        }
        if(!isidentical(root.left, subroot.left)) return false;
        if(!isidentical(root.right, subroot.right)) return false;
        return true;
    }
    public static Boolean issubtree(Node root,Node subroot){
        if(root==null){
            return true;
        }
        if(root.data==subroot.data){
            if(isidentical(root, subroot)) return true;
        }
        
        return issubtree(root.left, subroot) || issubtree(root.right, subroot);
    }
    
    /////////////outone//////////////222////////
}

public static Node lca2(Node root,int n1,int n2){
    if(root==null||root.data==n1||root.data==n2){
        return root;
    }
    Node leftlca=lca2(root.left, n1, n2);
    Node righlca=lca2(root.right, n1, n2);
    if(leftlca==null){
        return righlca;
        }
        if(righlca==null){
            return leftlca;
        }
    
        return root;
    }
    public static int lcaDist(Node root,int n1){
        if(root==null){
            return -1;
        }
        if(root.data==n1){
            return 0;
        }
        int leftdis=lcaDist(root.left, n1);
        int rightdis=lcaDist(root.right, n1);
        if(leftdis ==-1 && rightdis==-1){
            return -1;
        }
        else if(leftdis==-1){
            return rightdis+1;
            
        }
        else{
            return leftdis+1;
    }
    }
    
    public static int minDist(Node root,int n1,int n2){
    Node lca=lca2(root,n1,n2);
    int dist1=lcaDist(lca,n1);
    int dist2=lcaDist(lca,n2);
    
    return dist1+dist2;
}

public static class Info{
        Node node;
        int hd;
        
        public  Info(Node node,int hd){
            this.node=node;
            this.hd=hd;
        }
        
    }
public static void topview(Node root){
    Queue<Info> q=new LinkedList<>();
    HashMap<Integer,Node> map=new HashMap<>();
    int min=0,max=0; 
    q.add(new Info(root, 0));
    q.add(null); 
    
        while(!q.isEmpty()){
            Info curr=q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{  
                

        if(!map.containsKey(curr.hd)){
            map.put(curr.hd, curr.node);
        }
        //now getting hd of node left and rigt
        if(curr.node.left !=null){
            // map.put(key, value)
            q.add(new Info(curr.node.left, curr.hd-1));
            min=Math.min(min, curr.hd-1);
        }
        if(curr.node.right !=null){
            // map.put(key, value)
            q.add(new Info(curr.node.right, curr.hd+1));
            max=Math.max(max, curr.hd+1);
        }
    }
       
    }
    ArrayList<Integer> arr=new ArrayList<>() ;

    for (int i = min; i <= max; i++) {
        arr.add(map.get(i).data);
        // System.out.println(map.get(i).data+" ") ;
    }
    // Collections.reverse(arr);
    System.out.println(arr);

    }

    public static Boolean isidentical(Node root,Node subroot){
        if(root ==null && subroot ==null){
            return true;
        }
        else if(root ==null || subroot ==null ||root.data!=subroot.data){
            return false;
        }
        if(!isidentical(root.left, subroot.left)) return false;
        if(!isidentical(root.right, subroot.right)) return false;
        return true;
    }

    public static Boolean issubtree(Node root,Node subroot){
        if(root==null){
            return true;
        }
        List<Integer> arr = new ArrayList<Integer>();
        // arr.get(index);
        if(root.data==subroot.data){
            if(isidentical(root, subroot)) return true;
        }

        return issubtree(root.left, subroot) || issubtree(root.right, subroot);
    }

    
    public static void main (String args[]){
           /* 1
            /  \
           2    3
          / \  / \
         4  5 6   7
         
           */
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.right.right=new Node(7);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
           /*
            2    
           / \  
          4  5 
            */
        Node sroot=new Node(2);
        sroot.left=new Node(4);
        sroot.right=new Node(5);
        // System.out.println(issubtree(root,sroot));
        topview(root);
        // System.out.println();
        minDist(root,4,3);
        System.out.println(minDist(root, 4, 3));
    }
}
