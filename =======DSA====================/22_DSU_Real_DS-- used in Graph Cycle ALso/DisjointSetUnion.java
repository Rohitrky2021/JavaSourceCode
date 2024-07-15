public class DisjointSetUnion {

    // ver Efficient algo its TC---is->O(4)--->aprox-O(1);

    static int n=7;

    static int[] rank=new int[n];
    static int[] par=new int[n];;
    static void init(){
        for (int i = 0; i < n; i++) {
            par[i]=i;
        }
    }

    static int  find(int x){
        if(x==par[x]){
            return x;
        }
        return find(par[x]);
    }
    static void union(int a,int b){
        int parA=find(a);
        int parB=find(b);

        if(rank[parA]==rank[parB]){
            par[parB]=parA;
            rank[parA]++;
        }else if(rank[parA]<rank[parB]){
            par[parA]=parB;
        }else{
            par[parB]=parA;
        }
    }
    public static void main(String[] args) {
        init();
        union(1, 3);
        System.out.println(find(3));
        union(2, 4);
        union(2, 1);
        System.out.println(find(1));
        System.out.println(find(3));

        
    }
}
