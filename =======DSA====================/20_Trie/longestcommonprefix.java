public class longestcommonprefix{
    
    public class Node{
        Node[] link = new Node[26];
        boolean finished = false;
    }
    
    public boolean containsKey(char c, Node node){
        return node.link[c-'a']!=null ? true : false;
    }
    
    public void put(char c,Node node){
        node.link[c-'a']=new Node();
        return;
    }
    
    public void completed(Node node){
        node.finished = true;
    }
    
    public Node get(char c,Node node){
        return node.link[c-'a'];
    }
    
    public void insert(String s,Node root){
        Node node = root;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(!containsKey(c,node)){
                put(c,node);
            }  
            node = get(c,node);
        }
        completed(node);
    }
    
    public void search(Node root, int[] con ){
        Node node = root,move = null;
        int count = 0;
        for(int i =0;i<26;i++){
            if(node.link[i]!=null){
                count++;
                move=node.link[i];
            }
        }
        
        if(count==1 ){
            con[0]++;
            if(!move.finished)
            search(move,con);
        }
        return;
        
    }
    
    public String longestCommonPrefix(String[] strs) {
        
        int str[]={s1,s2,s3};
        Node root = new Node();
        for(int i = 0;i<strs.length;i++){
            if(strs[i].length()==0)
                return "";
            insert(strs[i],root);
        }
        String ans = "";
        int[] con = {0};
        search(root,con);
        
        int j = 0;
        while(strs[j].length()==0)
            j++;
        for(int i = 0;i<con[0];i++){
            ans+=strs[j].charAt(i);

        }
        
        return ans;
    }
}