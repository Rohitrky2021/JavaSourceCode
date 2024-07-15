import java.util.ArrayList;

public class mergebst {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left =this.right =null;
        }
    }
    public static void getInorder(Node root , ArrayList<Integer> arr){
        if(root == null){
            return;
        }
        getInorder(root.left, arr);
        arr.add(root.data);
        getInorder(root.right, arr);
    }
    public static Node createbst(ArrayList<Integer> arr , int si , int en){
        if(si > en ){
            return null;
        }
        int mid  = (si + en )/2;
        Node root  =  new Node(arr.get(mid));
        root.left = createbst(arr,si, mid-1);
        root.right = createbst(arr,mid+1, en);
        return root;
    }
    public static Node merge(Node root1 , Node root2){
        // get arr of bst 1 ;
        ArrayList<Integer> arr1  = new ArrayList<>();
        getInorder(root1 ,arr1);
         // get arr of bst 2 ;
        ArrayList<Integer> arr2  = new ArrayList<>();
        getInorder(root2 ,arr2);
        int i=0 , j =0 ;
        // 1 2 4 // 3 9 12 
        // merge both arr in sorted order
        ArrayList<Integer> finalarr = new ArrayList<>();
        while(i < arr1.size() && j < arr2.size() ){
            if(arr1.get(i) <= arr2.get(j)){
                finalarr.add(arr1.get(i));
                i++;
            }else{
                finalarr.add(arr2.get(j));
                j++;
            }
        }
        while(i < arr1.size()){
            finalarr.add(arr1.get(i));
                i++;
        }
        while(j < arr2.size()){
            finalarr.add(arr2.get(j));
                j++;
        }
       return createbst(finalarr,0, finalarr.size()-1);
    }
    public static void preorder ( Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        // bst 1st
        Node root1  = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);
        // bst 2nd
        Node root2  = new Node(9);
        root2.left = new Node(3);
        root2.right =new Node(12);
        Node roots = merge(root1, root2);
        preorder(roots);     
    }
}
