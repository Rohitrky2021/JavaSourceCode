public class learlastith {
    public static int  clearlast(int a,int i) {
        int bitmas = (~(0))<<i;

        return a&bitmas;
    }
    public static void main(String[] args) {
         int a = 15;
         int i = 2;

         System.out.print(clearlast(a,i));
    }
    
}
