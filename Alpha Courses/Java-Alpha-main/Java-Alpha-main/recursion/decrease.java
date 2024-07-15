public class decrease{
    public static int optpower(int n,int r){
        if(r==0){
            return 1;
        }
        int half = optpower(n, r/2);
        int halfpow = half*half;

        if(r%2!=0){
            halfpow=halfpow*n;
        }
        return halfpow;
    }
    public static void main(String[] args) {
        int n=2,r=1;
        int ans=optpower(n,r);
        System.out.println(ans);
    }
}