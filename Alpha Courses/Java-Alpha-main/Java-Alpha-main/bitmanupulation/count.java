public class count {
    public static int countset(int n) {
        int count = 0;
        while(n!=0){
            if((n&1)==1){
                count++;
                n=n>>1;
            }
                n=n>>1;
            
        }
        return count;
    }
    public static void main(String[] args) {
        int n=15;
        System.out.println(countset(n));
    }
    
}
