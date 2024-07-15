 
//  https://leetcode.com/discuss/interview-question/125263/construct-huffman-tree/124125

// Given a list of character and the frequencies they appear. Construct a Huffman Tree to encode all character.

class code {
    public ArrayList<String> huffmanCodes(String S, int f[], int N)  // S->Unique Characters, f->frequency of each character, N->total number of unique characters
    {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->{
            if(a.data!=b.data) return a.data-b.data; 
            return 1; // to maintain the order in which they are given. 
        });
        for(int i=0;i<N;i++){
            pq.add(new Node(f[i],S.charAt(i),null,null));
        }
        
        while(pq.size()>1){
            Node a = pq.poll();
            Node b = pq.poll();
            
            Node new_node = new Node(a.data+b.data,'_',a,b);
            pq.add(new_node);
        }
        
        ArrayList<String> ans = new ArrayList<>();
        preOrder(pq.remove(),"",ans);
        return ans;
    }
    private void preOrder(Node root,String t,ArrayList<String> ans){
        if(root==null) return;
        if(root.left==null && root.right==null){
            ans.add(t);
        }
        preOrder(root.left,t+"0",ans);
        preOrder(root.right,t+"1",ans);
    }
}
class Node{
    int data;
    char c;
    Node left,right;
    public Node(int data,char c,Node left,Node right){
        this.data=data;
        this.c=c;
        this.left=left;
        this.right=right;
    }
}