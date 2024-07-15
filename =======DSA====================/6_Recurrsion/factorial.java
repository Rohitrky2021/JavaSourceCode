public class factorial {
    public static void main(String args[]){
        // System.out.println(facto(8)); 
        System.out.println(sumofn(5)); 
    }
    public static int facto(int x){
        if(x==0){
            return 1;
        }
        else{
        return x*facto(x-1);
        }

    }
    static int ans=0;
    public static int sumofn(int x){
        if(x==0){
            return 0;
        }
        System.out.println(ans+=x);
         return sumofn(x-1)+x;
        
        // sumofn(x-1);
    }
}
