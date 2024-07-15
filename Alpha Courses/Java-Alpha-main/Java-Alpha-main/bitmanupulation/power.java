public class power {
    public static boolean power(int n){
        int bit = n&(n-1);
        if(bit==0){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        int n = 7;
        System.out.print(power(n));
    }
    
}
