public class clearithbit {
    public static int clearith(int a,int i) {            
        return a & (~(1<<i));            
    }
    public static void main(String[] args) {
        int a = 10;
        int i  = 1; 
       System.out.println(clearith(a,i));
}   
}
