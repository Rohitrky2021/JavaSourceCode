public class friendspairing {
    public static void main(String args[]){
       System.out.println(frndpair(10)); 

    }
    public static int frndpair(int n){
        if(n==1 || n==2){
            return n;
        }
        else{
        return frndpair(n-1)/*single choices */ + (n-1) *frndpair(n-2)/*pairs */ ;   }
    }

   ////////////patym binary string problem\\\\\\\\\\\\\\\\\\\
   public static void binarystrin(String xyz){
    
   }

}
