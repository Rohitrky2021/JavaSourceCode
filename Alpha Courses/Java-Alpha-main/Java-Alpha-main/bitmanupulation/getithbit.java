public class getithbit {
    public static int getith(int a,int i) {
        int x = a & (1<<i);
        return x>>i;
        
    }
    public static void main(String[] args) {
        int a = 10;
        int i  = 2; 

        System.out.println(getith(a,i));
    }
    
}
