public class expo {
    public static int  fastexpo(int a , int n) {
    int ans =1;
        while(n>0){
            if((n&1)!=0){
                ans=ans*a;
            }
            a=a*a;
            n=n>>1;
        }
        return ans;
    }
    public static void main(String[] args) {
        int a = 5 ;
        int b = 3 ; 

        System.out.print(fastexpo(a,b));
    }
}
