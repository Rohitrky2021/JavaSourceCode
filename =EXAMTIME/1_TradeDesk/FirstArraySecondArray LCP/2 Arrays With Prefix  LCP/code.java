public class code {
    
}
struct Node{
    Node* links[10];
    bool end=false;
    bool containskey(char ch){
        return links[ch-'0']!=NULL;
    }
    void put(char ch,Node* node){
        links[ch-'0']=node;
    }
    Node* get(char ch){
        return links[ch-'0'];
    }
    void end1(){
        end=true;
    }
    bool isend(){
        return end;
    }
};
class Trie{
    private:
    Node* root;
    public:
    Trie() {
       root=new Node();
    }
    
    void insert(string word) {
        int l=word.size();
        Node* node=root;
        for(int i=0;i<l;i++)
        {
            if(!node->containskey(word[i]))
            {
                node->put(word[i],new Node());
            }
            node=node->get(word[i]);
        }
        node->end1();
    }
    
    int search(string word) {
        int l=word.size();
        Node* node=root;
        int ans=0;
        for(int i=0;i<l;i++)
        {
            if(!node->containskey(word[i]))
            {
                return ans;
            }
            else{
                ans++;
            }
            node=node->get(word[i]);
        }
        return ans;
    }
};

ll solve(vector<ll>a,vector<ll>b){
    Trie* t=new Trie;
   for(auto x:a){
       string s=to_string(x);
    t->insert(s);
       
   }
   int ans=0;
   for(auto x:b){
       string s=to_string(x);
       ans=max(ans,t->search(s));
   }
   return ans;
}