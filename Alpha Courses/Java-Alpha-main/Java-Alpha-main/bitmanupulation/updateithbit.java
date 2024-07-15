
public class updateithbit {

    public static int setith(int a,int i) {            
        return a | (1<<i);            
    }
    public static int clearith(int a,int i) {            
        return a & (~(1<<i));            
    }

    public static int updateith(int a, int i ,int update){
            a= clearith(a,i);
            return a | (update<<i);
    }
    public static void main(String[] args) {
        int a = 10;
        int i = 2;
        int update  = 0;

        System.out.println(updateith(a,i,update));
    }
}
